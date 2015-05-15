package summon;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	public static String encodeMD5String(String str, String method) {
		MessageDigest md = null;
		String dstr = null;
		try {
			md = MessageDigest.getInstance(method);
			md.update(str.getBytes());
			byte[] s = md.digest();
			dstr = hex2String(s);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return dstr;
	}
	
	// 十六进制转换为字符串类型
	private static String hex2String(byte[] s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length; ++i) {
			sb.append(Integer.toHexString((s[i] & 0XFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String str = "这是要Hash的明文。";
		System.out.println("HASH前明文:" + str);
		System.out.println("MD2HASH后:" + encodeMD5String(str, "MD2"));
		System.out.println("MD5HASH后:" + encodeMD5String(str, "MD5"));
	}
}
