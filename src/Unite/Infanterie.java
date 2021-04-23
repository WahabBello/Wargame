package Unite;


public class Infanterie extends Unite {
	

	public Infanterie(String nom) {
		super(nom);
		this.Point_Attaque = 5;
		this.Point_Defense = 3;
		this.Point_Deplacement = 6;
		this.Vision = 4;
		this.Point_Vie = 28;
		
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




