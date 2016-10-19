package modele;

public abstract class Objet {
	protected int posX;
	protected int posY;
	protected Label label;
	
	//Getters
	public int getPosX(){
		return posX;
	}
	public int getPosY(){
		return posY;
	}
	public Label getLabel(){
		return label;
	}
}
