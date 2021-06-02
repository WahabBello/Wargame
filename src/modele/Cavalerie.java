package modele;

import vue.Hexagone;

import java.awt.Polygon;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

    //Classe fille de chaque unité
public class Cavalerie extends Unite {

	public Cavalerie() {
		super("Cavalerie", 8, 3, 8, 6, 38);
	}

    // Chargement de l'image 

	public TexturePaint loadImages(Polygon dimension) {
        try {
        	BufferedImage slate  = ImageIO.read(getClass().getResource("/Cavalerie.png"));
            super.image_unite  = new TexturePaint(slate, dimension.getBounds());
        } catch (IOException ex) {
            Logger.getLogger(Hexagone.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return super.image_unite;
    }
	
}
