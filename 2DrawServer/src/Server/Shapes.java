package Server;

import java.awt.Color;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Shapes implements ShapeInterface, Serializable{
	private ArrayList<Shape> shapesList = new ArrayList<Shape>();

	
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
	
	
	
	/*
	public int getSize(){
		return this.shapes.size();
	}
	
	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	*/

}
