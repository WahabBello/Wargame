package vue;

import java.awt.Color;

//Classe fille de la classe parent hexagone reprensentant un type d'hexagone

public class Plaine extends Hexagone {

	public Plaine (int x[], int y[]) {
		super("Plaine", 1, 20, Color.CYAN, x, y);
	}
	
}
