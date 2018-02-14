package ex.aaronfae.javaio;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {

		File file1 = new File("D:" + File.separator + "javaio");
		if (!file1.exists()) {
			file1.mkdirs();
		} else {
			file1.delete();
		}
		System.out.println(file1.isDirectory());
		System.out.println(file1.isFile());

		File file2 = new File("D:" + File.separator + "ss.txt");
		if (!file2.exists()) {
			try {
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			file2.delete();
		}

		System.out.println(file2.getName());
		System.out.println(file2.getPath());
		System.out.println(file2.getParent());
		System.out.println(file2.getAbsolutePath());
	}

}
