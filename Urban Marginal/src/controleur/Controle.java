package controleur;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Jeu;
import modele.JeuClient;
import modele.JeuServeur;
import outils.connexion.ClientSocket;
import outils.connexion.Connection;
import outils.connexion.ServeurSocket;
import vue.Arene;
import vue.ChoixJoueur;
import vue.EntreeJeu;

public class Controle implements Global {
	private ChoixJoueur frmChoixJoueur;
	private Arene frmArene;
	private Jeu leJeu;
	private EntreeJeu frmEntreeJeu;
	private outils.connexion.Connection connection;
	
	public void receptionInfo(Connection connection, Object info){
		leJeu.reception(connection,info);
	}

	public Controle() {
		this.frmEntreeJeu = new EntreeJeu(this);
		frmEntreeJeu.setVisible(true);
	}
	public void setConnection(outils.connexion.Connection connection){
		this.connection = connection;
		if (leJeu instanceof JeuServeur){
			leJeu.setConnection(connection);
		}
	}

	public static void main(String[] args) {
		new Controle();
	}

	/**
	 * 
	 * @param uneFrame
	 * @param info
	 */
	public void evenementVue(JFrame uneFrame, Object info) {

		if (uneFrame instanceof EntreeJeu) {
			evenementEntreeJeu(info);
		}
		if (uneFrame instanceof ChoixJoueur){
			evenementChoixJoueur(info);
		}
	}
	public void  evenementModele(Object unJeu,String ordre,Object info){
		if(unJeu instanceof JeuServeur){
			evenementJeuServeur(ordre,info);
		}
		if(unJeu instanceof JeuClient){
			evenementJeuClient(ordre,info);
		}
	}
	private void evenementJeuClient(String ordre,Object info){
		if(ordre=="ajoutPanelMurs"){
			frmArene.ajoutPanelMurs((JPanel)info);
		}
	}//wtf
	private void evenementJeuServeur(String ordre, Object info) {
		// TODO Auto-generated method stub
		if(ordre=="ajout mur"){
			frmArene.ajoutMur((JLabel)info);
			//test
			//System.out.println("mur sont ajouté au frmArene");
		}
		if(ordre=="envoiPanelMurs"){
			((JeuServeur)leJeu).envoi((Connection)info, frmArene.getJpnMur());
		}
	}

	private void evenementChoixJoueur(Object info){
		((JeuClient)leJeu).envoi(info);
		frmChoixJoueur.dispose();
		frmArene.setVisible(true);
	}
	
	private void evenementEntreeJeu(Object info) {
		if ((String) info == "serveur") {
			new ServeurSocket(this, PORT);
			leJeu = new JeuServeur(this);
			frmEntreeJeu.dispose();
			frmArene = new Arene();
			((JeuServeur)leJeu).constructionMurs();
			frmArene.setVisible(true);
		} else {
			if ((new ClientSocket((String) info, PORT, this)).isConnectionOk()) {
				leJeu = new JeuClient(this);
				leJeu.setConnection(connection);
				frmEntreeJeu.dispose();
				frmChoixJoueur = new ChoixJoueur(this);
				frmChoixJoueur.setVisible(true);
				frmArene = new Arene();
			}
		}
	};

}