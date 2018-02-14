package ex.aaronfae.javaio;

import java.io.File;
import java.io.RandomAccessFile;

public class RafDemo {

	public static void main(String[] args) throws Exception {

		File dir = new File("file");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, "file.dat");
		if (!file.exists()) {
			file.createNewFile();
		}

		RandomAccessFile raf = new RandomAccessFile(file, "rw");

		raf.write('A');// 只写1个字节
		System.out.println("文件长度" + raf.length());
		System.out.println("指针位置" + raf.getFilePointer());

		int i = 0x7fffffff;
		// 用write(int b)方法写，每次只能写1个字节，如果要把i写进去就得写4次
		raf.write(i >>> 24);// 高8位
		raf.write(i >>> 16);
		raf.write(i >>> 8);
		raf.write(i);
		System.out.println("指针位置" + raf.getFilePointer());

		raf.seek(1);
		int a = raf.readInt();
		System.out.println(Integer.toHexString(a));

		// 直接写int
		raf.writeInt(66);
		System.out.println("指针位置" + raf.getFilePointer());
		raf.seek(5);
		System.out.println(raf.readInt());

		// 写字符
		String s = "向";
		byte[] b = s.getBytes("utf-8");
		raf.write(b);
		System.out.println("文件长度" + raf.length());

		raf.seek(9);
		byte[] bytes = new byte[3];
		raf.read(bytes);
		String str = new String(bytes, "utf-8");
		System.out.println(str);

		// 通过将int转换成String再写入
		int n = 90;
		String w = Integer.toString(n);
		byte[] y = w.getBytes();
		raf.write(y);

		// 读文件，必须把指针移到头部
		raf.seek(0);
		byte[] byteAll = new byte[(int) raf.length()];
		raf.read(byteAll);
		String strAll = new String(byteAll, "utf-8");
		System.out.println(strAll);
		raf.close();
	}
}
