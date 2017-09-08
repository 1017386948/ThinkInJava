package io;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class CountLines {
	static String name = "E:\\Java\\ThinkInJava\\src\\io\\LineNumber.java";

	public static void main(String[] args) {
		LineNumberReader in;
		PrintWriter pw = null;
		try {
			in = new LineNumberReader(new FileReader(name));
			pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\10173\\Desktop\\demo2.txt")));
			String line;
			while ((line = in.readLine()) != null) {
				pw.println(in.getLineNumber() + ": " + line);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
}
