package RMIT;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.NamingException;

public class RServer {
	public static void main(String[] args) throws NamingException {
		try{
			RService rs = new RServerImpl();
			LocateRegistry.createRegistry(8888);  
			Naming.bind("rmi://127.0.0.1:8888/rs", rs);  
			System.out.println(">>INFO:远程rs对象绑定成功！");  
		}catch (RemoteException e) {  
            System.out.println("创建远程对象发生异常！");  
            e.printStackTrace();  
        } catch (AlreadyBoundException e) {  
            System.out.println("发生重复绑定对象异常！");  
            e.printStackTrace();  
        } catch (MalformedURLException e) {  
            System.out.println("发生URL畸形异常！");  
            e.printStackTrace();  
        }
	}
}
