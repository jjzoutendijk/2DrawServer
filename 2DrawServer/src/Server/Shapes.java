package Server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Shapes implements ShapeInterface, Serializable{
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	
	@Override
	public void addShape(Shape s) throws RemoteException {
		shapes.add(s);
	}
	
	@Override
	public ArrayList<Shape> getShapes() throws RemoteException{
		return this.shapes;
	}
	
	/*
	public int getSize(){
		return this.shapes.size();
	}
	
	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	*/

}
