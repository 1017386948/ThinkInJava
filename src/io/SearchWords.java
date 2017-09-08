package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

import net.mindview.util.TextFile;

public class SearchWords {
	public static void main(String[] args) {
		File path = new File("E:\\Java\\ThinkInJava\\src\\containers");
		String[] list;
		if (args.length == 0)
			list = path.list();
		else
			list = path.list(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return TextFile.read(dir.getPath() + "\\" + name).contains(args[0]);
				}

			});
		System.out.println(Arrays.toString(list));
	}
}
