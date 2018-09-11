import java.util.Scanner;
class List {
	private int[] list;
	private int size;
	public List() {
		list = new int[20];
		size = 0;
	}
	public void add(int item) {
		list[size++] = item;
	}
	public int size() {
		return size;
	}
	public void remove(int index) throws Exception {
		if (index >= 0 && index < size) {
			for(int i = index;i < size-1; i++) { 
				list[i] = list[i+1]; 
			}list[size-1] = 0;
		} else {
			throw new Exception("Invalid Position Exception");
		}
		size--;

	}
	public int get(int index) {
		if(index >= 0 && index < size) {
			return list[index];
		}
		return -1;
	}
	public String toString() {
		if(size == 0) {
			return "[]";
		}
		else {
			String s = "[";
			for (int i = 0; i < size-1; i++) {
				s += list[i] + ",";
			}s += list[size - 1] + "]";
			return s;
		}
	}
	public boolean contains(int item) {
		for(int i = 0; i < size; i++) {
			if(list[i] == item) {
				return true;
			}
		}
		return false;
	}
	public int indexOf(int item) {
		boolean check = contains(item);
		if(check) {
			for(int i = 0; i < size; i++) {
				if(item == list[i]) {
					return i;
				}
			}
		} 
		return -1;
	}
	public void add(int index,int item) {
		if(index>=0 && index < size){
			for(int i=size;i>index;i--){
				list[i] = list[i-1];
			}list[index] = item;
			size++;
		}
	}
	public void addAll(int[] items) {
		for(int i = 0; i < items.length; i++) {
			add(items[i]);
		}
	}
	public int count(int item) {
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(item == list[i]) {
				count++;
			}
		}
		return count;
	}
	public void removeAll(int[] items) throws Exception {
		boolean check;
		for (int i : items) {
			check = contains(i);
			while (check) {
				remove(indexOf(i));
				check = contains(i);
			}
		}
	}
	public List subList(int start, int end) throws Exception {
		if (end > size || end < 0 || start < 0) {
			throw new Exception("Index Out of Bounds Exception");
		} else {
			List l1 = new List();
			for(int i = start;i<end;i++){
				l1.add(list[i]);
			}
			return l1;
		} 
	}
	public boolean equals(List l) {
		return toString().equals(l.toString());
	}
	public void clear() {
		size = 0;
	}
}
class Solution{
	public static void main(String[] args) {
		List l = new List();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String line = sc.nextLine();
			String[] tokens = line.split(" ");
			switch(tokens[0]){
				case "add":
				try{
				l.add(Integer.parseInt(tokens[1]));
				}catch(Exception e){
					String[] val = tokens[1].split(",");
					l.add(Integer.parseInt(val[0]),Integer.parseInt(val[1]));
				}
				break;
				case "size":
				System.out.println(l.size());
				break;
				case "remove":
				try {
					l.remove(Integer.parseInt(tokens[1]));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				case "get":
				System.out.println(l.get(Integer.parseInt(tokens[1])));
				break;
				case "print":
				System.out.println(l.toString());
				break;
				case "contains":
				System.out.println(l.contains(Integer.parseInt(tokens[1])));
				break;	
				case "indexOf":
				System.out.println(l.indexOf(Integer.parseInt(tokens[1])));
				break;
				case "addAll":
				String[] ele = tokens[1].split(",");
				int[] ele1 = new int[ele.length];
				for(int i = 0; i < ele.length; i++) {
				ele1[i] = Integer.parseInt(ele[i]);
				}
				l.addAll(ele1);
				break;
				case "count":
				System.out.println(l.count(Integer.parseInt(tokens[1])));
				break;
				case "removeAll":
				String[] arr = tokens[1].split(",");
				int[] arr1 = new int[arr.length];
				for(int i = 0; i < arr.length; i++) {
					arr1[i] = Integer.parseInt(arr[i]);
				}
				try {
					l.removeAll(arr1);	
				} catch(Exception e){ }
				break;
				case "subList":
				String[] index = tokens[1].split(",");
				try{
					System.out.println(l.subList(Integer.parseInt(index[0]),Integer.parseInt(index[1])));
				} catch(Exception e) {
				System.out.println(e.getMessage());
				}
				break;
				case "equals":
				List equal = new List();
				String[] arr2 = tokens[1].split(",");
				for(int i = 0; i < arr2.length; i++) {
					equal.add(Integer.parseInt(arr2[i]));
				}
				System.out.println(l.equals(equal));
				break;
				case "clear":
				l.clear();
				break;
				default:
			}
		}
	}
}