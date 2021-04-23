package wargame;


public class Infanterie_lourde extends Unite {

	public Infanterie_lourde(String nom) {
		super(nom);
		this.Point_Attaque = 10;
		this.Point_Defense = 10;
		this.Point_Deplacement = 4;
		this.Vision = 4;
		this.Point_Vie = 38;
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
	
