package outils.connexion;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ClientSocket {
	private boolean connectionOk;
	public ClientSocket(String ip, int port, Object leRecepteur){
		connectionOk=false;
		Socket socket;
		try {
			socket = new Socket(ip,port);
			connectionOk=true;
			JOptionPane.showMessageDialog(null, "Connection reussi!");
			new Connection(socket,leRecepteur);
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Error HOST!");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error IO!");
			e.printStackTrace();
		}
	}
	/**
	 * @return the connectionOk
	 */
	public boolean isConnectionOk() {
		return connectionOk;
	}
	

}
