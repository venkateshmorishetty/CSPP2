import java.util.Scanner;
class factorial{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number");
		int n = sc.nextInt();
		int f = fact(n);
		System.out.println("factorial is "+f);
	}
	static int fact(int number){
		if (number>0)
			return number*fact(number-1);
		else
			return 1;
	}
}

