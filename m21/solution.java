import java.util.Scanner;
class foodlog{
	String foodname,time;
	int quantity;
	public foodlog(String item, int quantity, String time){
		foodname = item;
		this.quantity = quantity;
		this.time = time;
	}
	public String getfoodname() {
		return foodname;
	}
	public int getquantity() {
		return this.quantity;
	}
	public String gettime() {
		return this.time;
	}
}
class waterlog{
	int water_quantity;
	String date;
	public waterlog(int q, String d) {
		water_quantity = q;
		date = d;
	}
	public int getwaterquantity() {
		return this.water_quantity;
	} 
	public String getdate(){
		return date;
	}
}
class activity{
	String activity_name,starttime,endtime,date;
	public activity(String a_name,String s_time,String e_time, String date){
		this.activity_name = a_name;
		this.starttime = s_time;
		this.endtime = e_time;
		this.date = date;
	}
	public String getactivity_name() {
		return this.activity_name;
	}
	public String getstarttime() {
		return this.starttime;
	}
	public String getendtime() {
		return this.endtime;
	}
	public String getdate() {
		return this.date;
	}
}
class weight{
	int weight;
	String fat;
	String date;
	public weight(String d, int w, String f) {
		this.weight = w;
		this.fat = f;
		this.date =d;
	}
	public int getweight() {
		return this.weight;
	}
	public String getfat() {
		return this.fat;
	}
	public String getdate() {
		return this.date;
	}
}
class sleep{
	String datestime;
	String dateetime;
	public sleep(String datestarttime,String dateendtime) {
		datestime = datestarttime;
		dateetime = dateendtime;
	}
	public String getdatestime() {
		return this.datestime;
	}
	public String getdateetime() {
		return this.dateetime;
	}
}
class person{
	foodlog[] foodinfo = new foodlog[10];
	int size1=0;
	waterlog[] waterinfo = new waterlog[10];
	int size2=0;
	activity[] activityinfo = new activity[10];
	int size3=0;
	weight[] weightinfo = new weight[10];
	int size4=0;
	sleep[] sleepinfo = new sleep[10];
	int size5=0;
	public void food(String item, int q, String date){
		foodlog f = new foodlog(item, q, date);
		foodinfo[size1++] = f;
	}
	public void drinking(int quantity,String date) {
		waterlog w = new waterlog(quantity,date);
		waterinfo[size2++] = w;
	}
	public void activity(String name, String stime, String etime, String date){
		activity a = new activity(name, stime, etime, date);
		activityinfo[size3++] = a;
	}
	public void weight(String date, int weight, String fat) {
		weight w =new weight(date, weight, fat);
		weightinfo[size4++] = w;
	}
	public void sleep(String starttime, String endtime) {
		sleep s =new sleep(starttime,endtime);
		sleepinfo[size5++] = s;
	}
	public void foodlog(){
		System.out.println("Food");
		for(int i = 0; i< size1;i++) {
			System.out.println("name: "+foodinfo[i].getfoodname());
			System.out.println("quantity: "+foodinfo[i].getquantity());
			System.out.println("date and time: "+foodinfo[i].gettime());
		}
	}
	public void waterlog(){
		System.out.println("Water");
		for(int i = 0; i< size2;i++) {
			System.out.println("qunatity: "+waterinfo[i].getwaterquantity());
			System.out.println("time and date: "+waterinfo[i].getdate());
		}
	}
	public void activitylog() {
		System.out.println("Activity");
		for(int i = 0; i< size3;i++) {
			System.out.println("name: "+activityinfo[i].getactivity_name());
			System.out.println("begining time: "+activityinfo[i].getstarttime());
			System.out.println("ending time: "+activityinfo[i].getendtime());
			System.out.println("date: "+activityinfo[i].getdate());
		}
	}
	public void weightlog() {
		System.out.println("Weight");
		for(int i = 0; i< size4;i++) {
			System.out.println("weight: "+weightinfo[i].getweight());
			System.out.println("fat: "+weightinfo[i].getfat());
			System.out.println("date: "+weightinfo[i].getdate());
		}
	}
	public void sleeplog() {
		System.out.println("Sleep");
		for(int i = 0; i< size5;i++) {
			System.out.println("starting time: "+sleepinfo[i].getdatestime());
			System.out.println("ending time: "+sleepinfo[i].getdateetime());
		}
	}
	public void print() {
		foodlog();
		weightlog();
		activitylog();
		weightlog();
		sleeplog();
	}
	
}
class solution{
	public static void main(String[] args) {
		person p = new person();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] tokens = line.split(" ",2);
			switch(tokens[0]){
				case "addfood":
				String[] info = tokens[1].split(",");
				p.food(info[0], Integer.parseInt(info[1]), info[2]);
				break;
				case "water":
				String[] opt = tokens[1].split(","); 
				p.drinking(Integer.parseInt(opt[0]),opt[1]);
				break;
				case "activity":
				String[] arr = tokens[1].split(",");
				p.activity(arr[0], arr[1], arr[2], arr[3]);
				break;
				case "weight":
				String[] we = tokens[1].split(",");
				p.weight(we[0],Integer.parseInt(we[1]),we[2]);
				break;
				case "sleep":
				String[] sl = tokens[1].split(",");
				p.sleep(sl[0],sl[1]);
				break;
				case "print":
				p.print();
				break;
				case "foodlog":
				p.foodlog();
				break;
				case "waterlog":
				p.waterlog();
				break;
				case "activitylog":
				p.activitylog();
				break;
				case "weightlog":
				p.weightlog();
				break;
				case "sleeplog":
				p.sleeplog();
				break;
			}
		}
	}
}