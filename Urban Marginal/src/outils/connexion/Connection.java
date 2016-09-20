package outils.connexion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;
/**
 * 
 * @author Kireta
 *Classe
 */
public class Connection extends Thread {
	public void envoie(Object unObjet) {
		try {
			out.writeObject(unObjet);
			out.flush();
		} catch (IOException e) {
			System.out.println("Erreur sur le OUT Connection");
			e.printStackTrace();
		}
	}
	private Object leRecepteur;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	/**
	 * Declaration
	 * @param socket
	 * @param leRecepteur
	 */
	public Connection(Socket socket,Object leRecepteur){
		this.leRecepteur = leRecepteur;
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("erreur sortie out :"+e);
			System.exit(0);
		}
		try {
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("erreur entree in :"+e);
			System.exit(0);
}
		start();
		
	}
	public void run(){
		boolean inOk=true;
		Object reception;
		while(inOk){
			try {
				reception=in.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println("Erreur de classe");
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "L'ordinateur distant s'est deconnecte");
				e.printStackTrace();
				inOk=false;
				try {
					in.close();
				} catch (IOException e1) {
					System.out.println("Erreur à la fermeture");
					e1.printStackTrace();
				}
			}
		}
	}

}
