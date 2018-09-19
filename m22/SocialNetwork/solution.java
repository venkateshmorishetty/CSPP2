import java.io.*;
import java.util.*;
class user{
	String name;
	int count = 0;
	String[] friendslist = new String[100];
	public user(String n,String[] list){
		name = n;
		for(String i:list){
			addfriend(i);
		}
	}
	public String getname(){
		return name;
	}
	public String[] list() {
		return friendslist;
	}
	public int flistlength(){
		return count;
	}
	public void addfriend(String newfriend) {
		newfriend = newfriend.replace(".","").trim();
		friendslist[count] = newfriend;
		count++; 
	}
	public String tostring() {
		String s = "[";
		for(int i = 0; i < count-1; i++) {
			s = s + friendslist[i] + ", ";
		}
		return s + friendslist[count-1] + "]";
	}
}
class socialnetwork{
	public String[] list1,list2;
	user[] users;
	int size;
	socialnetwork() {
		users = new user[100];
		size = 0;
	}
	public void user(String username, String friends) {
		String[] flist = friends.split(",");
		user u = new user(username,flist);
		users[size++] = u;
		int k = 0;
		if(size>2){
		while(k<size) {
			for(int i = 0; i < size - 1; i++) {
				if(users[i].name.compareTo(users[i+1].name)>0){
					user t = users[i];
					users[i] = users[i+1];
					users[i+1] = t;
				}
			}
		k++;	
		}
		}
	}
	public void getConnections(String name) {
		if(size!=0) {
			int f = 0;
			for(int i = 0; i < size; i++) {
				if(name.equals(users[i].getname())) {
					f = 1;
					System.out.println(users[i].tostring());
				}
			}
			if(f == 0) {
				System.out.println("Not a user in Network");
			}
		}
	}
	public void addConnections(String name,String newfriend) {
		for(int i = 0; i < size; i++) {
			if(name.equals(users[i].getname())) {
				users[i].addfriend(newfriend);
			}
 		}
	}
	public String getCommonConnections(String name1, String name2) {
		String[] common;
		for(int i = 0; i < size; i++) {
			if(name1.equals(users[i].getname())){
				list1 = Arrays.copyOf(users[i].list(),users[i].flistlength());
			}
			if(name2.equals(users[i].getname())){
				list2 = Arrays.copyOf(users[i].list(),users[i].flistlength());
			}
		}
		if(list1.length > list2.length) {
			common = new String[list1.length];
		}else{
			common = new String[list2.length];
		}
		int temp = 0;
		if(list1.length !=0 && list2.length != 0) {
			for(int j = 0; j < list1.length; j++) {
				for(int k = 0; k < list2.length; k++) {
					if(list1[j].equals(list2[k])){
						common[temp++] = list1[j]; 
					}
					else{
						continue;
					}
				}
			}
		}
		if(temp == 0) {
			return "[]";
		}
		String s = "[";
		for(int i = 0; i < temp-1; i++) {
			s = s + common[i] + ", ";
		}
		return s + common[temp-1] + "]";
	}
	public void network() {
		String s = "";
		for(int i = 0; i < size-1; i++) {
			s = s + users[i].getname()+": "+users[i].tostring()+", ";
		}s = s + users[size-1].getname()+": "+users[size-1].tostring();
		System.out.println(s);
	}
}
class solution {
	public static void main(String[] args) {
		socialnetwork sn = new socialnetwork();
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		for(int i = 0; i < Integer.parseInt(line[1]); i++){
			String str = sc.nextLine();
			String[] arr = str.split(" is connected to ");
			sn.user(arr[0], arr[1]);
		}
		while(sc.hasNext()){
			String arr = sc.nextLine();
			String[] tokens = arr.split(" ");
			if(tokens[0].equals("getConnections")) {
				sn.getConnections(tokens[1]);
			}
			if(tokens[0].equals("addConnections")) {
				sn.addConnections(tokens[1],tokens[2]);
			}
			if(tokens[0].equals("CommonConnections")) {
				System.out.println(sn.getCommonConnections(tokens[1], tokens[2]));
			}
			if(tokens[0].equals("Network")) {
				sn.network();
			}
		}
		
	}
}