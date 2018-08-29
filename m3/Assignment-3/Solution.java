
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {

    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        gcd(n1,n2);
        // System.out.println(gcd);
    }
    /*
	Need to write the gcd function and print the output.
	*/
    public static void gcd(int a,int b){
        int gcd = 1;
        if(b<a){
            int temp1 = a;
            a = b;
            b = temp1;
        }
        for(int i = a;i<=b;i++){
            if(b%i == 0 && a%i == 0){
                if(gcd<i){
                    gcd = i;
                }
            }
        }
    System.out.println(gcd);
    
    
    }
}
