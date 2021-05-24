package vue;

import java.awt.Color;

import java.awt.Polygon;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import unite.Unite;



//Classe parent de chaque hexagone 

public abstract class Hexagone {

	private String type_hexa ;
	private int point_deplacements;
	private int bonus_defense;
	private Color couleur;
	private int[] x_coord;
	private int[] y_coord;
	private Polygon dessin_hexa;
	public Unite unite;
	public int i_hexa;
	public int j_hexa;
	private int etat;
//	public BufferedImage slate;
	public TexturePaint slatetp;
//	public slate = ImageIO.read(new File("slate.png"));

	public Hexagone(String type_hexa, int point_deplacements, int bonus_defense, Color couleur, int x[], int y[]){
		this.setType_hexa(type_hexa);
		this.setPoint_deplacements(point_deplacements);
		this.setBonus_defense(bonus_defense);
		this.setCouleur(couleur);
		this.setDessin_hexa(x,y);
		this.loadImages();
		this.setEtat(0);
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

    private void loadImages() {
//	   BufferedImage img = ImageIO.read(new File("test.png"));
//	   JLabel pic = new JLabel(new ImageIcon(img));
        try {
//        	url = getClass().getResource("../../images/Cavalerie.png");
//        	BufferedImage slate  = ImageIO.read(new File(url));
        	BufferedImage slate  = ImageIO.read(new File("C:\\\\Users\\\\DELL\\\\Documents\\\\Isty\\\\POO\\\\Java\\\\workspace\\\\Wargame\\\\images\\\\Cavalerie.png"));
//        	this.slate = ImageIO.read(new File("C:\\Users\\DELL\\Documents\\Isty\\POO\\Java\\workspace\\Wargame\\images\\Cavalerie.png"));
            this.slatetp  = new TexturePaint(slate, this.getDessin_hexa().getBounds());
        } catch (IOException ex) {

            Logger.getLogger(Hexagone.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
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

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
}
