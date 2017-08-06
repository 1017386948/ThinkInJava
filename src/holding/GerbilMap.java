package holding;
import java.util.*;
import java.util.Map.Entry;

public class GerbilMap {
	public static void main(String[] args) {
		Map<String,Gerbil> gerbilMap = new LinkedHashMap<String,Gerbil>();
		gerbilMap.put("Fuzzy", new Gerbil(1));
		gerbilMap.put("Spot", new Gerbil(2));
		gerbilMap.put("Joe", new Gerbil(3));
		gerbilMap.put("Ted", new Gerbil(4));
		gerbilMap.put("Heather", new Gerbil(5));
		Iterator<Entry<String,Gerbil>> iter = gerbilMap.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<String,Gerbil> entry = iter.next();
			System.out.print(entry.getKey()+"  ");
			entry.getValue().hop();
		}
		
	}
	
}
