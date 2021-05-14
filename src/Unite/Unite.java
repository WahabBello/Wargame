package unite;

import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import vue.Hexagone;

// import java.util.Random;

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
//	public BufferedImage slate;
	public TexturePaint slatetp;
	
	
	public Unite(String nom) {
		this.Nom = nom;	
	}
	
		//Affiche nom de l'unité
	public void Nom_Unite() {
		System.out.println("Vous avez une unité de type : " + this.Nom);
	}
	
		//Faire deplacer une unité
	public int Se_Deplace(String terrain, int point) {
		System.out.println("Il vous faut " + point + " Points pour vous deplacer sur le terrain : " + terrain );
		this.Point_Deplacement_Restant = this.Point_Deplacement - point;
		return this.Point_Deplacement_Restant;	
	}
	
	//Recuperer le degat causé brut lors d'une attaque
	public int getDegat_Brut() {
		return Degat_Brut;
	}
	
		//Recuperer le degat causé net lors d'une attaque
	public int getDegat() {
		return Degat;
	}
	
		//Attaque une unité adverses
	public int Attaque(String terrain, int Bonus_Defense, Unite unite) {
		if(unite.Nom == unite.Nom) {
			this.Degat_Brut = this.Point_Attaque -( unite.Point_Defense + (unite.Point_Defense*Bonus_Defense/100)+1 );
		
			int min = -this.Degat_Brut/2;
			int max = this.Degat_Brut/2;
			int range = max-min + 1;
			int nombre_aleatoire = (int) (Math.random()*range ) + min;
			
			this.Degat = this.Degat_Brut + (nombre_aleatoire);
			System.out.println(this.Nom + " a attaqué " + unite.Nom + " et lui causé " + (this.Degat) + " Points");	
		}
		return this.Degat;
	}
	
		//regenerer une unité
	public void Recuperer(Unite unite) {
		int regenere = ( (10*unite.Point_Vie/100) +1);
		unite.Point_Vie = regenere  + unite.Point_vie_restant;
		System.out.println(unite.Nom + " s'est regenerée de " + regenere + " Points");
		System.out.println("Points de vie :  " + unite.Point_Vie);
			
	}
	
//    private void loadImages() {
//         try {
//         	BufferedImage slate  = ImageIO.read(new File("../../images/cavalerie.png"));
//            this.slatetp  = new TexturePaint(slate, this.getDessin_hexa().getBounds());
//         } catch (IOException ex) {
//
//             Logger.getLogger(Hexagone.class.getName()).log(
//                     Level.SEVERE, null, ex);
//         }
//     }
}
