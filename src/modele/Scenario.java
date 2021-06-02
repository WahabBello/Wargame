package sauvegarde;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Scenario{
	protected Plateau plateau;
	protected int nbMaxJoueurs;
	protected int nbMaxTours;
	
	public Scenario() {
		this.plateau = new Plateau();
		this.nbMaxJoueurs = 2;
		this.nbMaxTours = 20;
    }
    
    public void parametrer(char[][] tableau, int nbMaxJ, int nbMaxT){
		int i = 0;
		int j = 0;
		for (i = 0; i < 24; i++){
			for (j = 0; j < 24; j++){
				if (tableau[i][j] == 'C'){
					this.plateau.tri_1[i][j] = new Colline(this.plateau.x_init, this.plateau.y_init);
            		this.tri_2[x][y] =  new Colline(this.plateau.x_init_2, this.plateau.y_init_2);
				}
				else if (tableau[i][j] == 'V'){
					this.plateau.tri_1[i][j] = new Village(this.plateau.x_init, this.plateau.y_init);
            		this.plateau.tri_2[x][y] =  new Village(this.plateau.x_init_2, this.plateau.y_init_2);
				}
				else if (tableau[i][j] == 'M'){
					this.plateau.tri_1[i][j] = new Montagne(this.plateau.x_init, this.plateau.y_init);
            		this.plateau.tri_2[x][y] =  new Montagne(this.plateau.x_init_2, this.plateau.y_init_2);
				}
				else if (tableau[i][j] == 'P'){
					this.plateau.tri_1[i][j] = new Plaine(this.plateau.x_init, this.plateau.y_init);
            		this.plateau.tri_2[x][y] =  new Plaine(this.plateau.x_init_2, this.plateau.y_init_2);
				}
				else if (tableau[i][j] == 'F'){
					this.plateau.tri_1[i][j] = new Foret(this.plateau.x_init, this.plateau.y_init);
            		this.plateau.tri_2[x][y] =  new Foret(this.plateau.x_init_2, this.plateau.y_init_2);
				}
			}
		}
		this.nbMaxJoueurs = nbMaxJ;
		this.nbMaxTours = nbMaxT;
	}
	
	public void parametrer_depuis_fichier(String nom){
		int i = 0;
		int j = 0;
		String p = "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
		String nbMJ = "2";
		String nbMT = "12";
		try {
			File fichier = new File(nom);
			Scanner lecteur = new Scanner(fichier);
			p = lecteur.nextLine();
			nbMJ = lecteur.nextLine();
			nbMT = lecteur.nextLine();
			lecteur.close();
	    }
	    catch (FileNotFoundException e)
	    {
			System.out.println("Erreur lors de la lecture");
			e.printStackTrace();
	    }
	    char[][] tableau = new char[24][24];
		int nbMaxJ = Integer.valueOf(nbMJ);
		int nbMaxT = Integer.valueOf(nbMT);
	    for (i = 0; i < 24; i++){
			for (j = 0; j < 24; j++){
				tableau[i][j] = p.charAt(24*1 + j);
			}
		}
	    parametrer(tableau, nbMaxJ, nbMaxT)
	}
	/*
	public void lecture_sauvegarde(String nom)
	{
		int i = 0;
		int j = 0;
		String p = "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
		String nbMJ = "2";
		String nbMT = "12";
		ArrayList<String> nomJoueurs = new ArrayList<String>();
		ArrayList<Integer> unites = new ArrayList<Integer>();
		try {
			File fichier = new File(nom);
			Scanner lecteur = new Scanner(fichier);
			p = lecteur.nextLine();
			nbMJ = lecteur.nextLine();
			nbMT = lecteur.nextLine();
			for (i = 0; i < nbMJ; i++)
		    {
				nomJoueurs.add(lecteur.nextLine());
				for (j = 0; j < 5; j++){
					//type
					unites.add(lecteur.nextLine());
					//position x
					unites.add(lecteur.nextLine());
					//position x
					unites.add(lecteur.nextLine());
					//vie
					unites.add(lecteur.nextLine());
				}
			}
			lecteur.close();
	    }
	    catch (FileNotFoundException e)
	    {
			System.out.println("Erreur lors de la lecture");
			e.printStackTrace();
	    }
	    char[][] tableau = new char[9][9];
		int nbMaxJ = Integer.valueOf(nbMJ);
		int nbMaxT = Integer.valueOf(nbMT);
	    for (i = 0; i < 9; i++)
	    {
			for (j = 0; j < 9; j++){
				tableau[i][j] = p.charAt(9*1 + j);
			}
		}
	    
	    
	}
	*/
}
