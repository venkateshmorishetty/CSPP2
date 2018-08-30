
import java.util.*;
public class Solution
{/*
	Fill this main function to print maximum of given array
	*/
	public static void main(String[] args)
	{
		int max;
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		int[] a;
		a=new int[n];
		for(int i = 0;i<n;i++){
			a[i] = sc.nextInt();
		}
		max = a[0];
		for(int i = 1;i<n;i++){
			if(max<a[i]){
				max = a[i];
			}
		}
		System.out.println(max);
	}
}
