package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;
import static net.mindview.util.Print.*;

public class SortedDirList {
	private File path;

	public SortedDirList() {
		path = new File(".");
	}

	public SortedDirList(File path) {
		this.path = path;
	}

	public String[] list() {
		String[] list = path.list();
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		return list;
	}

	public String[] list(final String fn_regex) {
		String[] list = path.list(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(fn_regex);

			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		});
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		return list;
	}

	public void size(String[] list) {
		long total = 0;
		long fs;
		for (String dirItem : list) {
			fs = new File(path, dirItem).length();
			print(dirItem + ", " + fs + " byte(s)");
			total += fs;
		}
		print("=======================");
		print(list.length + " file(s), " + total + " bytes");
	}

	public static void main(String[] args) {
		SortedDirList dirList = new SortedDirList(new File("E:/Java/ThinkInJava/src/containers"));
		dirList.size(dirList.list("D.*/.java"));

	}
}
