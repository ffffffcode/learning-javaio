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

		raf.write('A');// ֻд1���ֽ�
		System.out.println("�ļ�����" + raf.length());
		System.out.println("ָ��λ��" + raf.getFilePointer());

		int i = 0x7fffffff;
		// ��write(int b)����д��ÿ��ֻ��д1���ֽڣ����Ҫ��iд��ȥ�͵�д4��
		raf.write(i >>> 24);// ��8λ
		raf.write(i >>> 16);
		raf.write(i >>> 8);
		raf.write(i);
		System.out.println("ָ��λ��" + raf.getFilePointer());

		raf.seek(1);
		int a = raf.readInt();
		System.out.println(Integer.toHexString(a));

		// ֱ��дint
		raf.writeInt(66);
		System.out.println("ָ��λ��" + raf.getFilePointer());
		raf.seek(5);
		System.out.println(raf.readInt());

		// д�ַ�
		String s = "��";
		byte[] b = s.getBytes("utf-8");
		raf.write(b);
		System.out.println("�ļ�����" + raf.length());

		raf.seek(9);
		byte[] bytes = new byte[3];
		raf.read(bytes);
		String str = new String(bytes, "utf-8");
		System.out.println(str);

		// ͨ����intת����String��д��
		int n = 90;
		String w = Integer.toString(n);
		byte[] y = w.getBytes();
		raf.write(y);

		// ���ļ��������ָ���Ƶ�ͷ��
		raf.seek(0);
		byte[] byteAll = new byte[(int) raf.length()];
		raf.read(byteAll);
		String strAll = new String(byteAll, "utf-8");
		System.out.println(strAll);
		raf.close();
	}
}
