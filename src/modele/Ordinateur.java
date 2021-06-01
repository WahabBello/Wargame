package modele;


//Classe fille de la classe parent Joueur 

public class Ordinateur extends Joueur {

	public Ordinateur() {
		super("Ordinateur");
	}

	// Methode pour regler l'IA

	// public int choix_IA(String terrain, int Bonus_Defense, Unite unite,int p){
	// int i = (int)(Math.Random()*10);
	// if (i<3 || i>8) {
	// return Attaque(terrain,Bonus_Defense,unite);
	// }else{
	// return Se_Deplace(terrain,p);
	// }

}