import java.util.Scanner;
class Item{
	String item;
	int quantity;
	float price;
	Item(String item, int quantity, float price) {
		this.item = item;
		this.quantity = quantity;
		this.price = price;

	}
	Item(String item, int quantity){
		this.item = item;
		this.quantity = quantity;
	}
	public String getitem(){
		return this.item;
	}
	public int getquantity(){
		return this.quantity;
	}
	public double getprice(){
		return this.price;
	}
	public String display(){
		return (this.item+" "+this.quantity+" "+this.price);
	}
	public String tostring(){
		return (this.item+" "+this.quantity);
	}
}
class Shopingcart{
	Item[] items_array = new Item[10];
	int size = 0;
	Item[] list = new Item[10];
	int size1 = 0;
	static double totalprice;
	String[] coupons = new String[] {"IND10","IND20","IND30","IND50"};
	public void addTocatalog(Item item) {
		items_array[size++] = item;
	}
	public void catalog(){
		for(int i = 0; i < size; i++) {
			System.out.println(items_array[i].display());	
		}
	}
	public void addToCart(Item item)
	{
		int flag = 0;
		if(size != 0)
		{
			for(int j = 0;j<size1;j++)
			{
				if(item.getitem().equals(list[j].getitem())&&item.getquantity()>=list[j].getquantity())
				{
					flag = 1;
					list[j].quantity+=item.quantity;
					for(int i = 0; i < size; i++)
					{
						if(item.getitem().equals(items_array[i].getitem()))
						{
						items_array[i].quantity -= item.getquantity();
						break;
						}
					}
				}
			}
			if(flag == 0)
			{
				for(int i = 0; i < size; i++) 
				{
					if(item.item.equals(items_array[i].getitem()))
					{
						items_array[i].quantity -= item.getquantity();
						list[size1++] = item;
						break;
						
					}
				}
			}
		}
	}
	public void removeFromCart(Item item) {
		for(int i = 0; i < size1; i++) {
			if(item.item.equals(list[i].getitem())){
				list[i].quantity -= item.quantity;
				for(int j = 0; j < size; j++) {
					if(item.item.equals(items_array[j].getitem())){
						items_array[j].quantity += item.quantity;
					}
				}
			}
		}
	}
	public void show() {
		for(int i = 0; i < size1; i++) {
			System.out.println(list[i].tostring());
		}
	}
	public double totalAmount(){
		double cost=0;;
		for(int i = 0; i < size1; i++) {
			for(int j = 0; j < size; j++) {
				if(list[i].getitem().equals(items_array[j].getitem())) {
					cost += list[i].quantity*items_array[j].price;
					break;
				}
			}
		}
		return cost;
	}

	public void applyCoupon(String coupon) {
		double val=0;
		totalprice = totalAmount();
		for(int i = 0;i<size;i++){
			if(coupons[i].equals(coupon)) {
				val = Integer.parseInt(coupon.charAt(3)+"");
				totalprice = (totalprice-(val*0.1)*totalprice);
			}	
		}
	}
	public double payableAmount(){
		double tax = totalprice*0.15;
		totalprice = totalprice + tax;
		return totalprice;
	}
	public double getprice(String item) {
		for(int i = 0; i < size; i++){
			if(item.equals(items_array[i].getitem())) {
				return items_array[i].price;
			}
		}
		return 0;
	}
	public void print(){
		System.out.print("Name"+" "+"quantity"+" "+"Price");
		for(int i = 0;i<size1;i++){
			System.out.print(list[i].getitem()+" "+list[i].getquantity()+" "+list[i].quantity*getprice(list[i].item));
		}
		System.out.println("totalAmount"+totalAmount());
		System.out.println("Tax"+totalAmount()*0.15);
		System.out.println("payableAmount"+totalprice);
	}
}


public class Solution{
	public static void main(String[] args) {
		Shopingcart sc = new Shopingcart();
		Scanner s = new Scanner(System.in);
		int no_of_lines = s.nextInt();
		for(int i = 0; i < no_of_lines; i++){
			String[] line = s.nextLine().split(" ");
			if(line[0].equals("item")){
				String[] product = line[1].split(",");
				sc.addTocatalog(new Item(product[0],Integer.parseInt(product[1]),Float.parseFloat(product[2])));
			}
			if(line[0].equals("catalog")){
				sc.catalog();
			}
			if(line[0].equals("add")){
				String[] shopping = line[1].split(",");
				sc.addToCart(new Item(shopping[0],Integer.parseInt(shopping[1])));
			}
			if(line[0].equals("remove")) {
				String[] remove = line[1].split(",");
				sc.removeFromCart(new Item(remove[0],Integer.parseInt(remove[1])));
			}
			if(line[0].equals("show")){
				sc.show();
			}
			if(line[0].equals("totalAmount")) {
				System.out.println(sc.totalAmount());
			}
			if(line[0].equals("coupon")) {
				sc.applyCoupon(line[1]);
			}
			if(line[0].equals("payableAmount")){
				System.out.println(sc.payableAmount());
			}
			if(line[0].equals("print")){
				sc.print();
			}
		}
	}
}	