package vue;

import javax.swing.JFrame;

// Classe principale du plateau de jeu à excuter pour l'affichage du graphisme 

public class Plateau {
	
	boolean etat;
	int size;	
	Hexagone carte;
	
	public Plateau() {
        initUI();
    }

    private void initUI() {

        int x_init[] = { 0, 20, 50, 70, 50, 20 };
        int y_init[] = { 30, 0, 0, 30, 60, 60 };
        int x_init_2[] = { 50, 70, 100, 120, 100, 70 };
        int y_init_2[] = { 60, 30, 30, 60, 90, 90 };

     
        carte = new Foret(x_init, y_init, x_init_2, y_init_2);
        JFrame frame = new JFrame("Polygon Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(carte);
        carte.addMouseListener(new MouseListen(carte));
        frame.setSize(860, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);    
        
    }

    public static void main(String[] args) {

    	new Plateau();

    }
	 
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
}
