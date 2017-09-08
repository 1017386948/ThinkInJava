package io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BytesInfo {
	static String fileName = "E:\\Java\\Tomcat\\apache-tomcat-8.5.16\\RUNNING.txt";

	public static void main(String[] args) {
		Map<Byte, Integer> bytesStat = new HashMap<>();
		try {
			byte[] data = BinaryFile.read(fileName);
			for (Byte b : data) {
				Integer freq = bytesStat.get(b);
				bytesStat.put(b, freq == null ? 1 : freq + 1);
			}
			List<Byte> keys = new ArrayList<Byte>(bytesStat.keySet());
			Collections.sort(keys);
			for (Byte key : keys)
				System.out.println(key + " => " + bytesStat.get(key));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
