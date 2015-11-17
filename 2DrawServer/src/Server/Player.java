package Server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Player implements Serializable {
		// Class variables
	private String Name;
	boolean active;
	int index;
	
	
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
	
	@Override
	public String toString(){
		return "Player " + this.index;
	}
	
}
