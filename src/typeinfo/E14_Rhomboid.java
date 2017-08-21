package typeinfo;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
	public void draw() {
		System.out.println(this + ".draw");
	}

	void rotate(int degrees) {
		System.out.println("Rotating " + this + " by " + degrees + " degrees");
	}

	@Override
	public abstract String toString();
}

class Circle extends Shape {

	@Override
	public String toString() {
		return "Circle";
	}
	@Override
	void rotate(int degrees) {
		throw new UnsupportedOperationException();
	}
}

class Square extends Shape {

	@Override
	public String toString() {
		return "Square";
	}
}

class Triangle extends Shape {

	@Override
	public String toString() {
		return "Triangle";
	}
}

class Rhomboid extends Shape {
	public String toString() {
		return "Rhomboid";
	}
}

public class E14_Rhomboid {
	public static void main(String[] args) {
		List<Shape> shapes = Arrays.asList(new Circle(), new Square(), new Triangle(), new Rhomboid());
		for (Shape shape : shapes) {
			if (!(shape instanceof Circle))
				shape.rotate(45);
		}
		// Upcast to shape:
		Shape shape = new Rhomboid();
		// Downcast to Rhomboid:
		Rhomboid r = (Rhomboid) shape;
		// Downcast to Circle. Succeeds at compile time,
		// but fails at runtime with a ClassCastException:
//		if (shape instanceof Circle) {
//			Circle c = (Circle) shape;
//		}
	}
}
