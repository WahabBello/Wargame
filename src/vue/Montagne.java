package vue;

import java.awt.Color;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

//Classe fille de la classe parent hexagone reprensentant un type d'hexagone

public class Montagne extends Hexagone {

	public Montagne(int x[], int y[]) {
		super("Montagne", 3, 60, Color.ORANGE, x, y);
		this.loadImages();
	}
    private void loadImages() {

        try {
        	BufferedImage slate  = ImageIO.read(new File("C:\\\\Users\\\\DELL\\\\Documents\\\\Isty\\\\POO\\\\Java\\\\workspace\\\\Wargame\\\\images\\\\Mage.png"));
//        	this.slate = ImageIO.read(new File("C:\\Users\\DELL\\Documents\\Isty\\POO\\Java\\workspace\\Wargame\\images\\Cavalerie.png"));
            super.slatetp  = new TexturePaint(slate, this.getDessin_hexa().getBounds());
        } catch (IOException ex) {

            Logger.getLogger(Hexagone.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }
}
