package controleur;
import javax.swing.JFrame;

import vue.EntreeJeu;

public class Controle {
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
		System.out.println((String)info) ;
		
	};

	/**
	 * ceci est un test
	 */
}



