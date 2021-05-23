package wargame_Unite;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Mage extends Unite {
	private Image image;
	private int width;
	private int height;

	public Mage(String nom, int pA, int pD, int pDepl, int vision, int pv) {
		super("Mage", 5, 1, 5, 5, 24);
		
		ImageIcon i = new ImageIcon("src/Image/Mage.png");
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
