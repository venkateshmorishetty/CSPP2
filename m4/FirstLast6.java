import java.util.Scanner;
class FirstLast6{
	public static void main(String[] args) {
		int size;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size of array");
		size = sc.nextInt();
		int[] a;
		a=new int[size];
		for(int i = 0;i<size;i++){
			a[i] = sc.nextInt();
		}
		if (a[0] == 6 || a[size-1] ==6){
			System.out.println("true");
		}
		else{
			System.out.println("false");
		}
	}
}