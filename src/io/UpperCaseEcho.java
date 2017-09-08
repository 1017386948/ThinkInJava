package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpperCaseEcho {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null && line.length() != 0)
			System.out.println(line.toUpperCase());

	}
}
