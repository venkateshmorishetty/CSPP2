
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++){
			String s=sc.nextLine();
			String res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	public static String binaryToDecimal(String s){
		Long number = Long.parseLong(s);
		int res=0;
		int power=0;
		while(number!=0){
			Long rem = number%10;
			res += rem*Math.pow(2,power);
			number = number/10;
			power += 1;
		}
		return res+"";
	}
}	