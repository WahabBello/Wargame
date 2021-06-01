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

    //Classe fille de chaque unité

public class Infanterie_Lourde extends Unite {

	public Infanterie_Lourde() {
		super("Infanterie Lourde", 10, 10, 4, 4, 38);		
	}

    
    // chargement de l'image
	public TexturePaint loadImages(Polygon dimension) {
        try {
        	BufferedImage slate = ImageIO.read(getClass().getResource("/Infanterie_Lourde.png"));
            super.image_unite  = new TexturePaint(slate, dimension.getBounds());
        } catch (IOException ex) {
            Logger.getLogger(Hexagone.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return super.image_unite;
    }
	
}
