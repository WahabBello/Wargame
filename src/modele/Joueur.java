package modele;

import java.util.ArrayList;

public class Joueur {
	
	private String Nom;
	private int Numero;
	private ArrayList<Unite> liste_unite = new ArrayList();
	private int nb_unite = 10; 
	
	
	public Joueur(String nom, int numero) {
	this.Nom = nom;
	this.Numero = numero;
	}
	
	public String getNom() {
		return Nom;
	}
	
	public int getNumero() {
		return Numero;
	}
	
	public ArrayList<Unite> getListe_unite() {
		return liste_unite;
	}
	
	public int getNb_unite() {
		return nb_unite;
	}
	
	public void Ajouter_Unite(Unite unite) {
		this.liste_unite.add(unite);
		this.nb_unite--;
	}
}
