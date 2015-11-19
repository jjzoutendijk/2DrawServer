package Server;

import java.awt.Color;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * This interface must be implemented to use the RMI for the 2Draw game.
 * @author Jan Jaap Zoutendijk
 *
 */
public interface PlayerInterface extends Remote, Serializable {
	public void addPlayer(Player p) throws RemoteException;
	public Player getPlayer(int i) throws RemoteException;
	public void removePlayer(Player p) throws RemoteException;
	public int numberOfPlayers() throws RemoteException;
	public ArrayList<Player> getPlayers() throws RemoteException;
}


