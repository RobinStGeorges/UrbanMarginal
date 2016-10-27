package modele;

import java.util.ArrayList;
import java.util.Hashtable;

import controleur.Controle;
import controleur.Global;
import outils.connexion.Connection;

public class JeuServeur extends Jeu implements Global {
	private ArrayList<Mur> lesMurs = new ArrayList<Mur>();
	
	private Hashtable<Connection, Joueur> lesJoueurs = new Hashtable<Connection, Joueur>();	
	
	public JeuServeur(Controle controle){
		super.controle=controle;
		Label.setNbLabel(0);
	}
	
	public void constructionMurs(){
		for(int i = 0; i < NBMURS; i++){
			lesMurs.add(new Mur());
			controle.evenementModele(this, "ajout mur", lesMurs.get(i).getLabel().getJLabel());
			//test d'ajout des murs
			//System.out.println(i+"ème mur ajouté");
		}
	}

	@Override
	public void deconnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub
		lesJoueurs.put(connection ,new Joueur());
		controle.evenementModele(this, "ordreNouveauJoueur", "nouvelle Connection");
		} 

	@Override
	public void reception(Connection connection, Object info) {
		
	}

}
