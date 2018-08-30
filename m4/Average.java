import java.util.Scanner;
class Average{
	public static void main(String[] args) {
		int size;
		int avg,sum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size of array");
		size = sc.nextInt();
		int[] a;
		a=new int[size];
		for(int i = 0;i<size;i++){
			a[i] = sc.nextInt();
		}
		for(int j=0;j<size;j++){
			sum = sum+a[j];
		}
		avg = sum/size;
		System.out.print(avg);
	}
}	