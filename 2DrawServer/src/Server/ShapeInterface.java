package Server;

import java.awt.Color;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * The interface on the server that is used to register which functions should be available on the shapes objects
 * @author Student
 *
 */
public interface ShapeInterface extends Remote, Serializable  {
	public void addShape(Shape S) throws RemoteException;
	public ArrayList<Shape> getShapes() throws RemoteException;
	public String getType(int i) throws RemoteException;
	public Color getColor(int i) throws RemoteException;
}
