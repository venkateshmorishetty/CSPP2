import java.util.Scanner;
class Item {
	String item;
	int quantity;
	float price;
	Item(String item, int quantity, float price) {
		this.item = item;
		this.quantity = quantity;
		this.price = price;

	}
	Item(String item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	public String getitem() {
		return this.item;
	}
	public int getquantity() {
		return this.quantity;
	}
	public double getprice() {
		return this.price;
	}
	public String display() {
		return (this.item + " " + this.quantity + " " + this.price);
	}
	public String tostring() {
		return (this.item + " " + this.quantity);
	}
}
class Shopingcart {
	Item[] items_array = new Item[10];
	int size = 0;
	int k = 1;
	Item[] list = new Item[10];
	int size1 = 0;
	double totalprice, disc;
	public void addTocatalog(Item item) {
		items_array[size++] = item;
	}
	public void catalog() {
		for (int i = 0; i < size; i++) {
			System.out.println(items_array[i].display());
		}
	}
	public void addToCart(Item item) {
		int flag = 0;
		if (size != 0) {
			for (int j = 0; j < size1; j++) {
				if (item.getitem().equals(list[j].getitem())) {
					for (int i = 0; i < size; i++) {
						if (item.getitem().equals(items_array[i].getitem()) && item.quantity <= items_array[i].getquantity()) {
							flag = 1;
							list[j].quantity += item.quantity;
							items_array[i].quantity -= item.getquantity();
							break;
						}
					}
				}
			}
			if (flag == 0) {
				for (int i = 0; i < size; i++) {
					if (item.item.equals(items_array[i].getitem())) {
						items_array[i].quantity -= item.getquantity();
						list[size1++] = item;
						break;

					}
				}
			}
		}
	}
	public void removeFromCart(Item item) {
		for (int i = 0; i < size1; i++) {
			if (item.item.equals(list[i].getitem())) {
				list[i].quantity -= item.quantity;
				if (list[i].quantity == 0) {
					for (int k = i; k < size1; k++) {
						list[i] = list[i + 1];
					}
					size1--;
				} else {
					for (int j = 0; j < size; j++) {
						if (item.item.equals(items_array[j].getitem())) {
							items_array[j].quantity += item.quantity;
						}
					}
				}
			}
		}
	}
	public void show() {
		for (int i = 0; i < size1; i++) {
			System.out.println(list[i].tostring());
		}
	}
	public double totalAmount() {
		double cost = 0;;
		for (int i = 0; i < size1; i++) {
			for (int j = 0; j < size; j++) {
				if (list[i].getitem().equals(items_array[j].getitem())) {
					cost += list[i].quantity * items_array[j].price;
					break;
				}
			}
		}
		totalprice = cost;
		return cost;
	}
	boolean flag = false;
	public void applyCoupon(String coupon) {
		if (k == 1) {
			double val = 0;
			totalprice = totalAmount();
			if (coupon.equals("IND10")) {
				disc = totalprice * 0.1;
			} else if (coupon.equals("IND20")) {
				disc = totalprice * 0.2;
			} else if (coupon.equals("IND30")) {
				disc = totalprice * 0.3;
			} else if (coupon.equals("IND50")) {
				disc = totalprice * 0.5;
			} else {
				System.out.println("Invalid coupon");
			}
			k++;
		}
	}
	public double payableAmount() {
		totalprice = totalAmount();
		totalprice -= disc;
		double tax = totalprice * 0.15;
		totalprice = totalprice + tax;
		return totalprice;
	}
	public double getprice(String item) {
		for (int i = 0; i < size; i++) {
			if (item.equals(items_array[i].getitem())) {
				return items_array[i].price;
			}
		}
		return 0;
	}
	public void print() {
		System.out.println("Name" + "   " + "quantity" + "   " + "Price");
		for (int i = 0; i < size1; i++) {
			System.out.println(list[i].getitem() + " " + list[i].getquantity() + " " + getprice(list[i].item));
		}
		System.out.println("Total:" + totalAmount());
		System.out.println("Disc%:" + disc);
		System.out.println("Tax:" + (totalAmount() - disc) * 0.15);
		System.out.println("Payable amount: " + payableAmount());
	}
}


public class Solution {
	public static void main(String[] args) {
		Shopingcart sc = new Shopingcart();
		Scanner s = new Scanner(System.in);
		int no_of_lines = s.nextInt();
		for (int i = 0; i <= no_of_lines; i++) {
			String[] line = s.nextLine().split(" ");
			if (line[0].equals("Item")) {
				String[] product = line[1].split(",");
				sc.addTocatalog(new Item(product[0], Integer.parseInt(product[1]), Float.parseFloat(product[2])));
			}
			if (line[0].equals("catalog")) {
				sc.catalog();
			}
			if (line[0].equals("add")) {
				String[] shopping = line[1].split(",");
				sc.addToCart(new Item(shopping[0], Integer.parseInt(shopping[1])));
			}
			if (line[0].equals("remove")) {
				String[] remove = line[1].split(",");
				sc.removeFromCart(new Item(remove[0], Integer.parseInt(remove[1])));
			}
			if (line[0].equals("show")) {
				sc.show();
			}
			if (line[0].equals("totalAmount")) {
				System.out.println("totalAmount: " + sc.totalAmount());
			}
			if (line[0].equals("coupon")) {
				sc.applyCoupon(line[1]);
			}
			if (line[0].equals("payableAmount")) {
				System.out.println("Payable amount: " + sc.payableAmount());
			}
			if (line[0].equals("print")) {
				sc.print();
			}
		}
	}
}