import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements TInterface{ 
	public static yuginoh board;
	public static YGNInterface obj;
	 public Client() throws RemoteException {
	        super(0);    // required to avoid the 'rmic' step, see below
	    }

	   public String heyo() {
	        return "Heyo from Client";
	    }
	   public void SendMove(){
		   
	   }
	   public void move(){
		   
	   }
    public static void main(String args[]) throws Exception {
    	 System.out.println("RMI server started");
         Client obj2 = new Client();
         // Bind this object instance to the name "Tester"
        Naming.rebind("//localhost/Client", obj2);
        YGNInterface obj = (YGNInterface)Naming.lookup("//localhost/Tester");
        System.out.println(obj.getMessage()); 
        board = new yuginoh();
        board.main(null);
        board.l= new logic();
        board.l.init();
        
        //board.l=obj.getLogic();
        //board.c=obj2;
        //board.Tester= false;
        //board.main(null);
        
    }
    public void update() throws RemoteException{
    	board.l=obj.getLogic();
    	board.draw(1);
    }
}


