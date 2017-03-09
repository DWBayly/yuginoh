import java.rmi.Remote;
import java.rmi.RemoteException;

public interface YGNInterface extends Remote {
    public String getMessage() throws RemoteException;
    public logic getLogic() throws RemoteException;
   
}