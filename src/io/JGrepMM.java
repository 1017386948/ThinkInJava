package io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrepMM {
	static String file = "E:\\Java\\ThinkInJava\\src\\io\\JGrepMM.java";
	static String regex = "\\w+";

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Pattern p = Pattern.compile(regex);
		FileChannel fc = new RandomAccessFile(file, "rw").getChannel();
		ByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
		CharBuffer cb = Charset.forName(System.getProperty("file.encoding")).decode(bb);
		String[] fileAsArray = cb.toString().split("\n");
		int index = 0;
		Matcher m = p.matcher("");
		for (String line : fileAsArray) {
			m.reset(line);
			while (m.find())
				System.out.println(index++ + ": " + m.group() + ": " + m.start());
		}
		fc.close();
	}
}
