package Server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


/**
 * 
 * Server for the 2Draw application. Prints the shape as soon as an application sents the information.
 * 
 * Run with the following VM arguments:
 * -Djava.security.policy=file:<location of the policy file> 
 * e.g.: 
 * -Djava.security.policy=file:///C:\Users\Student\Documents\2DrawServer\2DrawServer\server.policy
 * -Djava.rmi.server.codebase=<codebase of the server>
 * e.g.:
 * -Djava.rmi.server.codebase=file:/C:\Users\Student\Documents\2DrawServer\2DrawServer\bin\
 * 
 * Policy file (can be created with the policy tool in JDK):
 * grant {
 *    	permission java.security.AllPermission;
 *    };
 * 
 * Program for checking for RMI registry:
 * http://marxsoftware.blogspot.nl/2009/06/viewing-names-bound-to-rmi-registry.html
 * 
 * Start the rmi registry tool from the command line from the bin folderof the server.
 * 
 * @author Jan Jaap Zoutendijk
 *
 */
public class ShapeServer {

	/* ------------------------------------------------------------------------------------------------------
	 * Main Method for the application
	 * ------------------------------------------------------------------------------------------------------
	 */
    public static void main(String[] args) {
    	// Check of the security manager is installed, if not se it.
         if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
	   try {
		   // Locate the RMI registry
		   Registry registry = LocateRegistry.getRegistry();
		   
		   // Create the Player object ref in the registry and bind it		   
		   Players players = new Players();
		   PlayerInterface stubPlayer = (PlayerInterface) UnicastRemoteObject.exportObject(players, 3001);
		   Naming.rebind("rmi://localhost/Players", players);
		   
		   // Similar process for shapes.
		   Shapes Hello = new Shapes();	
           ShapeInterface stub = (ShapeInterface) UnicastRemoteObject.exportObject(Hello, 3001);
           Naming.rebind("rmi://localhost/Shapes", Hello);
           
           // Confirm to the console the server is ready
		   System.out.println("2Draw Server is ready.");
		   } catch (Exception e) {
			   System.out.println("2Draw Server failed: " + e);
			   e.printStackTrace();
		   }
    }
    
}