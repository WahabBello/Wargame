package wargame;

public class Mage extends Unite {

	public Mage(String nom) {
		super(nom);
		this.Point_Attaque = 5;
		this.Point_Defense = 1;
		this.Point_Deplacement = 5;
		this.Vision = 5;
		this.Point_Vie = 24;
	}
	
	public void Niveau_Vie(int degat) {
		if(degat >=0) {
			this.Point_vie_restant = this.Point_Vie - degat;
			System.out.println("Il vous reste " + this.Point_vie_restant + " Points de vie");
		}
		else {
			this.Point_vie_restant = this.Point_Vie + degat;
			System.out.println("Il vous reste " + this.Point_vie_restant + " Points de vie");
		}
	}
}
