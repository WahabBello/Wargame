package modele;

import vue.Hexagone;

import java.awt.Polygon;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class Mage extends Unite {
	// private Image image;
	// private int width;
	// private int height;

	public Mage() {
		super("Mage", 5, 1, 5, 5, 24);
		
		// ImageIcon i = new ImageIcon("src/Image/Mage.png");
		// this.image = i.getImage();
		// this.width = image.getWidth(null);
		// this.height = image.getHeight(null);
		//this.loadImages();
	}

	
	public void Niveau_Vie(int degat) {
		if(degat >=0) {
			super.setPoint_vie_restant(super.getPoint_Vie() - degat);
			System.out.println("Il vous reste " + super.getPoint_vie_restant() + " Points de vie");
		}
		else {
			super.setPoint_vie_restant(super.getPoint_Vie() + degat);
			System.out.println("Il vous reste " + super.getPoint_vie_restant() + " Points de vie");
		}
	}

	public TexturePaint loadImages(Polygon dimension) {
        try {
        	BufferedImage slate  =  ImageIO.read(getClass().getResource("/Mage.png"));
            super.image_unite  = new TexturePaint(slate, dimension.getBounds());
        } catch (IOException ex) {
            Logger.getLogger(Hexagone.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return super.image_unite;
    }
	
}
