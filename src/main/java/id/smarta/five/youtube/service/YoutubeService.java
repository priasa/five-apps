package id.smarta.five.youtube.service;

import java.io.IOException;
import java.io.Serializable;
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
import id.smarta.five.masterdata.entity.MasterData;
import id.smarta.five.masterdata.entity.MasterDataContent;
import id.smarta.five.masterdata.service.MasterDataService;
import id.smarta.five.youtube.dao.YoutubeRepository;
import id.smarta.five.youtube.entity.YoutubeEntity;

/**
 * 
 * @author smarta
 *
 */
@Service
public class YoutubeService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -450691154279457552L;

	static final Logger LOGGER = LoggerFactory.getLogger(YoutubeService.class);

	@Autowired
	MasterDataService masterDataService;
	
	@Autowired
	YoutubeRepository youtubeRepository;
	
	public void doStream() throws InterruptedException, NoSuchAlgorithmException {
		MasterData masterData = masterDataService.findMasterDataByName(MasterDataService.YOUTUBE);
		List<MasterDataContent> masterDataContent = masterDataService.getMDContentParentById(masterData.getId());
		if (masterDataContent != null) {
			for (MasterDataContent mdc : masterDataContent) {
				callYoutubeSearch(mdc);
			}
			Thread.sleep(30000);
		}
	}
	
	private void callYoutubeSearch(MasterDataContent mdc) throws NoSuchAlgorithmException {
		Set<YoutubeEntity> result = new HashSet<YoutubeEntity>();
		
		String request = "https://www.youtube.com/results?search_query=" + mdc.getFieldValue() + "&sp=EgIIBA%3D%3D";
		System.out.println("Sending request..." + request);

		try {
			Document doc = Jsoup.connect(request)
					.userAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)").timeout(5000)
					.get();

			Element searchResult = doc.select("div#results").first();
			Elements lookupContents = searchResult.select("div.yt-lockup-content");
			int i = 0;
			for (Element element : lookupContents) {
				YoutubeEntity searchResultModel = new YoutubeEntity();
				searchResultModel.setKeyword(mdc.getCode());
								
				Element title = element.select("h3.yt-lockup-title").first();
				if (title != null) {
					Element link = title.select("a[href]").first();
					if (link != null) {
						searchResultModel.setVideoUrl("youtube.com"+link.attr("href"));
						searchResultModel.setVideoTitle(removeComma(link.text()));
					}
				}
				
				Element byLine = element.select("div.yt-lockup-byline").first();
				if (byLine != null) {
					Element byLineLink = byLine.select("a[href]").first();
					if (byLineLink != null) {
						searchResultModel.setUserUrl("youtube.com" + byLineLink.attr("href"));
						searchResultModel.setUsername(removeComma(byLineLink.text()));
					}
				}
				
				Element lookupMeta = element.select("div.yt-lockup-meta").first();
				if (lookupMeta != null) {
					Element lookupMetaInfo = lookupMeta.select("ul.yt-lockup-meta-info").first();
					if (lookupMetaInfo != null) {
						Elements listofLI = lookupMetaInfo.select("li");
						for (Element li : listofLI) {
							String text = li.text();
							LOGGER.info("Meta info :"+text);
							if (text.contains("detik") || text.contains("menit") || text.contains("jam") || 
									text.contains("hari") || text.contains("minggu") || text.contains("bulan")) {
								Date createdDate = extractDate(text);
								searchResultModel.setCreatedDate(createdDate);
							} else {
								Pattern pattern = Pattern.compile("(\\d+)(.*?)");
								Matcher matcher = pattern.matcher(text);
								while (matcher.find()) {
								    searchResultModel.setTotalViews(Long.parseLong(matcher.group(1)));
								}
							}
						}
					}
				}
				String id = CommonUtil.md5Hash(searchResultModel.getUserUrl());
				searchResultModel.setHashCode(id);
				result.add(searchResultModel);
				
				i++;
			}
			LOGGER.info("total video : "+i);
		} catch (IOException e) {
			LOGGER.info(e.getMessage());
		}
		
		youtubeRepository.saveAll(result);
	}

	private Date extractDate(String text) {
		Date result = null;
		text = text.replace(" ", "__");
		Pattern pattern = Pattern.compile("([\\s\\S]*)(\\d+)__(.*?)__([\\s\\S]*)");
		Matcher matcher = pattern.matcher(text);
		
		String digit = null;
		String typeOfTime = null;
		while (matcher.find()) {
		    digit = matcher.group(2);
		    typeOfTime = matcher.group(3);
		}
		LOGGER.info("Type of time :"+typeOfTime);
		if (digit != null && typeOfTime != null) {
				if (typeOfTime.contains("detik") || typeOfTime.contains("menit")) {
					result = new Date();
				}
				
				if (typeOfTime.contains("jam") ) {
					Calendar cal = new GregorianCalendar();
					cal.add(Calendar.HOUR_OF_DAY, -1*(Integer.parseInt(digit)));
					result = cal.getTime();
				}
				
				if (typeOfTime.contains("hari")) {
					Calendar cal = new GregorianCalendar();
					cal.add(Calendar.DAY_OF_MONTH, -1*(Integer.parseInt(digit)));
					result = cal.getTime();
				}
				
				if (typeOfTime.contains("minggu")) {
					Calendar cal = new GregorianCalendar();
					cal.add(Calendar.DAY_OF_MONTH, -7*(Integer.parseInt(digit)));
					result = cal.getTime();
					
				}
				
				if (typeOfTime.contains("bulan")) {
					Calendar cal = new GregorianCalendar();
					cal.add(Calendar.MONTH, -1*(Integer.parseInt(digit)));
					result = cal.getTime();
					
				}
			
		}
		return result;
	}

	private String removeComma(String text) {
		if (text != null) {
			text = text.replaceAll("(\\r|\\n|\\r\\n)+", " ");
			text = text.replace(",", " ");
			return text;
		}
		return "null";
	}
}
