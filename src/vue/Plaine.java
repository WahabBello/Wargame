package vue;

import java.awt.Color;

//Classe fille de la classe parent hexagone reprensentant un type d'hexagone

public class Plaine extends Hexagone {

	private static final long serialVersionUID = 1L;

	public Plaine (int x[], int y[], int x2[], int y2[]) {
		super("Plaine", 1, 20, Color.green, x, y, x2, y2);
	}
	
}
