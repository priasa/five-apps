package id.smarta.five.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class CommonUtil {
	
	public static String addWildCard(String name){
		StringBuilder wildCardName = new StringBuilder();
		
		if(!StringUtils.isEmpty(name)){
			wildCardName = new StringBuilder(name);
		}
		
		if(!StringUtils.startsWith(name, "%")){
			wildCardName.insert(0, "%");
		}
		if(!StringUtils.endsWith(name, "%")){
			wildCardName.append("%");
		}
		return wildCardName.toString();
	}
	
	public static String ByteArrayToBase64(final byte[] bmp) {
        try {
            String temp = Base64.encodeBase64String(bmp);
            return temp;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public static String generateRandomPassword(String keyword) {
        String characters = "23456789ABCDEFGHJKMNPQRSTUVWXYZabcdefghjkmnopqrstuvwxyz";

        String weirdCombination = "";
        if (org.apache.commons.lang.StringUtils.isNotBlank(keyword)) {
            weirdCombination = keyword.trim();
        }
        weirdCombination += String.valueOf(System.currentTimeMillis()) + characters;
        weirdCombination = weirdCombination.replaceAll("1", "").replaceAll("i", "").replaceAll("0", "").replaceAll("o", "").replaceAll("L", "").replaceAll("l", "");
        String result = RandomStringUtils.random(6, 0, 0, true, true, weirdCombination.toCharArray(), new SecureRandom());

        return result;
    }
	
	public static String md5Hash(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(text.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		
		return sb.toString();
	}


}
