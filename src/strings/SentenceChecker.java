package strings;

public class SentenceChecker {
	static boolean matches(String text) {
		return text.matches("^[A-Z].*[\\.]$");
	}
	public static void main(String[] args) {
//		System.out.println(matches("This is correct."));
		System.out.println("hehe nimabi. ni shi gou.".replaceAll("(?i)[aeiou]","_"));
	}
}
