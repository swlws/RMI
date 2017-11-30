package RMIT;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RServerImpl extends UnicastRemoteObject implements RService{

	protected RServerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String updateNetwork(String IP, String gateway, String netmask, String DNS) throws RemoteException {
		StringBuilder cmd = new StringBuilder("cd ../../../Bin/  && ./updateNetWork.sh");
		cmd.append(" ").append(IP).append(" ").append(gateway).append(" ").append(netmask).append(" ").append(DNS);
		
		System.out.println(cmd);
		// 执行脚本，启用修改IP地址
		try {
			Runtime.getRuntime().exec(new String[] { "/bin/sh", "-c", cmd.toString() }).waitFor();
//			Runtime.getRuntime().exec("service network restart").waitFor();
		} catch (InterruptedException | IOException e) {
			System.out.println(" saveNetWork exception, " + e);
			return "error";
		}
		return "success";
	}

}
