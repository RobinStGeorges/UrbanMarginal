package modele;

import outils.connexion.Connection;
import controleur.Controle;

public abstract class Jeu {
	public void envoi(Connection connection, Object info){
		connection.envoie(info);		
	}
	public abstract void deconnection(Connection connection);
	public abstract void setConnection(Connection connection);
	protected Controle controle;
	public abstract void reception(Connection connection, Object info);

}
