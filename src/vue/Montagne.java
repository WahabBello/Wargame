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
	}
}
