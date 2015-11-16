package Server;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface ShapeInterface extends Remote, Serializable  {
	public void addShape(Shape S) throws RemoteException;
	public ArrayList<Shape> getShapes() throws RemoteException;
	public String getType(int i) throws RemoteException;
}
