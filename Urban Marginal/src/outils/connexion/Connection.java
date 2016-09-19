package outils.connexion;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection {
	private Object leRecepteur;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	public void connection(Socket socket,Object leRecepteur){
		this.leRecepteur = leRecepteur;
		
	}

}
