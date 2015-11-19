package Server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * This class is server side based. Pojo class for a player object in the 2Draw game. 
 * @author Jan Jaap Zoutendijk
 *
 */

public class Player implements Serializable {
	/* ------------------------------------------------------------------------------------------------------
	 * Class Variables
	 * ------------------------------------------------------------------------------------------------------
	 */
	private String Name;
	boolean active;
	int index;
	
	/* ------------------------------------------------------------------------------------------------------
	 * Class Class Methods
	 * ------------------------------------------------------------------------------------------------------
	 */
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Player(){
		this.setName("Anonymous");
		
	}
	
	@Override
	/**
	 * Print the following text: Player [index]
	 */
	public String toString(){
		return "Player " + this.getName();
	}
	
	@Override
	/**
	 * Overrides the equals method for a player object  
	 */
	public boolean equals(Object p){
		if( !(p instanceof Player)){
			return false; 
		}
		else {
			Player p1 = (Player) p;
			return ((p1.getIndex() == this.getIndex() ));
		}
	}
	
}
