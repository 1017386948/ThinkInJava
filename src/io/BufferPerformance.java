package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BufferPerformance {
	static String name = "E:\\Java\\ThinkInJava\\src\\io\\LineNumber.java";

	public static void main(String[] args) {
		try {
			List<String> list = FileIntoList.read(name);
			PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\10173\\Desktop\\demo2.txt"));
			int lineCount = 1;
			long t1 = System.currentTimeMillis();
			for (String s : list) {
				for (int i = 0; i < 100000; i++)
					out.println(lineCount + ": " + s);
				lineCount++;
			}
			long t2 = System.currentTimeMillis();
			System.out.println("unbuffered: " + (t2 - t1));
			out.close();
			out = new PrintWriter(new BufferedWriter(new FileWriter("G:\\demo2.txt")));
			lineCount = 1;
			t1 = System.currentTimeMillis();
			for (String s : list) {
				for (int i = 0; i < 100000; i++)
					out.println(lineCount + ": " + s);
				lineCount++;
			}
			t2 = System.currentTimeMillis();
			System.out.println("buffered: " + (t2 - t1));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
