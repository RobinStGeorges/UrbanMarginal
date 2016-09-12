package outils.connexion;
import java.io.IOException;
import  java.net.ServerSocket;
public class ServeurSocket {
	private Object lerecepteur;
	private ServerSocket serversocket;
	int port;
	
	public ServeurSocket(Object lerecepteur, int port){
		this.lerecepteur = lerecepteur;
		try {
			serversocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}


