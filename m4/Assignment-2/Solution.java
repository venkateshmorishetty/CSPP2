import java.util.Scanner;
public class Solution {
	/* Fill the main function to print resultant of addition of matrices*/
	public static void main(String[] args) {
		int[][] a,b,c;
		int rows,cols,rows1,cols1;
		Scanner sc = new Scanner(System.in);
		rows = sc.nextInt();
		cols = sc.nextInt();
		a = new int[rows][cols];
		for(int i = 0;i<rows;i++){
			for(int j = 0;j<cols;j++){
				a[i][j] = sc.nextInt();
			}
		}
		rows1 = sc.nextInt();
		cols1 = sc.nextInt();
		b = new int[rows1][cols1];
		for(int i = 0;i<rows1;i++){
			for(int j = 0;j<cols1;j++){
				b[i][j] = sc.nextInt();
			}
		}
		c = new int[rows][cols];
		if(rows == rows1 && cols == cols1){
			for(int i = 0;i<rows1;i++){
				for(int j = 0;j<cols1;j++){
					c[i][j] = a[i][j]+b[i][j];
				}
			}
			for(int i = 0;i<rows1;i++){
				for(int j = 0;j<cols1;j++){
				System.out.print(c[i][j]+" ");
			}System.out.println();
		} 	
		}
		else{
			System.out.println("not possible");
		}
	}
}