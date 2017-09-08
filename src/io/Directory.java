package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Directory {
	public static File[] local(File dir, String regex) {
		return dir.listFiles(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(new File(name).getName()).matches();
			}

		});
	}

	public static File[] local(String dir, String regex) {
		return local(new File(dir), regex);
	}

	public static class TreeInfo implements Iterable<File> {
		public List<File> files = new ArrayList<>();
		public List<File> dirs = new ArrayList<>();

		@Override
		public Iterator<File> iterator() {
			return files.iterator();
		}

		void addAll(TreeInfo other) {
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}

		public String toString() {
			return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: " + PPrint.pformat(files);
		}

	}

	public static TreeInfo walk(String start, String regex) { // Begin recursion
		return recurseDirs(new File(start), regex);
	}

	public static TreeInfo walk(File start, String regex) {
		return recurseDirs(start, regex);
	}

	public static TreeInfo walk(File start) { // Everything
		return recurseDirs(start, ".*");
	}

	public static TreeInfo walk(String start) {
		return recurseDirs(new File(start), ".*");
	}

	private static TreeInfo recurseDirs(File startDir, String regex) {
		TreeInfo result = new TreeInfo();
		for (File item : startDir.listFiles()) {
			if (item.isDirectory()) {
				result.dirs.add(item);
				result.addAll(recurseDirs(item, regex));
			} else if (item.getName().matches(regex))
				result.files.add(item);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeInfo result = null;
		if (args.length == 0) {
			result = walk(".\\src\\Interface");
		} else
			for (String arg : args)
				result = walk(arg);
		long size = 0L;
		for (File file : result.files)
			size += file.length();
		System.out.println(size);
	}

}
