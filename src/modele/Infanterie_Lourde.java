package modele;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Infanterie_Lourde extends Unite {
	private Image image;
	private int height;
	private int width;

	public Infanterie_Lourde(String nom, int pA, int pD, int pDepl, int vision, int pv) {
		super("Infanterie Lourde", 10, 10, 4, 4, 38);
		
		ImageIcon i = new ImageIcon("src/Image/Infanterie_Lourde.png");
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
