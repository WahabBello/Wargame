package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

import modele.Joueur;

// Initialisation des tableaux de polygone avec leurs differents couleurs
public class Dessin_polygone extends JComponent {

	private static final long serialVersionUID = 9218121229296185852L;
    public Hexagone[][] plateau_hexas;
    public int row;
    public int col;
    public boolean tri_hexa;
    public TexturePaint slate;
	// public Joueur player_actif;

    
    public Dessin_polygone(Hexagone[][] tab, int row, int col, boolean tri_hexa){
        this.plateau_hexas = tab;
        this.row = row;
        this.col = col;
        this.tri_hexa = tri_hexa;
        loadImages();
    }

    // Fonction d'affichage des hexagones du plateau 

    public void paint(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        

        g2d.setPaint(this.slate);
        g2d.fillRect(0, 0, 1250, 700);
        
        if (this.row != -1) {          	
            if (this.tri_hexa) {
                if(this.plateau_hexas[this.row][this.col].getEtat() != 0){
                    g2d.setColor(color_player(this.plateau_hexas[this.row][this.col].getEtat()));
                    g2d.fillPolygon(this.plateau_hexas[this.row][this.col].getDessin_hexa());            		
                }else{
                    g2d.setColor(Color.WHITE);
                    g2d.fillPolygon(this.plateau_hexas[this.row][this.col].getDessin_hexa());            		
                }
            }
         }

         for (int x = 0; x < this.plateau_hexas.length; x++) {
             for (int y = 0; y <  this.plateau_hexas.length; y++) {
                 g2d.setColor(this.plateau_hexas[x][y].getCouleur());
                 g2d.drawPolygon(this.plateau_hexas[x][y].getDessin_hexa());                 
                 
                 if (this.plateau_hexas[x][y].getEtat() != 0) {
                   g2d.setPaint(this.plateau_hexas[x][y].unite.loadImages(this.plateau_hexas[x][y].getDessin_hexa()));
                   g2d.fill(this.plateau_hexas[x][y].getDessin_hexa().getBounds());
                 }
             }
         }

    }
    
    private Color color_player(int numero){
		if (numero == 1){
			return Color.BLUE;
		}
		else if (numero == 2){
			return Color.RED;

		}
		else if (numero == 3){
			return Color.CYAN;
		}
		else{
			return Color.GREEN;
		}
	}

//  Image affichee derriere des polygones
    private void loadImages() {
         try {        	 
        	BufferedImage slate = ImageIO.read(getClass().getResource("/plateau.png"));
            this.slate  = new TexturePaint(slate, new Rectangle(0, 0, 1250, 700));
         } catch (IOException ex) {
             Logger.getLogger(Hexagone.class.getName()).log(
                     Level.SEVERE, null, ex);
         }
     }

}

