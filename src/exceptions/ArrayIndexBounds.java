package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;import javax.transaction.TransactionRequiredException;

public class ArrayIndexBounds {
	static Logger logger = Logger.getLogger("ArrayIndexBounds");
	static void logException(Exception e) {
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
	public static void main(String[] args) {
		int[] i = {1,2};
		try {
			System.out.println(i[10]);
		}catch (ArrayIndexOutOfBoundsException e) {
			logException(e);
		}
	}
}
