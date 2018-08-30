
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
public final class Solution
{/*
	Do not modify the main function 
	*/
	static String reverse = "";
	public static void main(final String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		reverse = reverseString(s);	
		System.out.println(reverse);
		
	}
	public static String reverseString(final String string) {
		char[] arr = string.toCharArray();
		int length = arr.length;
		for(int i = length-1; i>=0; i--) {
			reverse += arr[i];
		}
		return reverse;
	}

}
