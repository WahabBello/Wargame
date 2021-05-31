package controller;

import vue.Dessin_polygone;
import vue.Hexagone;

import java.awt.event.MouseEvent;

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

    public void selection(MouseEvent e, Boolean mode_deplacer, Hexagone hexa_choisi, Joueur player_actif) {
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
							if(hexa_choisi.getEtat() != 0){
								this.plateau.plateau_hexas[i][j].unite = hexa_choisi.unite;
								this.plateau.plateau_hexas[i][j].setEtat(player_actif.getNumero_joueur());
							}
							hexa_choisi.unite = null;
							hexa_choisi.setEtat(0);
						}else {
							this.plateau.row = i;
							this.plateau.col = j;
							this.plateau.tri_hexa= true;
							this.hexa_selected = this.plateau.plateau_hexas[i][j];
						}
//						System.out.println(this.hexa_selected.i_hexa+"<-i et j->"+this.hexa_selected.j_hexa);
                	}
		if (mode_deplacer){
			System.out.println("true");
		}else {
			System.out.println("false");
		}
        this.plateau.repaint();
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
		this.plateau.repaint();
	}
	
	public void deplacer(Hexagone hexa_selected, Joueur player_actif, Boolean mode_deplacer) {
		if(hexa_selected.unite == null){
			System.out.println("selectionner une unite");
		}else{
			System.out.println("tu peux deplacer");

		}
	}
}
