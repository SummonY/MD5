package summon;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class MD5 {
	
	public static String encodeMD5String(String str) {
		MessageDigest md = null;
		String dstr = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			dstr = new BigInteger(1, md.digest()).toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return dstr;
	}
	
	public static void main(String[] args) {
		String str = "My name is Summon Yang.";
		System.out.println("加密前明文:" + str);
		System.out.println("MD5加密后:" + encodeMD5String(str));
	}
}
