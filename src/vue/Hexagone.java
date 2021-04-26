package vue;

import java.awt.Color;

import java.awt.Polygon;



//Classe parent de chaque hexagone 

public abstract class Hexagone {


	private String type_hexa ;
	private int point_deplacements;
	private int bonus_defense;
	private Color couleur;
	private int[] x_coord;
	private int[] y_coord;
	private Polygon dessin_hexa;


	public Hexagone(String type_hexa, int point_deplacements, int bonus_defense, Color couleur, int x[], int y[]){
		this.setType_hexa(type_hexa);
		this.setPoint_deplacements(point_deplacements);
		this.setBonus_defense(bonus_defense);
		this.setCouleur(couleur);
		this.setDessin_hexa(x,y);
	}  

	public int getBonus_defense() {
		return bonus_defense;
	}

	public void setBonus_defense(int bonus_defense) {
		this.bonus_defense = bonus_defense;
	}

	public String getType_hexa() {
		return type_hexa;
	}

	public void setType_hexa(String type_hexa) {
		this.type_hexa = type_hexa;
	}

	public int getPoint_deplacements() {
		return point_deplacements;
	}

	public void setPoint_deplacements(int point_deplacements) {
		this.point_deplacements = point_deplacements;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public Polygon getDessin_hexa() {
		return dessin_hexa;
	}

	public void setDessin_hexa(int x[], int y[]) {
		this.setX_coord(x);
		this.setY_coord(y);
		this.dessin_hexa = new Polygon(x, y, 6);
	}

	public int[] getX_coord() {
		return x_coord;
	}

	public void setX_coord(int[] x_coord) {
		this.x_coord = x_coord;
	}

	public int[] getY_coord() {
		return y_coord;
	}

	public void setY_coord(int[] y_coord) {
		this.y_coord = y_coord;
	}
}
