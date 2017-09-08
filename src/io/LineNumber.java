package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumber {
	static String name = "E:\\Java\\ThinkInJava\\src\\io\\LineNumber.java";

	public static void main(String[] args) {
		BufferedReader br;
		PrintWriter pw = null;
		try {
			br = new BufferedReader(new FileReader(name));
			pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\10173\\Desktop\\demo.txt")));
			String line;
			int count = 1;
			while ((line = br.readLine()) != null) {
				pw.println(count++ + ": " + line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
}
