package Server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ShapeServiceImplementation implements ShapeServices {

    public ShapeServiceImplementation() {
        super();
    }


    public static void main(String[] args) {
         if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
       
        try {
            ShapeServices ss = new ShapeServiceImplementation();
            ShapeServices stub = (ShapeServices) UnicastRemoteObject.exportObject(ss, 3000);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("rmi://localhost/ABC", stub);
            System.out.println("service bound");
        } catch (Exception e) {
            System.err.println("Server service exception:");
            e.printStackTrace();
        }
    }
    

	@Override
	public void addShape(Shape s) throws RemoteException {
		System.out.println("Added: " + s);
	}
	
	@Override
	public ArrayList<Shape> getShapes() throws RemoteException{
		System.out.println("return Shapes");
		return new ArrayList<Shape>();
	}


}