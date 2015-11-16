package Server;

import java.io.Serializable;

import Server.Shape;

/**
 * This is a class for the square shape
 * 
 * @author Jan Jaap Zoutendijk
 * @version 1.0 
 */
public class Square extends Shape implements Serializable{
	/* ------------------------------------------------------------------------------------------------------
	 * The Constructors
	 * ------------------------------------------------------------------------------------------------------
	 */
	public Square() {
		super();
		this.setType("Square");
	}

	
	
}
