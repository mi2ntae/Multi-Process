import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements ServerIF{
	
	protected Server() throws RemoteException {
		super();
	}

	public static void main(String args[]) {
		try {
			
			Server server = new Server();
			Naming.bind("AddServer", server);
			System.out.println("Server Is Ready");
			
		} catch(RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int add(int a, int b) {
		System.out.println("Server Is Response");
		return a+b;
	}
}
