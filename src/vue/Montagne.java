package vue;

import java.awt.Color;

//Classe fille de la classe parent hexagone reprensentant un type d'hexagone

public class Montagne extends Hexagone {

	public Montagne(int x[], int y[]) {
		super("Montagne", 3, 60, Color.ORANGE, x, y);
	}

}
