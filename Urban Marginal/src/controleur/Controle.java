package controleur;

import javax.swing.JFrame;

import modele.Jeu;
import modele.JeuClient;
import modele.JeuServeur;
import outils.connexion.ClientSocket;
import outils.connexion.ServeurSocket;
import vue.Arene;
import vue.ChoixJoueur;
import vue.EntreeJeu;

public class Controle implements Global {
	private ChoixJoueur frmChoixJoueur;
	private Arene frmArene;
	private Jeu leJeu;
	private EntreeJeu frmEntreeJeu;

	public Controle() {
		this.frmEntreeJeu = new EntreeJeu(this);
		frmEntreeJeu.setVisible(true);
	}

	public static void main(String[] args) {
		new Controle();
	}

	/**
	 * 
	 * @param uneFram
	 * @param info
	 */
	public void evenementVue(JFrame uneFrame, Object info) {

		if (uneFrame instanceof EntreeJeu) {
			evenementEntreeJeu(info);
		}
		if (uneFrame instanceof ChoixJoueur){
			evenementChoixJoueur();
		}
	}
	private void evenementChoixJoueur(Object info){
		((JeuClient)leJeu).envoi(null, info);
		frmChoixJoueur.dispose();
		frmArene.setVisible(true);
	}
	private void evenementEntreeJeu(Object info) {
		if ((String) info == "serveur") {
			new ServeurSocket(this, PORT);
			leJeu = new JeuServeur(this);
			frmEntreeJeu.dispose();
			(frmArene = new Arene()).setVisible(true);
		} else {
			if ((new ClientSocket((String) info, PORT, this)).isConnectionOk()) {
				frmEntreeJeu.dispose();
				frmChoixJoueur = new ChoixJoueur(this);
				frmChoixJoueur.setVisible(true);
			}
		}
	};

}
