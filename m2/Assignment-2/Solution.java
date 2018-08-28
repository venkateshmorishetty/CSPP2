import java.util.Scanner;
import java.lang.Math;
public final class Solution {
	/*
	Do not modify this main function.
	@param      args  The arguments
	*/
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function.
	@param      a     { a value }
	@param      b     { b value }
	@param      c     { c value }
	*/
	static void rootsOfQuadraticEquation(final int a, final int b,int c) {
		double root1;
		double root2;
		root1 = (-b + (Math.sqrt((b * b) - 2 * 2 * a * c))) / (2 * a);
		root2 = (-b - (Math.sqrt((b * b) - 2 * 2 * a * c))) / (2 * a);
		System.out.println(root1 + " " + root2);


	}
}
