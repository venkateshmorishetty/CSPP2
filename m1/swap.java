class swap{
	public static void main(String[] args) {
		int a = 2;
		int b = 3;
		System.out.println("a is"+a);
		System.out.println("b is"+b);
		int temp;
		temp = a;
		a = b;
		b = temp;
		System.out.println("after swapping");
		System.out.println("a is"+a);
		System.out.println("b is"+b);
	}
}