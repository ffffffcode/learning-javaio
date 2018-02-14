package ex.aaronfae.javaio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo {

	public void copy(File src, File dest) throws IOException {

		if (!src.exists()) {
			throw new IllegalArgumentException("�ļ���" + src + "������");
		}
		if (!src.isFile()) {
			throw new IllegalArgumentException(src + "�����ļ�");
		}

		FileInputStream in = new FileInputStream(src);
		FileOutputStream out = new FileOutputStream(dest);

		byte[] bs = new byte[8 * 1024];
		int i = 0;
		while ((i = in.read(bs, 0, bs.length)) != -1) {
			out.write(bs, 0, i);
			out.flush();
		}

		in.close();
		out.close();
	}

	public static void main(String[] args) {
		FileCopyDemo copyDemo = new FileCopyDemo();
		try {
			copyDemo.copy(new File("C:\\Users\\AaronFae\\Downloads\\1.pdf"),
					new File("C:\\Users\\AaronFae\\Downloads\\2.pdf"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
