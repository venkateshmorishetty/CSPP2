import java.util.Scanner;
class Student{
	String name;
	String rollno;
	Double m1,m2,m3;
	public Student(String n,String r,double m1,double m2,double m3){
		this.name = n;
		this.rollno = r;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		System.out.println("average is"+(m1+m2+m3)/3);
	}
}
public class StudentDetails{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		String no = sc.next();
		double m1 = sc.nextDouble();
		double m2 = sc.nextDouble();
		double m3 = sc.nextDouble();
		Student s = new Student(name,no,m1,m2,m3);
	}
}
