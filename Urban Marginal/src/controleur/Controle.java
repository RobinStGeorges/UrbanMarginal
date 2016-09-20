package controleur;
import javax.swing.JFrame;

import modele.Jeu;
import modele.JeuServeur;
import outils.connexion.ClientSocket;
import outils.connexion.ServeurSocket;
import vue.Arene;
import vue.EntreeJeu;


public class Controle {
	private Arene frmArene;
	private Jeu leJeu;
private EntreeJeu frmEntreeJeu;
public Controle(){
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
	public void evenementVue(JFrame uneFrame,Object info){
		
		if(uneFrame instanceof EntreeJeu){
			evenementEntreeJeu(info);
		}
		}
	private void evenementEntreeJeu(Object info) {
		if((String)info == "serveur"){
			new ServeurSocket(this, 6666);
			leJeu = new JeuServeur(this);
			frmEntreeJeu.dispose();
			(frmArene = new Arene()).setVisible(true);
		}
		else{
			(new ClientSocket((String) info,6666,this)).isConnectionOk();
		}
	};

	
}



