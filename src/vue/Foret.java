package vue;

import java.awt.Color;

//Classe fille de la classe parent hexagone reprensentant un type d'hexagone

public class Foret extends Hexagone {

	public Foret(int x[], int y[]) {
		super("Foret", 2, 40, Color.GREEN, x, y);
	}

}
