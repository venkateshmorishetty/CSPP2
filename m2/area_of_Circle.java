import java.util.Scanner;
public class area_of_Circle{
	static double area(int radius){
		
		double p = pi();
		return radius*radius*p;

	}
	static double pi(){
		return 3.14;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter radius");
		int r = sc.nextInt();
		System.out.println(area(r));
		
	}
}