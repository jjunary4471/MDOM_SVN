package common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtility {
	
	public static boolean checkEqual(String str1, String str2) {
		if (str1 == str2) {
			return true;
		}
		if (str1 == null || str2 == null) {
			return false;
		}
		if (str1.equals(str2)) {
			return true;
		}
		return false;
	}
	
	
	public static String getSHA256(String str) {
		String SHA;
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			SHA = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}
		return SHA;
	}
	
	
}
