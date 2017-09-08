package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileIntoList {
	public static List<String> read(String file) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(file));
		String s;
		List<String> text = new LinkedList<>();
		while ((s = bf.readLine()) != null)
			text.add(s);
		bf.close();
		return text;
	}

	public static void main(String[] args) {
		try {
			System.out.println(read("E:\\Java\\ThinkInJava\\src\\io\\LineNumber.java"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
