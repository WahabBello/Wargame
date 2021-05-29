package vue;

import java.awt.Color;
import java.awt.TexturePaint;


//Classe fille de la classe parent hexagone reprensentant un type d'hexagone

public class Colline extends Hexagone {

	public Colline(int x[], int y[]) {
		super("Colline", 2, 50, Color.RED, x, y);
	}

}
