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

public class Cavalerie extends Unite {

	public Cavalerie() {
		super("Cavalerie", 8, 3, 8, 6, 38);
	}
	
	public void Niveau_Vie(int degat) {
		if(degat >=0) {
			this.Point_vie_restant = this.Point_Vie - degat;
			System.out.println("Il vous reste " + this.Point_vie_restant + " Points de vie");
		}
		else {
			this.Point_vie_restant = this.Point_Vie + degat;
			System.out.println("Il vous reste " + this.Point_vie_restant + " Points de vie");
		}
	}

	public TexturePaint loadImages(Polygon dimension) {
        try {
        	BufferedImage slate  = ImageIO.read(new File("C:\\\\Users\\\\DELL\\\\Documents\\\\Isty\\\\POO\\\\Java\\\\workspace\\\\Wargame\\\\images\\\\Cavalerie.png"));
            super.image_unite  = new TexturePaint(slate, dimension.getBounds());
        } catch (IOException ex) {
            Logger.getLogger(Hexagone.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return super.image_unite;
    }
	
}
