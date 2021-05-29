package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.ImageIcon;
import javax.swing.JComponent;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JLabel;

// Initialisation des tableaux de polygone avec leurs differents couleurs

public class Dessin_polygone extends JComponent {

/**
	 * 
	 */
	private static final long serialVersionUID = 9218121229296185852L;
//    private static final long serialVersionUID = 1L;
    // public Hexagone[][] plateau_hexas;
    // public Hexagone[][] tri_2;
    public Hexagone[][] plateau_hexas;
    public int row;
    public int col;
    public boolean tri_hexa;
    public TexturePaint slate;
    
<<<<<<< HEAD
    public Dessin_polygone(Hexagone[][] tab_1, Hexagone[][] tab_2, int row, int col, boolean tri_hexa){
        this.tri_1 = tab_1;
        this.tri_2 = tab_2;
//     this.plateau_hexas = plateau;
=======
    public Dessin_polygone(Hexagone[][] tab, int row, int col, boolean tri_hexa){
        this.plateau_hexas = tab;
        // this.tri_2 = tab_2;
//        this.plateau_hexas = plateau;
>>>>>>> fb713b7692b24de2578133d30ee14a789d5197e8
        this.row = row;
        this.col = col;
        this.tri_hexa = tri_hexa;
        loadImages();
    }

    public void paint(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        

        g2d.setPaint(this.slate);
        g2d.fillRect(0, 0, 1250, 700);
        
        if (this.row != -1) {          	
            if (this.tri_hexa) {
               g2d.setColor(Color.WHITE);
               g2d.fillPolygon(this.plateau_hexas[this.row][this.col].getDessin_hexa());            		
            }

         }
         for (int x = 0; x < this.plateau_hexas.length; x++) {
             for (int y = 0; y <  this.plateau_hexas.length; y++) {
                 g2d.setColor(Color.WHITE);
                 g2d.drawPolygon(this.plateau_hexas[x][y].getDessin_hexa());                 
                 
                //  g2d.setColor(this.tri_2[x][y].getCouleur());
                //  g2d.drawPolygon(this.tri_2[x][y].getDessin_hexa());

                 if (x == 1 && y== 3) {
                     g2d.setPaint(this.plateau_hexas[x][y].slatetp);
                     g2d.fill(this.plateau_hexas[x][y].getDessin_hexa().getBounds());;               	 
                 }else if (x == 2 && y == 6) {
                     g2d.setPaint(this.plateau_hexas[x][y].slatetp);
                     g2d.fill(this.plateau_hexas[x][y].getDessin_hexa().getBounds());; 
                 }else if (x == 6 && y == 8) {
<<<<<<< HEAD
                     g2d.setPaint(this.tri_1[x][y].slatetp);
                     g2d.fill(this.tri_1[x][y].getDessin_hexa().getBounds());; 
                 }   
=======
                     g2d.setPaint(this.plateau_hexas[x][y].slatetp);
                     g2d.fill(this.plateau_hexas[x][y].getDessin_hexa().getBounds());; 
                 }
                 
>>>>>>> fb713b7692b24de2578133d30ee14a789d5197e8

             }

         }
    }
    
//    Image affiché derriere des polygones
    private void loadImages() {
         try {        	 
//        	BufferedImage slate  = ImageIO.read(new File("../../images/plateau.png"));
        	BufferedImage slate  = ImageIO.read(new File("C:\\\\Users\\\\DELL\\\\Documents\\\\Isty\\\\POO\\\\Java\\\\workspace\\\\Wargame\\\\images\\\\plateau.png"));
    
            this.slate  = new TexturePaint(slate, new Rectangle(0, 0, 1250, 700));
         } catch (IOException ex) {

             Logger.getLogger(Hexagone.class.getName()).log(
                     Level.SEVERE, null, ex);
         }
     }

}

