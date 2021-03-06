package controleur;

public interface Global {
	public static final int PORT=6666;
	public static final String SEPARATOR="//";
	public static final String CHEMIN ="media"+SEPARATOR;
	public static final String CHEMINFONDS = CHEMIN + "fonds"+ SEPARATOR;
	public static final String FONDCHOIX = CHEMINFONDS + "fondchoix.jpg";
	public static final int GAUCHE = 0;
	public static final int DROITE = 1;
	public static final String CHEMINPERSOS = CHEMIN + "personnages"+ SEPARATOR;
	public static final String PERSO = CHEMINPERSOS + "perso"; 
	public static final String EXTIMAGE =".gif";
	public static final String MARCHE  ="marche";
	public static final String BLESSE  ="touche";
	public static final String MORT  ="mort";
	public static final int NBPERSO  = 3;
	public static final int H_PERSO  = 44;
	public static final int L_PERSO  = 39;
	public static final String SEPARE = "~";
	public static final int PSEUDO = 0;
	public static final int H_ARENE = 600;
	public static final int L_ARENE = 800;
	public static final int H_CHAT = 200;
	public static final int H_SAISIE = 25;
	public static final int MARGE = 5;
	public static final String FONDARENE = CHEMINFONDS+"fondarene.jpg";
	public static final int NBMURS = 20;
	public static final String CHEMINMURS = CHEMIN +"murs"+SEPARATOR;
	public static final String MUR = CHEMINMURS+"mur.gif";// image du mur
	public static final int H_MUR = 35;// hauteur de l'image
	public static final int L_MUR = 34;// largeur de l'image
	
}
