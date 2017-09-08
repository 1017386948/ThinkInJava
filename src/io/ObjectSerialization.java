package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Thing1 implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1923829913167913960L;
	private Thing2 next;

	public Thing1(int id) {
		next = new Thing2(id);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Thing1(Thing2(");
		result.append(next);
		result.append("))");
		return result.toString();
	}
}

class Thing2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 180151078607091331L;
	private int id;

	public Thing2(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return Integer.toString(id);
	}
}

public class ObjectSerialization {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Thing1 t1 = new Thing1(100);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\10173\\Desktop\\demo.txt"));
		out.writeObject(t1);
		out.flush();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\10173\\Desktop\\demo.txt"));
		Thing1 t2 = (Thing1) in.readObject();
		System.out.println(t2.toString());
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(t1);
		oos.flush();
		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
		System.err.println(in2.readObject().toString());
	}
}
