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
import javax.swing.ImageIcon;
//import javax.swing.ImageIcon;
import javax.swing.JComponent;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.JLabel;

// Initialisation des tableaux de polygone avec leurs differents couleurs

class Dessin_polygone extends JComponent {

/**
	 * 
	 */
//	private static final long serialVersionUID = 9218121229296185852L;
//    private static final long serialVersionUID = 1L;
    public Hexagone[][] tri_1;
    public Hexagone[][] tri_2;
    public Hexagone[][] plateau_hexas;
    public int row;
    public int col;
    public boolean tri_hexa;
    public TexturePaint slate;
    
    public Dessin_polygone(Hexagone[][] tab_1, Hexagone[][] tab_2, int row, int col, boolean tri_hexa){
        this.tri_1 = tab_1;
        this.tri_2 = tab_2;
//     this.plateau_hexas = plateau;
        this.row = row;
        this.col = col;
        this.tri_hexa = tri_hexa;
        loadImages();
    }

    public void paint(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        

        g2d.setPaint(this.slate);
        g2d.fillRect(0, 0, 1200, 600);
        
         for (int x = 0; x < this.tri_1.length; x++) {
             for (int y = 0; y <  this.tri_1.length; y++) {
                 g2d.setColor(this.tri_1[x][y].getCouleur());
                 g2d.drawPolygon(this.tri_1[x][y].getDessin_hexa());
                 
                 
                 g2d.setColor(this.tri_2[x][y].getCouleur());
                 g2d.drawPolygon(this.tri_2[x][y].getDessin_hexa());

                 if (x == 1 && y== 3) {
                     g2d.setPaint(this.tri_1[x][y].slatetp);
                     g2d.fill(this.tri_1[x][y].getDessin_hexa().getBounds());;               	 
                 }else if (x == 2 && y == 6) {
                     g2d.setPaint(this.tri_1[x][y].slatetp);
                     g2d.fill(this.tri_1[x][y].getDessin_hexa().getBounds());; 
                 }else if (x == 6 && y == 8) {
                     g2d.setPaint(this.tri_1[x][y].slatetp);
                     g2d.fill(this.tri_1[x][y].getDessin_hexa().getBounds());; 
                 }   

             }
             if (this.row != -1)
             {          	
                if (this.tri_hexa) {
                //    g2d.setColor(this.tri_1[this.row][this.col].getCouleur());
                   g2d.setColor(Color.WHITE);
                   g2d.fillPolygon(this.tri_1[this.row][this.col].getDessin_hexa());            		
                }else {
                //    g2d.setColor(this.tri_2[this.row][this.col].getCouleur());
                   g2d.setColor(Color.WHITE);
                   g2d.fillPolygon(this.tri_2[this.row][this.col].getDessin_hexa());
                }
             }
         }
    }
    
    private void loadImages() {
         try {        	 
//        	BufferedImage slate  = ImageIO.read(new File("../../images/plateau.png"));
        	BufferedImage slate  = ImageIO.read(new File("C:\\\\Users\\\\DELL\\\\Documents\\\\Isty\\\\POO\\\\Java\\\\workspace\\\\Wargame\\\\images\\\\plateau.png"));
    
            this.slate  = new TexturePaint(slate, new Rectangle(0, 0, 1300, 700));
         } catch (IOException ex) {

             Logger.getLogger(Hexagone.class.getName()).log(
                     Level.SEVERE, null, ex);
         }
     }

}

