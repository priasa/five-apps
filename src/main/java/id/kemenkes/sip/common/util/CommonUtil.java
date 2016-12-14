package id.kemenkes.sip.common.util;

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


}
