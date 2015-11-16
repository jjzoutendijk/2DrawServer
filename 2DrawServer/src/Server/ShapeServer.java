package Server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


/**
 * Run with the following VM arguments:
 * 
 * -Djava.security.policy=file:${workspace_loc}/2DrawServer/server.policy
 * -Djava.rmi.server.codebase=file:${workspace_loc}/2DrawServer/bin/
 * 
 * Policy files:
 * grant {
 *    	permission java.security.AllPermission;
 *    };
 * 
 * Program for checking for RMI registry:
 * http://marxsoftware.blogspot.nl/2009/06/viewing-names-bound-to-rmi-registry.html
 * 
 * @author Student
 *
 */
public class ShapeServer implements ShapeInterface {
	
	private ArrayList<Shape> shapesList = new ArrayList<Shape>();
	
    public ShapeServer() {
        super();
    }


    public static void main(String[] args) {
         if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

     
	   try {
		  // System.setSecurityManager(new SecurityManager());
		   Registry registry = LocateRegistry.getRegistry();
		   Shapes Hello = new Shapes();	
		   Shape s1 = new Circle();
		   Hello.addShape(s1);
		   ShapeInterface ss = new ShapeServer();
           ShapeInterface stub = (ShapeInterface) UnicastRemoteObject.exportObject(ss, 3001);
           Naming.rebind("rmi://localhost/Shapes", Hello);
		   System.out.println("Shape Server is ready.");
		   }catch (Exception e) {
			   System.out.println("Shape Server failed: " + e);
			   e.printStackTrace();
			}
	   }


	@Override
	public void addShape(Shape S) throws RemoteException {
		shapesList.add(S);
		System.out.println("Added Shape");
		
	}


	@Override
	public ArrayList<Shape> getShapes() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
    
   


}