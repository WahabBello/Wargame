package vue;

import java.awt.Color;

//Classe fille de la classe parent hexagone reprensentant un type d'hexagone

public class Village extends Hexagone  {

	public Village(int x[], int y[]) {
		super("Village", 1, 40, Color.lightGray,  x, y);
	}
	
}
