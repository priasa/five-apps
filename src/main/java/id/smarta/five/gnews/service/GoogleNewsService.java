package id.smarta.five.gnews.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.smarta.five.common.util.CommonUtil;
import id.smarta.five.gnews.dao.GoogleNewsRepository;
import id.smarta.five.gnews.entity.GoogleNews;
import id.smarta.five.masterdata.entity.MasterData;
import id.smarta.five.masterdata.entity.MasterDataContent;
import id.smarta.five.masterdata.service.MasterDataService;

/**
 * 
 * @author X230
 *
 */
@Service
public class GoogleNewsService {

	static final Logger LOGGER = LoggerFactory.getLogger(GoogleNewsService.class);

	@Autowired
	MasterDataService masterDataService;
	
	@Autowired
	GoogleNewsRepository googleNewsRepository;
	
	public void doStream() throws InterruptedException, NoSuchAlgorithmException {
		MasterData masterData = masterDataService.findMasterDataByName(MasterDataService.GNEWS);
		List<MasterDataContent> masterDataContent = masterDataService.getMDContentParentById(masterData.getId());
		if (masterDataContent != null) {
			for (MasterDataContent mdc : masterDataContent) {
				callGoogleSearch(mdc);
			}
			Thread.sleep(30000);
		}
	}

	private void callGoogleSearch(MasterDataContent mdc) throws NoSuchAlgorithmException {
		Set<GoogleNews> result = new HashSet<GoogleNews>();
		String request = "https://www.google.com/search?q=" + mdc.getFieldValue() + "&num=100&tbm=nws&tbs=qdr:d";
		LOGGER.info("Sending request..." + request);

		try {
			// need http protocol, set this as a Google bot agent :)
			Document doc = Jsoup.connect(request)
					.userAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)").timeout(5000)
					.get();

			Element searchResult = doc.select("div#ires").first();
			if (searchResult != null) {
				Elements content = searchResult.select("td");
				for (Element c : content) {
					String thumbnail = null;
					Element img = c.select("img").first();
					if (img != null) {
						thumbnail = img.attr("src");
					}
					
					Element link = c.select("a[href]").first();
					if (link != null) {
						String tempLink = link.attr("href");
						if (tempLink != null) {
							if (tempLink.startsWith("/url?q=")) {
								String url = extractUrl(link.attr("href"));
								
								String headline = link.text();
								
								String mediaName = "null";
								String title = "null";
								Date createdDate = null;
								
								Element slp = c.select("div.slp").first();
								if (slp != null) {
									Element span_f = slp.select("span.f").first();
									if (span_f != null) {
										String mediaNameAndCreatedDate = span_f.text();
										if (!mediaNameAndCreatedDate.isEmpty()) {
											mediaNameAndCreatedDate = mediaNameAndCreatedDate.replaceAll(" ", "").replaceAll("[^a-zA-Z0-9()!@#$&*<>.-]+", "#");
											Pattern pattern = Pattern.compile("(.*?)#-(\\d+)(.*?)ago");
											LOGGER.info(mediaNameAndCreatedDate);

											Matcher matcher = pattern.matcher(mediaNameAndCreatedDate);
											
											String quantity = null;
											String quantityTypes = null;
											while (matcher.find()) {
												mediaName = matcher.group(1);
											    quantity = matcher.group(2);
											    quantityTypes = matcher.group(3);
											}
											
											if (quantityTypes != null) {
												if (quantityTypes.contains("minute")) {
													createdDate = new Date();
												}
												
												if (quantityTypes.contains("hour") ) {
													Calendar cal = new GregorianCalendar();
													cal.add(Calendar.HOUR_OF_DAY, -1*(Integer.parseInt(quantity)));
													createdDate = cal.getTime();
												}
												
												if (quantityTypes.contains("day")) {
													Calendar cal = new GregorianCalendar();
													cal.add(Calendar.DAY_OF_MONTH, -1*(Integer.parseInt(quantity)));
													createdDate = cal.getTime();
												}
											}
										}

									}
								}
								Element st = c.select("div.st").first();
								if (st != null) {
									title = st.text();
								}
								
								if (url != null && !headline.isEmpty()) {
									GoogleNews resultModel = new GoogleNews();
									resultModel.setCreatedDate(createdDate);
									resultModel.setHeadline(headline);
									resultModel.setKeyword(mdc.getCode());
									resultModel.setMediaName(mediaName);
									resultModel.setTitle(title);
									resultModel.setUrl(url);
									if (url != null) {
										resultModel.setHtmlCode(loadHtmlContent(url));
										System.out.println("###"+resultModel.getHtmlCode());
									}
									resultModel.setThumbnail(thumbnail);
									
									String hashCode = CommonUtil.md5Hash(resultModel.getUrl());
									resultModel.setHashCode(hashCode);
									result.add(resultModel);
								}
							}
						}
					}
					
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		if (!result.isEmpty()) {
			googleNewsRepository.saveAll(result);
		}
	}

	private String loadHtmlContent(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		LOGGER.info("\nSending 'GET' request to URL : " + url);
		LOGGER.info("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer sb = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			sb.append(inputLine);
		}
		in.close();
		return sb.toString();
	}

	private String extractUrl(String link) {
		String result = null;
		Pattern pattern = Pattern.compile("([\\s\\S]*)q=(.*?)&([\\s\\S]*)");
		Matcher matcher = pattern.matcher(link);
		
		while (matcher.find()) {
		    result = matcher.group(2);
		}
		
		return result;
	}

	
	
}

