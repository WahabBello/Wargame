package modele;

import java.awt.Polygon;
import java.awt.TexturePaint;

import vue.Hexagone;

public abstract class Unite {
	
	private String Nom;
	private int Point_Attaque;
	private int Point_Defense;
	private int Point_Deplacement;
	private int Point_Deplacement_Restant;
	private int Vision;
	private int Point_Vie;
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
		this.setPoint_Deplacement_Restant(pDepl);
		this.setVision(vision);
		this.setPoint_Vie(pv);
		this.setPoint_vie_restant(pv);
	}
	
	//Faire deplacer une unité
	public Boolean vision_v(Hexagone depart, Hexagone arrive) { 
				/*	distance entre le x final et le x de départ sera comparé à la vision d'une unité
			si x_initial = x_final alors on modifie le y sinon (y_initiaal = y_final) on modifie le x	*/
		int Distance_X, Distance_Y;
		Distance_X = arrive.j_hexa - depart.j_hexa;
		Distance_Y = arrive.i_hexa - depart.i_hexa;
		if(Distance_X <= depart.unite.getVision() && Distance_Y <= depart.unite.getVision()) {		
			return true;
		}
		else {
			return false;
		}
	}
	public void se_deplace(Hexagone depart, Hexagone arrive) {
			arrive.unite = depart.unite;
			arrive.unite.setPoint_Deplacement_Restant(arrive.unite.getPoint_Deplacement_Restant() - arrive.getPoint_deplacements());
	}
	
	// Verifie si une case contient déja une unité ou pas
	// public boolean EtatCase(Object objet) {
	// 	if(objet != null) {
	// 		System.out.println("Objet est présent");
	// 		return true;
	// 	}
	// 	else { 
	// 		System.out.println("Objet n'a pas été crée");
	// 		return false;
	// 	}
	// }
	/*
		*Vérifie si une attaque est possible 
		*/
	// public boolean Atteignable(int x_depart, int y_depart, int x_final, int y_final) {
	public boolean Atteignable(Hexagone depart, Hexagone arrive) {
		int x_distance;
		int y_distance;
		// x_distance = Math.abs(x_depart-x_final);
		// y_distance = Math.abs(y_depart-y_final);
		x_distance = Math.abs(arrive.j_hexa - depart.j_hexa);
		y_distance = Math.abs(arrive.i_hexa - depart.i_hexa);
		if( (x_distance == 0 || x_distance == 1) && (y_distance == 1 || y_distance == 2) ){
			return true;
		}
		else {return false;}
	}
	
		//Attaque une unité adverses ou se deplace
		// pour faire une attaque t.etat !=0
	
	// public int Attaque(Terrains t, Unite unite) {
	public void Attaque(Hexagone depart, Hexagone arrive) {
		// int Cx_unite = 0 , Cy_unite = 0; // coordonnée adversaire
		// if(Atteignable(unite.X, unite.Y, Cx_unite, Cy_unite) ) {	//&& t.etat !=0) {
		// if(Atteignable(depart, arrive)) {	//&& t.etat !=0) {
			// this.Degat_Brut = this.Point_Attaque - ( unite.Point_Defense + (unite.Point_Defense*t.getBonus_Defense()/100)+1 );
			// int min = -this.Degat_Brut/2;
			// int max = this.Degat_Brut/2;
			// this.Degat = this.Degat_Brut + (nombre_aleatoire);
			depart.unite.setDegat_Brut(depart.unite.getPoint_Attaque() - ( arrive.unite.getPoint_Defense() + (arrive.unite.getPoint_Defense() * arrive.getBonus_defense() / 100 ) + 1 ));
			int min = - depart.unite.getDegat_Brut() / 2;
			int max = depart.unite.getDegat_Brut() / 2;
			int range = max - min + 1;
			int nombre_aleatoire = (int) (Math.random() * range ) + min;
				
			depart.unite.setDegat(depart.unite.getDegat_Brut() + (nombre_aleatoire));
			// System.out.println(this.Nom + " a attaqué " + unite.Nom + " et lui causé " + (this.Degat) + " Points");	
		// }
		// else { 
		// 	System.out.println("Vous ne pouvez pas attaquer" );
		// 	// Se_Deplace(t, unite, unite.X, unite.Y, Cx_unite, Cy_unite);
		// 	// Se_Deplace(t, unite, unite.X, unite.Y, Cx_unite, Cy_unite);
		// }
		// return this.Degat;
	}
	

	public void Niveau_Vie(int degat) {
		if(degat >= 0) {
			// this.Point_vie_restant = this.Point_Vie - degat;
			// System.out.println("Il vous reste " + this.Point_vie_restant + " Points de vie");
			this.setPoint_vie_restant(this.getPoint_vie_restant() - degat);
			System.out.println("Il vous reste " + this.getPoint_vie_restant() + " Points de vie");
		}
		else {
			// this.Point_vie_restant = this.Point_Vie + degat;
			// System.out.println("Il vous reste " + this.Point_vie_restant + " Points de vie");
			this.setPoint_vie_restant(this.getPoint_vie_restant() + degat);
			System.out.println("Il vous reste " + this.getPoint_vie_restant() + " Points de vie");
		}
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
