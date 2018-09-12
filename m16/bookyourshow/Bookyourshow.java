import java.util.Arrays;
class Show{
	String movie;
	String date;
	String[] seats;
	public Show(String m, String d, String[] s) {
		movie = m;
		date = d;
		seats = s;
		
	}
}
class Patron{
	String name;
	String mobileno;
	public Patron(String n,String m) {
		name = n;
		mobileno = m;

	}
}
class Bookyourshow {
	Show[] obj_array = new Show[10];
	int size = 0;
	Patron[] patr = new Patron[10];
	int size1 = 0;
	public void addAShow(Show t) {

		obj_array[size++] = t;
	}
	public Show getAShow(String movie, String date) {
		for(int i = 0;i<size;i++) {
			if(movie.equals(obj_array[i].movie) && date.equals(obj_array[i].date)){
				return obj_array[i];
			}
		}
		return null;
	}
	public void bookAShow(String movie, String date,Patron p ,String[] seats) {
		patr[size1++] = p;
		Show show = getAShow(movie, date);
		if (show == null) {
			System.out.println("No show");
			return;
		}
		if (size == 0){
			System.out.println("Invalid");
			return;
		}
		for(int i = 0; i< size;i++){
			if(movie.equals(obj_array[i].movie) && date.equals(obj_array[i].date)){
				for(int j=0;j<seats.length;j++){
					for(int k = 0;k<obj_array[i].seats.length;k++){
						if(seats[j].equals(obj_array[i].seats[k]) && !obj_array[i].seats[k].equals("N/A") ){
							obj_array[i].seats[k] = "N/A";
						}
					}
				}	
			} 
		}
	}
	public void printTicket(String movie, String date,String phno) {
		int count = 0;
		Show show = getAShow(movie, date);
		if (show == null) {
			System.out.println("No show");
			return;
		}
		if( size==0) {
			System.out.println("Invalid");
			return;
		}
		else {
			for(int i = 0;i<size1;i++){
				if(phno.equals(patr[i].mobileno)) {
					System.out.println(phno+" "+movie+" "+date);
					return;
				}
			}
			System.out.println("Invalid");
			return;
		}
	}
	public void showAll(){
			String s="";
			int temp;
			for(int i = 0; i< size; i++){
				s="[";
				temp = obj_array[i].seats.length;
				for(int j = 0; j < temp-1; j++){
					s+=obj_array[i].seats[j]+",";
				}s+=obj_array[i].seats[temp-1]+"]";
				System.out.println(obj_array[i].movie+","+obj_array[i].date+","+s);
				s="";
				temp = 0;
			}
		}
}