
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        int div = 10;
        for(int i = 0;i <= n;i++){
        	int temp1= i;
        	while(temp1>0){
        		if (temp1%div == 7){
        		count += 1;
        		}
        	temp1 = Math.round(temp1/10);
        	}	
       	}

       System.out.println(count);
    }
}