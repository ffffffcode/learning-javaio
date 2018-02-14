package ex.aaronfae.javaio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RWDemo {

	public static void main(String[] args) throws IOException {

		FileInputStream in = new FileInputStream(new File("C:\\Users\\AaronFae\\Downloads\\1.txt"));
		InputStreamReader isr = new InputStreamReader(in);

		FileOutputStream out = new FileOutputStream(new File("C:\\Users\\AaronFae\\Downloads\\2.txt"));
		OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");

		char[] cbuf = new char[8 * 1024];
		int c = 0;
		while ((c = isr.read(cbuf)) != -1) {
			osw.write(cbuf, 0, c);
		}
		osw.flush();
		isr.close();
		osw.close();
	}
}
