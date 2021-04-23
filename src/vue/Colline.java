package vue;

import java.awt.Color;

//Classe fille de la classe parent hexagone reprensentant un type d'hexagone

public class Colline extends Hexagone {

	private static final long serialVersionUID = 1L;

	public Colline(int x[], int y[], int x2[], int y2[]) {
		super("Colline", 2, 50, Color.RED, x, y, x2, y2);
		// TODO Auto-generated constructor stub
	}

}
