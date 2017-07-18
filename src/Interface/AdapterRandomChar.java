package Interface;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.*;

class RandomChar {
	private static Random rand = new Random(47);
	private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final char[] vowels = "aeiou".toCharArray();
	
	char[] generate(){
		char[] buffer = new char[10];
		int idx = 0;
		buffer[idx++] = capitals[rand.nextInt(capitals.length)];
		for(int i=0;i<4;i++){
			buffer[idx++] = vowels[rand.nextInt(vowels.length)];
			buffer[idx++] = lowers[rand.nextInt(lowers.length)];
		}
		buffer[idx] = ' ';
		return buffer;
	}
}

public class AdapterRandomChar extends RandomChar
	implements Readable{
	private int count;
	AdapterRandomChar(int count){
		this.count = count;
	}
	@Override
	public int read(CharBuffer cb){
		if(count-- ==0)
			return -1;
		char[] buffer = generate();
		cb.put(buffer);
		return cb.length();
	}
	public static void main(String[] args){
		Scanner s = new Scanner(new AdapterRandomChar(10));
		while(s.hasNext())
			System.out.println(s.next());
	}

}
