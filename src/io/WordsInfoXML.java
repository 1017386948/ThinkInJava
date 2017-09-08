package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import nu.xom.Document;
import nu.xom.Element;

public class WordsInfoXML {
	public static Element getXML(Map.Entry<String, Integer> me) {
		Element record = new Element("recode");
		Element word = new Element("word");
		word.appendChild(me.getKey());
		Element freq = new Element("frequency");
		freq.appendChild(me.getValue().toString());
		record.appendChild(word);
		record.appendChild(freq);
		return record;
	}

	public static void main(String[] args) throws Exception {
		Map<String, Integer> wordsStat = new HashMap<String, Integer>();
		for (String word : new TextFile("E:\\Java\\ThinkInJava\\src\\io\\WordsInfoXML.java", "\\W+")) {
			Integer freq = wordsStat.get(word);
			wordsStat.put(word, freq == null ? 1 : freq + 1);
		}
		Element root = new Element("words");
		for (Map.Entry<String, Integer> me : wordsStat.entrySet())
			root.appendChild(getXML(me));
		Document doc = new Document(root);
		Person.format(System.out, doc);
		Person.format(new BufferedOutputStream(new FileOutputStream("WordsInfo.xml")), doc);
	}
}
