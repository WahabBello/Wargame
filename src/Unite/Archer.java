package wargame;

public class Archer extends Unite {

	public Archer(String nom) {
		super(nom);
		this.Point_Attaque = 6;
		this.Point_Defense = 2;
		this.Point_Deplacement = 5;
		this.Vision = 7;
		this.Point_Vie = 33;
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
