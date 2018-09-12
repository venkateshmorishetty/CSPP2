import java.util.Arrays;

/**
 * show class stores movies.
 */
class Show {
	String movie;
	String date;
	String[] seats;

	/**
	 * Constructs the object.
	 *
	 * @param      m     { movie name }
	 * @param      d     { date and time }
	 * @param      s     { seats array }
	 */
	public Show(String m, String d, String[] s) {
		movie = m;
		date = d;
		seats = s;
		
	}
}
/**
 * Class for patron.
 */
class Patron {
	String name;
	String mobileno;

	/**
	 * Constructs the object.
	 *
	 * @param      n     { name of person }
	 * @param      m     { mobile number }
	 */
	Patron(String n, String m) {
		name = n;
		mobileno = m;

	}
}

/**
 * Class for bookyourshow.
 */
class Bookyourshow {

	Show[] obj_array;
	int size;
	Patron[] patr;
	int size1;

	/**
	 * Constructs the object.
	 */
	Bookyourshow() {
		obj_array = new Show[10];
		size = 0;
		patr = new Patron[10];
		size1 = 0;
	}
	/**
	 * create an object for show.and add to obj_array.
	 *
	 * @param      t     { Show object }
	 */
	public void addAShow(Show t) {
		obj_array[size++] = t;
	}

	/**
	 * Gets a show.
	 *
	 * @param      movie  The movie.
	 * @param      date   The date.
	 *
	 * @return     show object.
	 */
	public Show getAShow(String movie, String date) {
		for(int i = 0; i < size; i++) {
			if (movie.equals(obj_array[i].movie) && date.equals(obj_array[i].date)) {
				return obj_array[i];
			}
		}
		return null;
	}

	/**
	 * { book tickets for movie }.
	 *
	 * @param      movie  The movie
	 * @param      date   The date
	 * @param      p      { patron class object }
	 * @param      seats  The seats
	 */
	public void bookAShow(String movie, String date,Patron p ,String[] seats) {
		patr[size1++] = p;
		Show show = getAShow(movie, date);
		if (show == null) {
			System.out.println("No show");
			return;
		}
		if (size == 0) {
			System.out.println("Invalid");
			return;
		}
		for (int i = 0; i < size; i++) {
			if (movie.equals(obj_array[i].movie) && date.equals(obj_array[i].date)) {
				for (int j = 0; j < seats.length; j++) {
					for (int k = 0; k < obj_array[i].seats.length; k++) {
						if (seats[j].equals(obj_array[i].seats[k]) && !obj_array[i].seats[k].equals("N/A") ) {
							obj_array[i].seats[k] = "N/A";
						}
					}
				}	
			} 
		}
	}

	/**
	 * { prints the tickets }.
	 *
	 * @param      movie  The movie
	 * @param      date   The date
	 * @param      phno   The phno
	 */
	public void printTicket(String movie, String date, String phno) {
		int count = 0;
		Show show = getAShow(movie, date);
		if (show == null) {
			System.out.println("Invalid");
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

	/**
	 * returns all the movies in show class.
	 */
	public void showAll() {
			String s = "";
			int temp;
			for (int i = 0; i< size; i++) {
				s += Arrays.toString(obj_array[i].seats).replace(", ", ",");
				System.out.println(obj_array[i].movie+","+obj_array[i].date+","+s);
				s = "";
				temp = 0;
			}
		}
}