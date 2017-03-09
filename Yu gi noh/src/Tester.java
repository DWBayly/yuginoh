import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*; 
public class Tester extends UnicastRemoteObject implements YGNInterface{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String MESSAGE = "Hello World";
	public static yuginoh board;
	public static logic l;
	public static YGNInterface ;
    public Tester() throws RemoteException {
        super(0);    // required to avoid the 'rmic' step, see below
    }

    public String getMessage() {
        return MESSAGE;
    }
    public logic getLogic(){
    	return l;
    }
    public void update(){
    	
    }
    
    public static void main(String args[]) throws Exception {
        System.out.println("RMI server started");
        
        try { //special exception handler for registry creation
            LocateRegistry.createRegistry(1099); 
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
            //do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }
           
        //Instantiate Tester

        Tester obj = new Tester();
       
        // Bind this object instance to the name "Tester"
        Naming.rebind("//localhost/Tester", obj);
        //Start game frame here. 
        l=new logic();
        l.init();
        board = new yuginoh();
        board.l=l;
        board.t=obj;
        board.Tester = true;
        yuginoh.main(null);
        
        
        
        
        int i=0;
        while (i==0){
        	try{
        TInterface oj = (TInterface) Naming.lookup("//localhost/Client");
        System.out.println(oj.heyo());
        	i=1;
        	}catch(Exception e){
        		
        	}
        }
       System.out.println("out of infinite loop");
         
    }
}