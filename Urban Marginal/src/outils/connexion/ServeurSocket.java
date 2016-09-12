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
			System.out.println("erreur grave création socket serveur   :   "+e);
			System.exit(0);
		}
		
	}
	

}


