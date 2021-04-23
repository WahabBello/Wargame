package vue;

//import java.awt.*;
//import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.util.logging.*;

//Classe parent de chaque hexagone 


public abstract class Hexagone extends JComponent {

	private static final long serialVersionUID = 1L;

	private String type_hexa ;
	private int point_deplacements;
	private int bonus_defense;
	private Color couleur;
	private BufferedImage slate;
	public int row = -1;
	public int col = -1;
	public boolean tri_hexa;
	public Polygon[][] tri_1 = new Polygon[9][9];
	public Polygon[][] tri_2 = new Polygon[9][9];

	public Hexagone(String type_hexa, int point_deplacements, int bonus_defense, Color couleur, int x[], int y[], int x2[], int y2[]){
		this.setType_hexa(type_hexa);
		this.setPoint_deplacements(point_deplacements);
		this.setBonus_defense(bonus_defense);
		this.setCouleur(couleur);
		init(x,y,x2,y2);
		loadImages();
	}
    

	private void init(int[] x_init, int[] y_init, int[] x_init_2, int[] y_init_2 ) {
        for (int x = 0; x < tri_1.length; x++) {
            for (int y = 0; y <  tri_1.length; y++) {

                this.tri_1[x][y] = new Polygon(x_init, y_init, 6);
                this.tri_2[x][y] = new Polygon(x_init_2, y_init_2, 6);
                
                for (int j = 0; j < x_init.length; j++) {
                    x_init[j] += 100;
                    x_init_2[j] += 100;
                }
            }
            x_init[0] = 0;
            x_init[1] = 20;
            x_init[2] = 50;
            x_init[3] = 70;
            x_init[4] = 50;
            x_init[5] = 20;
            x_init_2[0] = 50;
            x_init_2[1] = 70;
            x_init_2[2] = 100;
            x_init_2[3] = 120;
            x_init_2[4] = 100;
            x_init_2[5] = 70;
            for (int j_x = 0; j_x < y_init.length; j_x++) {
                y_init[j_x] += 60;
                y_init_2[j_x] += 60;
            }
        }
	}
    private void loadImages() {

        try {

            this.slate = ImageIO.read(new File("images/foret.jpg"));

        } catch (IOException ex) {

            Logger.getLogger(Hexagone.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        TexturePaint slatetp = new TexturePaint(this.slate, new Rectangle(0, 0, 90, 60));
        g2d.setPaint(slatetp);
        g2d.fillRect(0, 0, 860, 600);
        
         for (int x = 0; x < this.tri_1.length; x++) {
             for (int y = 0; y <  this.tri_1.length; y++) {
                 g2d.setColor(Color.RED);
                 g2d.drawPolygon(this.tri_1[x][y]);

                 g2d.setColor(Color.RED);
                 g2d.drawPolygon(this.tri_2[x][y]);
             }
             if (row != -1)
             {          	
                if (this.tri_hexa) {
                   g2d.setColor(Color.RED);
                   g2d.fillPolygon(this.tri_1[row][col]);            		
                }else {
                   g2d.setColor(Color.RED);
                   g2d.fillPolygon(this.tri_2[row][col]);
                }
             }
         }
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

	
}
