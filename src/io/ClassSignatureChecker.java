package io;

import java.io.File;
import java.io.IOException;

public class ClassSignatureChecker {
	final private static String dir = "E:\\Java\\ThinkInJava\\bin";
	final private static String regex = ".*\\.class";
	final static byte[] signature = { (byte) 202, (byte) 254, (byte) 186, (byte) 190 };

	public static void main(String[] args) {
		try {
			for (File file : Directory.walk(dir, regex).files) {
				byte[] bt = BinaryFile.read(file.getAbsolutePath());
				for (int i = 0; i < signature.length; i++)
					if (bt[i] != signature[i]) {
						System.err.println(file + " is corrupt!");
						break;
					}
			}
			System.out.println("All matched!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
