package Server;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


/**
 * Run with the following VM arguments:
 * 
 * -Djava.security.policy=file:${workspace_loc}/RMIClientSide/security.policy
 * -Djava.rmi.server.codebase=file:${workspace_loc}/2DrawServer/bin/
 * 
 * Policy files:
 * 
 * 
 * 
 * 
 * @author Student
 *
 */
public class ShapeServer implements ShapeInterface {

    public ShapeServer() {
        super();
    }


    public static void main(String[] args) {
         if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
       
//        try {
//            ShapeServices ss = new ShapeServiceImplementation();
//            ShapeServices stub = (ShapeServices) UnicastRemoteObject.exportObject(ss, 3000);
//            Registry registry = LocateRegistry.getRegistry();
//            registry.rebind("rmi://localhost/ABC", stub);
//            System.out.println("service bound");
//        } catch (Exception e) {
//            System.err.println("Server service exception:");
//            e.printStackTrace();
//        }
         
		   try {
			  // System.setSecurityManager(new SecurityManager());
 
			   Shapes Hello = new Shapes();			   		   
			   Naming.rebind("rmi://localhost/Shape", Hello);
			   ShapeInterface ss = new ShapeServer();
	           ShapeInterface stub = (ShapeInterface) UnicastRemoteObject.exportObject(ss, 3000);
	           Registry registry = LocateRegistry.getRegistry();
			   System.out.println("Shape Server is ready.");
			   }catch (Exception e) {
				   System.out.println("Shape Server failed: " + e);
				}
		   }


	@Override
	public void addShape(Shape S) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ArrayList<Shape> getShapes() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
    
   


}