package modele;

import java.awt.Polygon;
import java.awt.TexturePaint;

public abstract class Unite {
	
	protected String Nom;
	protected int Point_Attaque;
	protected int Point_Defense;
	protected int Point_Deplacement;
	protected int Vision;
	protected int Point_Vie;
	protected int Point_Deplacement_Restant;
	protected int Point_vie_restant;
	protected int Degat;
	protected int Degat_Brut;

	protected TexturePaint image_unite;
	protected int X;
	protected int Y;
	
	
	public Unite(String nom, int pA, int pD, int pDepl, int vision, int pv) {
		this.Nom = nom;
		this.Point_Attaque = pA;
		this.Point_Defense = pD;
		this.Point_Deplacement = pDepl;
		this.Vision = vision;
		this.Point_Vie = pv;
	}
		
		//Faire deplacer une unité
	public int Se_Deplace(Terrains t, Unite u, int x_depart, int y_depart, int x_final, int y_final) {
		
		/* distance entre le x final et le x de départ sera comparé à la vision d'une unité */
		int Distance;
		Distance = x_final - x_depart;
		if(Distance <= u.Vision) {
			u.X = x_depart + x_final;
			u.Y = y_depart + y_final;
			
			// Point restant après déplacement
			u.Point_Deplacement_Restant = u.Point_Deplacement - t.getPoint_Deplacement();
		}
		
		return u.Point_Deplacement_Restant;
	}
	
	// Verifie si une case contient déja une unité ou pas
	public boolean EtatCase(Object objet) {
		if(objet != null) {
			System.out.println("Objet est présent");
			return true;
		}
		else { 
			System.out.println("Objet n'a pas été crée");
			return false;
		}
	}
	/*
	 *Vérifie si une attaque est possible 
	 */
	public boolean Atteignable(int x_depart, int y_depart, int x_final, int y_final) {
		int x_distance;
		int y_distance;
		x_distance = Math.abs(x_depart-x_final);
		y_distance = Math.abs(y_depart-y_final);
		if( (x_distance == 0 || x_distance == 1) && (y_distance == 1 || y_distance == 2) ){
			return true;
		}
		else {return false;}
	}
	
		//Attaque une unité adverses ou se deplace
	
	public int Attaque(Terrains t, Unite unite) {
		int Cx_unite = 0 , Cy_unite = 0; // coordonnée adversaire
		if(Atteignable(unite.X, unite.Y, Cx_unite, Cy_unite) ) {
			this.Degat_Brut = this.Point_Attaque -( unite.Point_Defense + (unite.Point_Defense*t.getBonus_Defense()/100)+1 );
			int min = -this.Degat_Brut/2;
			int max = this.Degat_Brut/2;
			int range = max-min + 1;
			int nombre_aleatoire = (int) (Math.random()*range ) + min;
				
			this.Degat = this.Degat_Brut + (nombre_aleatoire);
			System.out.println(this.Nom + " a attaqué " + unite.Nom + " et lui causé " + (this.Degat) + " Points");	
		}
		else { 
			System.out.println("Vous ne pouvez pas attaquer" );
			Se_Deplace(t, unite, unite.X, unite.Y, Cx_unite, Cy_unite);
		}
		
		return this.Degat;
	}
	
	public abstract TexturePaint loadImages(Polygon dimension);
	//Recuperer le degat causé net lors d'une attaque
	public int getDegat() {
		return Degat;
	}
	
		//regenerer une unité
	public void Recuperer(Unite unite) {
		int regenere = ( (10*unite.Point_Vie/100) +1);
		unite.Point_Vie = regenere  + unite.Point_vie_restant;
		System.out.println(unite.Nom + " s'est regenerée de " + regenere + " Points");
		System.out.println("Points de vie :  " + unite.Point_Vie);
			
	}

}
