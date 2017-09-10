package enumerated;

import java.util.Random;

enum CartoonCharacter {
	SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

	private static Random rand = new Random(47);

	public static CartoonCharacter next() {
		return values()[rand.nextInt(CartoonCharacter.values().length)];
	}

}

public class EnumStaticImplementation {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(CartoonCharacter.next());
		}
	}

}
