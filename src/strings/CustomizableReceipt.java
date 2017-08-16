package strings;

import java.util.Formatter;

public class CustomizableReceipt {
	public static final int ITEM_WIDTH = 15;
	public static final int QTY_WIDTH = 5;
	public static final int PRICE_WIDTH = 10;
	
	private double total = 0;
	private Formatter f = new Formatter(System.out);

	public void printTitle() {
		f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
		f.format("%-15s %5s %10s\n", "----", "---", "-----");
	}

	public void print(String name, int qty, double price) {
		f.format("%-15s %5s %10.2f\n", name, qty, price);
		total += price;
	}

	public void printTotal() {
		f.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.06);
		f.format("%-15s %5s %10s\n", "", "", "-----");
		f.format("%-15s %5s %10.2f\n", "Total", "", total * 1.06);
	}

	public static void main(String[] args) {
		CustomizableReceipt customizableReceipt = new CustomizableReceipt();
		customizableReceipt.printTitle();
		customizableReceipt.print("Jack's Magic Be", 4, 4.25);
		customizableReceipt.print("Princess Peas", 3, 5.1);
		customizableReceipt.print("Three Bears Por", 1, 14.29);
		customizableReceipt.printTotal();
	}
}
