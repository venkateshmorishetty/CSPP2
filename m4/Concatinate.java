import java.util.Scanner;
class Concatinate{
	public static void main(String[] args) {
		String s,g;
		Scanner sc = new Scanner(System.in);
		g = "Hello";
		s = sc.next();
		g = g.concat(" "+s);
		System.out.println(g);
	}
}