import java.util.*;
class InputValidator
{
	/*Write the atrributes and methods for InputValidator*/
	String i;
	public InputValidator(String s){
		this.i = s;
	}
	public boolean validateData(){
		int len = i.length();
		if(len>=6){
			return true;
		}
		else{
			return false;
		}
	}

}
public class Solution
{
	public static void main(String args[])
    {
    	Scanner s=new Scanner(System.in);
    	String input=s.next();
    	InputValidator i=new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}
