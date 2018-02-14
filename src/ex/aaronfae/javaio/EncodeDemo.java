package ex.aaronfae.javaio;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {

		String s = "龙飞af";

		byte[] b1 = s.getBytes();// 转换成字节序列用的是项目默认的编码GBK
		for (byte b : b1) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println("---  GBK");

		byte[] b2 = s.getBytes("gbk");
		// gbk编码中文占用2个字节，英文占用1个字节
		for (byte b : b2) {
			System.out.print(Integer.toHexString(b & 0xff) + "  ");
		}
		System.out.println("---  gbk");

		byte[] b3 = s.getBytes("utf-8");
		// utf-8编码中文占用3个字节，英文占用1个字节
		for (byte b : b3) {
			System.out.print(Integer.toHexString(b & 0xff) + "  ");
		}
		System.out.println("---  utf-8");

		// Java是双字节编码-->uft-16be
		byte[] b4 = s.getBytes("utf-16be");
		// uft-16be编码吗中文占用2个字节，英文占用2个字节
		for (byte b : b4) {
			System.out.print(Integer.toHexString(b & 0xff) + "  ");
		}
		System.out.println("---  utf-16be");

		/*
		 * 当你的字节序列是某种编码时，这个时候想把字节序列变成字符串 也需要用这种编码，否者会出现乱码
		 */
		String s1 = new String(b3, "utf-8");
		System.out.println(s1);
		String s2 = new String(b3);
		System.out.println(s2);
	}
}
