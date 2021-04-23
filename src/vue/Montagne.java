package vue;

import java.awt.Color;

//Classe fille de la classe parent hexagone reprensentant un type d'hexagone

public class Montagne extends Hexagone {

	private static final long serialVersionUID = 1L;

	public Montagne(int x[], int y[], int x2[], int y2[]) {
		super("Montagne", 3, 60, Color.black,  x, y, x2, y2);
		// TODO Auto-generated constructor stub
	}

}
