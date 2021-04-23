package vue;

import java.awt.Color;

//Classe fille de la classe parent hexagone reprensentant un type d'hexagone

public class Foret extends Hexagone {

	private static final long serialVersionUID = 1L;

	public Foret(int x[], int y[], int x2[], int y2[]) {
		super("Foret", 2, 40, Color.GREEN, x, y, x2, y2);
		// TODO Auto-generated constructor stub
	}

}
