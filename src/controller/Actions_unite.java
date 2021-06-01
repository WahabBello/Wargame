package controller;

import vue.Dessin_polygone;
import vue.Hexagone;

import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import modele.Archer;
import modele.Cavalerie;
import modele.Infanterie;
import modele.Infanterie_Lourde;
import modele.Joueur;
import modele.Mage;
import modele.Unite;

public class Actions_unite {

	public Dessin_polygone plateau;
	public Hexagone hexa_selected;
	public Hexagone hexa_selected2;
	// public Boolean mode_deplacer = false;
	
	public Actions_unite(Dessin_polygone plateau) {
		this.plateau = plateau;
	}

    public void selection(MouseEvent e, Boolean mode_deplacer, Boolean mode_attaquer, Hexagone hexa_choisi, Joueur player_actif, Dessin_polygone dessin_poly) {
        int x = e.getX();
        int y = e.getY();
        this.plateau.row = this.plateau.col = -1;
        
        for (int i = 0; i < this.plateau.plateau_hexas.length; i++)
            for (int j = 0; j <  this.plateau.plateau_hexas.length; j++)
                	if ( this.plateau.plateau_hexas[i][j].getDessin_hexa().contains(x, y)) {
                		if (mode_deplacer && hexa_choisi != null){
							this.plateau.row = i;
							this.plateau.col = j;	
							this.plateau.tri_hexa= true;
							deplacer(hexa_choisi, player_actif, dessin_poly, this.plateau.plateau_hexas[i][j]);

						}else if(mode_attaquer && hexa_choisi != null) {
							this.plateau.row = i;
							this.plateau.col = j;	
							this.plateau.tri_hexa= true;
							// System.out.println(player_actif.getNumero_joueur() + "<- Numero player et etat hexa ->" + hexa_choisi.getEtat());
							attaquer(hexa_choisi, player_actif, dessin_poly, this.plateau.plateau_hexas[i][j]);
							System.out.println(hexa_choisi.unite.getDegat_Brut() + "<- Degat brut ");

						}else {
							this.plateau.row = i;
							this.plateau.col = j;
							this.plateau.tri_hexa= true;
							this.hexa_selected = this.plateau.plateau_hexas[i][j];
						}
//						System.out.println(this.hexa_selected.i_hexa+"<-i et j->"+this.hexa_selected.j_hexa);
                	}
		
        this.plateau.repaint();
    }

    // Methode private pour verifier les conditions d'attaque et effectuer l'effectuer si possible
	private void attaquer(Hexagone hexa_choisi, Joueur player_actif, Dessin_polygone dessin_poly, Hexagone plateau_hexas) {

		if(hexa_choisi.getEtat() != 0 && plateau_hexas.getEtat() != 0){
			if (hexa_choisi.unite.getPoint_vie_restant() >= 0 && (plateau_hexas.getEtat() != player_actif.getNumero_joueur())){
			// if (hexa_choisi.getEtat() != player_actif.getNumero_joueur()){
				// if (hexa_choisi.unite.vision_v(hexa_choisi, plateau_hexas)){
				if (hexa_choisi.unite.Atteignable(hexa_choisi, plateau_hexas)){
					hexa_choisi.unite.Attaque(hexa_choisi, plateau_hexas);
					System.out.println("hexa depart : degat causé =" + hexa_choisi.unite.getDegat());
					
					plateau_hexas.unite.Niveau_Vie(plateau_hexas,hexa_choisi.unite.getDegat());
					// hexa_choisi.unite.Attaque(hexa_choisi, plateau_hexas);
					System.out.println("hexa arrive : Point de vie =" + plateau_hexas.unite.getPoint_vie_restant());

					if(plateau_hexas.unite.getPoint_vie_restant() <= 0){
						plateau_hexas.unite = null;
						plateau_hexas.setEtat(0);
					}
					// plateau_hexas.unite = hexa_choisi.unite;
					// plateau_hexas.setEtat(player_actif.getNumero_joueur());
					// hexa_choisi.unite = null;
					// hexa_choisi.setEtat(0);

				}else {
					JOptionPane.showMessageDialog(dessin_poly, "Vous n'etes pas assez proche pour attaquer");
				}
			}else {
				JOptionPane.showMessageDialog(dessin_poly, "On ne peut pas attaquer sa propre unité");
			}
		}else {
			JOptionPane.showMessageDialog(dessin_poly, "Selectionner une unite a attaquer");
		}
	
	}
    // Methode private pour verifier les conditions de deplacement et effectuer l'effectuer si possible
	private void deplacer(Hexagone hexa_choisi, Joueur player_actif, Dessin_polygone dessin_poly, Hexagone plateau_hexas) {

		if (hexa_choisi.getEtat() != 0 && plateau_hexas.getEtat() == 0){
			if (hexa_choisi.unite.getPoint_Deplacement_Restant() >= 0 && (hexa_choisi.unite.getPoint_Deplacement_Restant() >= plateau_hexas.getPoint_deplacements())) {
				if (hexa_choisi.unite.vision_v(hexa_choisi, plateau_hexas)){
					
					hexa_choisi.unite.se_deplace(hexa_choisi, plateau_hexas);
					System.out.println(plateau_hexas.unite.getPoint_Deplacement_Restant());
					plateau_hexas.setEtat(player_actif.getNumero_joueur());
					hexa_choisi.unite = null;
					hexa_choisi.setEtat(0);
					
				}else {
					JOptionPane.showMessageDialog(dessin_poly, "Vision non respecte");
				}
			}else {
				JOptionPane.showMessageDialog(dessin_poly, "Point de deplacement insuffisant");
			}
		}else {
			JOptionPane.showMessageDialog(dessin_poly, "Selectionner une case vide pour le deplacement");
		}
	}



	public void ajouter_unite(String type_unite, Joueur player_actif, Hexagone hexa_selected) {
//  	"Infanterie", "Infanterie Lourde", "Cavalerie", "Mage", "Archer"
		Unite unite = null;
		switch(type_unite) {
		  case "Infanterie":
		    unite = new Infanterie();
		  	player_actif.ajouter_Unite(unite);
		    break;
		  case "Infanterie Lourde":
			unite = new Infanterie_Lourde();
			player_actif.ajouter_Unite(unite);
		    break;
		  case "Cavalerie":
			unite = new Cavalerie();
			player_actif.ajouter_Unite(unite);
		    break;
		  case "Mage":
			unite = new Mage();
			player_actif.ajouter_Unite(unite);
		    break;
		  case "Archer":
			unite = new Archer();
			player_actif.ajouter_Unite(unite);
		    break;
		  default:
			 System.out.println("Aucune unite ajouter");
		}
		hexa_selected.unite = unite;
		hexa_selected.setEtat(player_actif.getNumero_joueur());
		System.out.println(player_actif.getNumero_joueur() + "<- Numero player et etat hexa ->" + hexa_selected.getEtat());

		this.plateau.repaint();
	}

	// public void deplacer(Hexagone hexa_selected, Joueur player_actif, Boolean mode_deplacer) {
	// 	if(hexa_selected.unite == null){
	// 		System.out.println("Selectionner une unite");
	// 		// JOptionPane.showMessageDialog(dessin_poly,"Selectionner une unite");
	// 	}else{
	// 		System.out.println("Tu peux deplacer");
	// 		// JOptionPane.showMessageDialog(dessin_poly,"Selctionner une case vide pour le deplacement");
	// 	}
	// }
}
