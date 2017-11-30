package RMIT;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RService extends Remote{
	/**
	 * 修改IP
	 * @param IP
	 * @param gateway
	 * @param netmask
	 * @param DNS
	 * @return
	 * @throws RemoteException
	 */
	public String updateNetwork(String IP,String gateway,String netmask,String DNS) throws RemoteException;
}
