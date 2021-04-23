package unite;

public class Cavalerie extends Unite {

	public Cavalerie(String nom) {
		super(nom);
		this.Point_Attaque = 8;
		this.Point_Defense = 3;
		this.Point_Deplacement = 8;
		this.Vision = 6;
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
