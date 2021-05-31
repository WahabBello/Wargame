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


public class Infanterie extends Unite {
	
	public Infanterie() {
		super("Infanterie", 5, 3, 6, 4, 28);
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
        	BufferedImage slate  = ImageIO.read(new File("C:\\\\Users\\\\DELL\\\\Documents\\\\Isty\\\\POO\\\\Java\\\\workspace\\\\Wargame\\\\images\\\\Infanterie.png"));
            super.image_unite  = new TexturePaint(slate, dimension.getBounds());
        } catch (IOException ex) {
            Logger.getLogger(Hexagone.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return super.image_unite;
    }
	
}
