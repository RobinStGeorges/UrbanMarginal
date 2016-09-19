package outils.connexion;
import java.io.IOException;
import  java.net.ServerSocket;
import java.net.Socket;
public class ServeurSocket extends Thread {
	private Object leRecepteur;
	private ServerSocket serverSocket;
	int port;
	
	public ServeurSocket(Object leRecepteur, int port){
		this.leRecepteur = leRecepteur;
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("erreur grave création socket serveur   :   "+e);
			System.exit(0);
		}
		start();
		
	}
	public void run(){
		Socket socket;
		while(true){
			try {
				System.out.println("le serveur attend");
				socket=serverSocket.accept();
				System.out.println("Un client s'est connecté");
			} catch (IOException e) {
				System.out.println("erreur grave création socket serveur   :   "+e);
				System.exit(0);
			}
		}
	}
	

}


