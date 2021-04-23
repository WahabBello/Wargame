package vue;

import java.awt.Color;

//Classe fille de la classe parent hexagone reprensentant un type d'hexagone

public class Village extends Hexagone {

	private static final long serialVersionUID = 1L;

	public Village(int x[], int y[], int x2[], int y2[]) {
		super("Village", 1, 40, Color.lightGray,  x, y, x2, y2);
		// TODO Auto-generated constructor stub
	}

}
