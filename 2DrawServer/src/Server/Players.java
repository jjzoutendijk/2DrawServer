package Server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * This players class hold a arraylist with players. It implements the most important methods that must be performed on this 
 * arraylist. Furthermore it implements the serializable and player interface to ensure it is functional with RMI.
 * 
 * @author Student
 *
 */
public class Players implements PlayerInterface, Serializable {	
	private ArrayList<Player> players = new ArrayList<Player>();
	public static int playerNumber;

	@Override
	public void addPlayer(Player p) throws RemoteException {
		players.add(p);
		System.out.println("Added a player to the game: "+ Players.playerNumber);
		playerNumber++;
	}
	
	@Override
	public Player getPlayer(int i) throws RemoteException {
		return players.get(i);
	}


	@Override
	public void removePlayer(Player p) throws RemoteException {
		int i = players.indexOf(p);
		players.remove(i);
		System.out.println("Removed player from the game: " + p.toString());
	}

	@Override
	public int numberOfPlayers() throws RemoteException {
		return players.size();
	}
	
	@Override
	public ArrayList<Player> getPlayers() throws RemoteException{
		return this.players;
	}
	
	
}
