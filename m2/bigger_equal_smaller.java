import java.util.Scanner;
class bigger_equal_smaller{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter 1st number");
		int a = sc.nextInt();
		System.out.println("enter 2nd number");
		int b = sc.nextInt();
		if (a>b){
			System.out.println("a is larger");
		}
		else if(a == b){
			System.out.println("both are equal");
		}
		else{
			System.out.println("a is less than b");
		}

		
	}
}