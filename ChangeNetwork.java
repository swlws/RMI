package RMIT;

import java.rmi.Naming;

public class ChangeNetwork {
	public static void main(String[] args) {
		String IP = null , gateway = null, network = null , DNS = null;
		if(args != null){
			IP = args[0];	//IP
			gateway = args[1];	//gateway
			network = args[2];	//network
			DNS = args[3];	//DNS
		}
		
		try {
			RService rs = (RService) Naming.lookup("rmi://127.0.0.1:8888/rs");  
            System.out.println(rs.updateNetwork(IP,gateway,network,DNS));  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
