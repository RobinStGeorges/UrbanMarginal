package modele;

import javax.swing.JLabel;
import controleur.Global;

public class Label implements Global{
	private static int nbLabel;
	private JLabel jLabel;
	
	//Constructeur
	public Label(int nbLabel, JLabel jLabel){
		this.nbLabel = nbLabel;
		this.jLabel = jLabel;
}
	//--- Getters ---
		public int getNbLabel () {
			return this.nbLabel ;
		}
		public static void setNbLabel(int nbLabel) {
			Label.nbLabel = nbLabel;
		}
		
		public JLabel getJLabel () {
			return this.jLabel ;
	}
}
