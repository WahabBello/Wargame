package wargame_Unite;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Archer extends Unite {
	private Image image;
	private int height;
	private int width;

	public Archer(String nom, int pA, int pD, int pDepl, int vision, int pv) {
		super("Archer", 6, 2, 5, 7, 33);
		
		ImageIcon i = new ImageIcon("src/Image/Archer.png");
		this.image = i.getImage();
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
	}

	public void Niveau_Vie(int degat) {
		if(degat >=0) {
			this.Point_vie_restant = this.Point_Vie - degat;
			System.out.println("Il vous reste " + this.Point_vie_restant + " Points de vie");
		}
		else {
			this.Point_vie_restant = this.Point_Vie + degat;
			System.out.println("Il vous reste " + this.Point_vie_restant + " Points de vie");
		}
	}
}
