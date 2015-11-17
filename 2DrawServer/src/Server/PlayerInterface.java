package Server;

import java.awt.Color;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface PlayerInterface extends Remote, Serializable {
	public void addPlayer(Player P) throws RemoteException;
	public Player getPlayer(int i) throws RemoteException;
	public void removePlayer(int i) throws RemoteException;
	public int numberOfPlayers() throws RemoteException;
	public ArrayList<Player> getPlayers() throws RemoteException;
}


