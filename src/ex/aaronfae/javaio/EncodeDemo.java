package ex.aaronfae.javaio;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {

		String s = "����af";

		byte[] b1 = s.getBytes();// ת�����ֽ������õ�����ĿĬ�ϵı���GBK
		for (byte b : b1) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println("---  GBK");

		byte[] b2 = s.getBytes("gbk");
		// gbk��������ռ��2���ֽڣ�Ӣ��ռ��1���ֽ�
		for (byte b : b2) {
			System.out.print(Integer.toHexString(b & 0xff) + "  ");
		}
		System.out.println("---  gbk");

		byte[] b3 = s.getBytes("utf-8");
		// utf-8��������ռ��3���ֽڣ�Ӣ��ռ��1���ֽ�
		for (byte b : b3) {
			System.out.print(Integer.toHexString(b & 0xff) + "  ");
		}
		System.out.println("---  utf-8");

		// Java��˫�ֽڱ���-->uft-16be
		byte[] b4 = s.getBytes("utf-16be");
		// uft-16be����������ռ��2���ֽڣ�Ӣ��ռ��2���ֽ�
		for (byte b : b4) {
			System.out.print(Integer.toHexString(b & 0xff) + "  ");
		}
		System.out.println("---  utf-16be");

		/*
		 * ������ֽ�������ĳ�ֱ���ʱ�����ʱ������ֽ����б���ַ��� Ҳ��Ҫ�����ֱ��룬���߻��������
		 */
		String s1 = new String(b3, "utf-8");
		System.out.println(s1);
		String s2 = new String(b3);
		System.out.println(s2);
	}
}
