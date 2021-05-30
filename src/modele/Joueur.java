package modele;

import java.awt.Color;
import java.util.ArrayList;

//Classe parent de tous les Joueurs

public abstract class Joueur {
	
	private String username;
	private Color color;
	private int numero_joueur;
	static int numero;
	private static ArrayList<Joueur> liste_joueurs = new ArrayList<Joueur>();
	private ArrayList<Unite> liste_unite = new ArrayList<Unite>();
	public int nb_unite = 10; 
	
//	public Joueur(String nom) {
//
//	}
	
	public Joueur(String nom) {
		this.setUsername(nom);
		numero++;
		this.setNumero_joueur(numero++);
		this.add_joueur(this);
	}

	public void add_joueur(Joueur element) {	
		liste_joueurs.add((Joueur)element);
	}
	
	public static ArrayList<Joueur> getListe_joueurs() {
		return liste_joueurs;
	}
	
	public ArrayList<Unite> getListe_unite() {
		return liste_unite;
	}
	
	public void ajouter_Unite(Unite unite) {
		if (this.nb_unite != 0) {
			this.liste_unite.add(unite);
			this.nb_unite--;			
		} 
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getNumero_joueur() {
		return numero_joueur;
	}

	public void setNumero_joueur(int numero_joueur) {
		this.numero_joueur = numero_joueur;
	}
}
