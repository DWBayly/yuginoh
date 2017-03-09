import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TInterface extends Remote{
	public String heyo() throws RemoteException;
	public void update() throws RemoteException;
}
