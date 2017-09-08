package io;

import static net.mindview.util.Print.print;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Blip1 implements Externalizable {
	public Blip1() {
		print("Blip1 Constructor");
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		print("Blip1.writeExternal");
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		print("Blip1.readExternal");
	}
}

public class BlipCheck implements Externalizable {
	public BlipCheck() {
		print("BlipCheck Constructor");
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		print("BlipCheck.writeExternal");
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		print("BlipCheck.readExternal");
	}

	public static void main(String[] args) throws Exception {
		// To make it run with Ant.
		Blips.main(args);
	}
}

class Blips {
	// Throw exceptions to console:
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		print("Constructing objects:");
		Blip1 b1 = new Blip1();
		BlipCheck b2 = new BlipCheck();
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
		print("Saving objects:");
		o.writeObject(b1);
		o.writeObject(b2);
		o.close();
		// Now get them back:
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
		print("Recovering b1:");
		b1 = (Blip1) in.readObject();
		// OOPS! Throws an exception:
		print("Recovering b2:");
		b2 = (BlipCheck) in.readObject();
	}
}
