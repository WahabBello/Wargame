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

public class Archer extends Unite {


	public Archer() {
		super("Archer", 6, 2, 5, 7, 33);
	}

	public void Niveau_Vie(int degat) {
		if(degat >=0) {
			// this.Point_vie_restant = this.Point_Vie - degat;
			// System.out.println("Il vous reste " + this.Point_vie_restant + " Points de vie");
			super.setPoint_vie_restant(super.getPoint_Vie() - degat);
			System.out.println("Il vous reste " + super.getPoint_vie_restant() + " Points de vie");
		}
		else {
			// this.Point_vie_restant = this.Point_Vie + degat;
			// System.out.println("Il vous reste " + this.Point_vie_restant + " Points de vie");
			super.setPoint_vie_restant(super.getPoint_Vie() + degat);
			System.out.println("Il vous reste " + super.getPoint_vie_restant() + " Points de vie");
		}
	}

	public TexturePaint loadImages(Polygon dimension) {
        try {
        	BufferedImage slate  = ImageIO.read(getClass().getResource("/Archer.png"));
            super.image_unite  = new TexturePaint(slate, dimension.getBounds());
        } catch (IOException ex) {
            Logger.getLogger(Hexagone.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return super.image_unite;
    }

}
