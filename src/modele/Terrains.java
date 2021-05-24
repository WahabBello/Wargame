package modele;

public class Terrains {

	private String Nom;
	private int Point_Deplacement;
	private int Bonus_Defense;
	
	public Terrains(String nom, int pDepl, int bD) {
		this.Nom = nom;
		this.Point_Deplacement = pDepl;
		this.Bonus_Defense = bD;
	}
	
	
	public void Info_Terrain(Terrains t) {
		
		if(this.Nom == t.Nom) {

			System.out.println("Vous avez choisi le terrain " + t.Nom);
			System.out.println("Point Déplacement : " + t.Point_Deplacement + " Point Defense : " + t.Bonus_Defense);
		}
		else{ System.out.println("Vous avez choix un mauvais terrain ...");}
	}
	
	public int getPoint_Deplacement() {
		return Point_Deplacement;
	}
	
	public int getBonus_Defense() {
		return Bonus_Defense;
	}
	
	
}
