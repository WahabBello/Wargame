package modele;

import java.awt.Polygon;
import java.awt.TexturePaint;

import vue.Hexagone;

public abstract class Unite {
	
	private String Nom;
	private int Point_Attaque;
	private int Point_Defense;
	private int Point_Deplacement;
	private int Vision;
	private int Point_Vie;
	private int Point_Deplacement_Restant;
	private int Point_vie_restant;
	private int Degat;
	private int Degat_Brut;

	protected TexturePaint image_unite;
	protected int X;
	protected int Y;
	

	public Unite(String nom, int pA, int pD, int pDepl, int vision, int pv) {
		this.setNom(nom);
		this.setPoint_Attaque(pA);
		this.setPoint_Defense(pD);
		this.setPoint_Deplacement(pDepl);
		this.setVision(vision);
		this.setPoint_Vie(pv);
	}
	
	//Faire deplacer une unité
	// public int Se_Deplace(Terrains t, Unite u, int x_depart, int y_depart, int x_final, int y_final) {
	public void Se_Deplace(Hexagone depart, Hexagone arrive) {
		/*
			distance entre le x final et le x de départ sera comparé à la vision d'une unité
			si x_initial = x_final alors on modifie le y sinon (y_initiaal = y_final) on modifie le x
			*/
		int Distance_X, Distance_Y;
		// Distance_X = x_final - x_depart;
		// Distance_Y = y_final - y_depart;
		Distance_X = arrive.j_hexa - depart.j_hexa;
		Distance_Y = arrive.i_hexa - depart.i_hexa;
		
		// if(Distance_X <= u.Vision && Distance_Y <= u.Vision) {		
		if(Distance_X <= depart.unite.getVision() && Distance_Y <= depart.unite.getVision()) {		
			// u.X = x_final;
			// u.Y = y_final;
			arrive.unite = depart.unite;
			// Point restant après déplacement
			// u.Point_Deplacement_Restant = u.Point_Deplacement - t.getPoint_Deplacement();
			// return u.Point_Deplacement_Restant;	
			arrive.unite.setPoint_Deplacement_Restant(arrive.unite.getPoint_Deplacement() - arrive.getPoint_deplacements());
			// return u.Point_Deplacement_Restant;	
		}
		else {
			System.out.println("Pas de déplacement");
			System.out.println(depart.unite.getPoint_Deplacement());
			// return u.Point_Deplacement;
			// return ;
		}
			
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
		// pour faire une attaque t.etat !=0
	
	public int Attaque(Terrains t, Unite unite) {
		int Cx_unite = 0 , Cy_unite = 0; // coordonnée adversaire
		if(Atteignable(unite.X, unite.Y, Cx_unite, Cy_unite) ) {	//&& t.etat !=0) {
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
			// Se_Deplace(t, unite, unite.X, unite.Y, Cx_unite, Cy_unite);
			// Se_Deplace(t, unite, unite.X, unite.Y, Cx_unite, Cy_unite);
		}
		
		return this.Degat;
	}
	
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

	public abstract TexturePaint loadImages(Polygon dimension);

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public int getPoint_Attaque() {
		return Point_Attaque;
	}

	public void setPoint_Attaque(int point_Attaque) {
		Point_Attaque = point_Attaque;
	}

	public int getPoint_Defense() {
		return Point_Defense;
	}

	public void setPoint_Defense(int point_Defense) {
		Point_Defense = point_Defense;
	}

	public int getPoint_Deplacement() {
		return Point_Deplacement;
	}

	public void setPoint_Deplacement(int point_Deplacement) {
		Point_Deplacement = point_Deplacement;
	}

	public int getVision() {
		return Vision;
	}

	public void setVision(int vision) {
		Vision = vision;
	}

	public int getPoint_Vie() {
		return Point_Vie;
	}

	public void setPoint_Vie(int point_Vie) {
		Point_Vie = point_Vie;
	}

	public int getPoint_Deplacement_Restant() {
		return Point_Deplacement_Restant;
	}

	public void setPoint_Deplacement_Restant(int point_Deplacement_Restant) {
		Point_Deplacement_Restant = point_Deplacement_Restant;
	}

	public int getPoint_vie_restant() {
		return Point_vie_restant;
	}

	public void setPoint_vie_restant(int point_vie_restant) {
		Point_vie_restant = point_vie_restant;
	}

	public int getDegat_Brut() {
		return Degat_Brut;
	}

	public void setDegat_Brut(int degat_Brut) {
		Degat_Brut = degat_Brut;
	}

	public void setDegat(int degat) {
		Degat = degat;
	}

}
