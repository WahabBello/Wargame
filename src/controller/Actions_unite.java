package controller;

import vue.Dessin_polygone;
import vue.Hexagone;

import java.awt.event.MouseEvent;

public class Actions_unite {

	public Dessin_polygone plateau;
	public Hexagone hexa_selected;
	
	public Actions_unite(Dessin_polygone plateau) {
		this.plateau = plateau;
	}

    public void selection(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        this.plateau.row = this.plateau.col = -1;
        
        for (int i = 0; i < this.plateau.plateau_hexas.length; i++)
            for (int j = 0; j <  this.plateau.plateau_hexas.length; j++)
                	if ( this.plateau.plateau_hexas[i][j].getDessin_hexa().contains(x, y)) {
                		this.plateau.row = i;
                		this.plateau.col = j;
                		this.plateau.tri_hexa= true;
						this.hexa_selected = this.plateau.plateau_hexas[i][j];
//						System.out.println(this.hexa_selected.i_hexa+"<-i et j->"+this.hexa_selected.j_hexa);
                	}
        this.plateau.repaint();
    }
	
}
