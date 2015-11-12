package Server;

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
         System.setProperty("java.security.policy","file:./server.policy");
         if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
       
        try {
            String name = "ShapeServices";
            System.out.println("OK");
            ShapeServices ss = new ShapeServiceImplementation();
            System.out.println("OK2");
            ShapeServices stub =
                (ShapeServices) UnicastRemoteObject.exportObject(ss, 3019);
            Registry registry = LocateRegistry.getRegistry();
            System.out.println(registry.toString());
            registry.rebind(name, stub);
            System.out.println("OK4");
            System.out.println("service bound");
        } catch (Exception e) {
            System.err.println("service exception2:");
            e.printStackTrace();
        }
    }

	@Override
	public void addShape(Shape s) throws RemoteException {
		System.out.println("Added: " + s);
	}

	@Override
	public ArrayList<Shape> getShapes() throws RemoteException {
		System.out.println("getshapes called");
		return new ArrayList<Shape>();
	}
}