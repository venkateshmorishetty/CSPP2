import java.util.*;
import java.io.*;
class socialnetwork{
	HashMap<String,String[]> hm = new HashMap<String,String[]>();
	public void user(String name,String[] list) {
		if(hm.size()!=0) {
			boolean check = hm.containsKey(name);
			if(!check){
				hm.put(name,list);
			}
		}
	} 
	
}
class solution {
	public static void main(String[] args) {
		socialnetwork sn = new socialnetwork();
		try{
			BufferedReader b = new BufferedReader(new FileReader("sc2.txt"));
			String str = b.readLine();
			while(str!=null){
				String[] arr = str.split(" is connected to ");
				// if(arr.length < 2){
				// 	String[] tokens = arr[0].split(" ");
				// 	if(tokens[0].equals("getConnections")) {
				// 		sn.getConnections(tokens[1]);
				// 	}
				// 	if(tokens[0].equals("addConnections")) {
				// 		String[] token = tokens[1].split(",");
				// 		sn.addConnections(token[0],token[1]);
				// 	}
				// 	if(tokens[0].equals("getCommonConnections")) {
				// 		String[] token = tokens[1].split(",");
				// 		System.out.println(sn.getCommonConnections(token[0], token[1]));
				// 	}
				// }
				// else {
				sn.user(arr[0], arr[1].split(","));
				// }
				str = b.readLine();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}