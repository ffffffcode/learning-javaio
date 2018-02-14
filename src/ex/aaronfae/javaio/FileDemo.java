package ex.aaronfae.javaio;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) throws Exception {

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

		File dir = new File("D:\\AFX");
		listDirectory(dir);
	}

	public static void listDirectory(File dir) throws IOException {

		if (!dir.exists()) {
			throw new IllegalArgumentException("目录：" + dir + "不存在");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + "不是目录");
		}

		File[] files = dir.listFiles();
		if (files != null && files.length > 0) {
			for (File file : files) {
				if (file.isDirectory()) {
					listDirectory(file);
				} else {
					System.out.println(file);
				}
			}
		}
	}

}
