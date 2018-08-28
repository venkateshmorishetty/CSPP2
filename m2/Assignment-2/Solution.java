import java.util.Scanner;
public final class Solution {
	/*
	* @author  venkatesh
	*/
	public static void main(final String[] args) {
		/**
		 * main function
		 */
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
	static void rootsOfQuadraticEquation(final int a, final int b, final int c) {
		/**
		 * rootsQuadraticEquation 
		 */
		double root1;
		double root2;
		root1 = (-b + (Math.sqrt((b * b) - 2 * 2 * a * c))) / (2 * a);
		root2 = (-b - (Math.sqrt((b * b) - 2 * 2 * a * c))) / (2 * a);
		System.out.println(root1 + " " + root2);


	}
}
