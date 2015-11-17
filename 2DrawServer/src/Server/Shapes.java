package Server;

import java.awt.Color;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Shapes class implements the shape interface. 
 * @author Jan Jaap Zoutendijk
 *
 */
public class Shapes implements ShapeInterface, Serializable{
	/* ------------------------------------------------------------------------------------------------------
	 * Class Variables
	 * ------------------------------------------------------------------------------------------------------
	 */
	private ArrayList<Shape> shapesList = new ArrayList<Shape>();
	
	/* ------------------------------------------------------------------------------------------------------
	 * Class Variables
	 * ------------------------------------------------------------------------------------------------------
	 */
	@Override
	public void addShape(Shape s) throws RemoteException {
		System.out.println("Info on received shape: "+ s.toString());
		shapesList.add(s);
	}
	
	@Override
	public ArrayList<Shape> getShapes() throws RemoteException{
		return this.shapesList;
	}

	@Override
	public String getType(int i) throws RemoteException {
		Shape shape = shapesList.get(i);
		return shape.getType();
	}

	@Override
	public Color getColor(int i) throws RemoteException {
		Shape shape = shapesList.get(i);
		return shape.getColor();
	}
	

}
