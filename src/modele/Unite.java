package modele;

import java.awt.Polygon;
import java.awt.TexturePaint;

import vue.Hexagone;

//Classe parent de chaque unité
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

	// Verifier la vision de deplacement d'une unité
	public Boolean vision_v(Hexagone depart, Hexagone arrive) {
		/* distance entre le x final et le x de départ sera comparé à la vision d'une
		 * unité si x_initial = x_final alors on modifie le y sinon (y_initiaal =
		 * y_final) on modifie le x		 */

		int Distance_X, Distance_Y;
		Distance_X = arrive.j_hexa - depart.j_hexa;
		Distance_Y = arrive.i_hexa - depart.i_hexa;
		if (Distance_X <= depart.unite.getVision() && Distance_Y <= depart.unite.getVision()) {
			return true;
		} else {
			return false;
		}
	}

	// Faire deplacer une unité
	public void se_deplace(Hexagone depart, Hexagone arrive) {
		arrive.unite = depart.unite;
		arrive.unite.setPoint_Deplacement_Restant(
				arrive.unite.getPoint_Deplacement_Restant() - arrive.getPoint_deplacements());
	}

	
	//  Vérifie si une attaque est possible

	public boolean Atteignable(Hexagone depart, Hexagone arrive) {
		int x_distance;
		int y_distance;
		x_distance = Math.abs(arrive.j_hexa - depart.j_hexa);
		y_distance = Math.abs(arrive.i_hexa - depart.i_hexa);
		if ((x_distance == 0 || x_distance == 1  || x_distance == 2) && (y_distance == 1 || y_distance == 2 || y_distance == 3)) {
			return true;
		} else {
			return false;
		}
	}

	// Attaquer une unité adverse
	public void Attaque(Hexagone depart, Hexagone arrive) {

		depart.unite.setDegat_Brut(depart.unite.getPoint_Attaque() - (arrive.unite.getPoint_Defense()
				+ (arrive.unite.getPoint_Defense() * arrive.getBonus_defense() / 100) + 1));
		int min = -depart.unite.getDegat_Brut() / 2;
		int max = depart.unite.getDegat_Brut() / 2;
		int range = max - min + 1;
		int nombre_aleatoire = (int) (Math.random() * range) + min;
		depart.unite.setDegat(depart.unite.getDegat_Brut() + (nombre_aleatoire));

	}

	public void Niveau_Vie(Hexagone arrive, int degat) {
		if (degat >= 0) {
			arrive.unite.setPoint_vie_restant(arrive.unite.getPoint_vie_restant() - degat);
		} else {
			this.setPoint_vie_restant(this.getPoint_vie_restant() + degat);
		}
	}

	// Regenerer une unité
	public void Recuperer(Hexagone hexa) {
		int regenere = ((10 * hexa.unite.getPoint_Vie() / 100) + 1);

		hexa.unite.setPoint_vie_restant(hexa.unite.getPoint_vie_restant() + regenere);
		System.out.println(hexa.unite.getNom() + " s'est regenerée de " + regenere + " Points");
		System.out.println("Points de vie :  " + hexa.unite.getPoint_vie_restant());

	}

	// Methode abstraire contenant l'image de chaque hexagone.
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

	public int getDegat() {
		return Degat;
	}

	public void setDegat(int degat) {
		Degat = degat;
	}

}
