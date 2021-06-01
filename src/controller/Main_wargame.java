package controller;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modele.Humain;
import modele.Ordinateur;
import vue.Graphisme;

public class Main_wargame {

	public Main_wargame() { 
		
	}
	
	/*  Fichier principale pour executer l'application et afficher la graphisme  */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graphisme frame = new Graphisme();

					String nombre_joueurs;

					// while (nombre_joueurs.getType() = ) {
					nombre_joueurs = JOptionPane.showInputDialog(frame,"Entrez le nombre de joueurs entre 1 et 4:");
					for (int i = 0; i < Integer.parseInt(nombre_joueurs); i++) {
						String nom = JOptionPane.showInputDialog(frame,"Entrez le nom du joueur "+ (i+1) +" :");
						new Humain(nom);
					}	
					// }
					frame.selection_player();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setSize(1000, 600);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
					JOptionPane.showMessageDialog(frame,"Bienvenue au Wargame!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
	
}
