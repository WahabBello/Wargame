package controller;

//import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.util.Arrays;

import vue.Dessin_polygone;
import vue.Hexagone;

public class MouseListen extends MouseAdapter {

	public Dessin_polygone plateau;
	private Hexagone hexa_selected;

	public MouseListen() {
	}
	
	public MouseListen(Dessin_polygone plateau) {
		this.plateau = plateau;
	}
    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        this.plateau.row = this.plateau.col = -1;
        
//       System.out.println(x+"<-x et y->"+y);
//       System.out.println("before tri_hexa = "+this.plateau.tri_hexa);
	   
        for (int i = 0; i < this.plateau.tri_1.length; i++)
            for (int j = 0; j <  this.plateau.tri_1.length; j++)
                if (this.plateau.tri_1[i][j].getDessin_hexa().contains(x, y) || this.plateau.tri_2[i][j].getDessin_hexa().contains(x, y)) {
                	if ( this.plateau.tri_2[i][j].getDessin_hexa().contains(x, y)) {
                		this.plateau.row = i;
                		this.plateau.col = j;
                		this.plateau.tri_hexa= false;
                		this.setHexa_selected(this.plateau.tri_2[i][j]);
                	}else {
                		this.plateau.row = i;
                		this.plateau.col = j;
                		this.plateau.tri_hexa= true;
                		this.setHexa_selected(this.plateau.tri_1[i][j]);
                	}
                	
//					System.out.println(i+"<-i et j->"+j);
					// System.out.println(i+"<-i et j->"+j);
//					System.out.println("coord = " + this.plateau.tri_2[i][j].getDessin_hexa().getBounds());
					// System.out.println("x et y= " + this.plateau.tri_2[i][j].getDessin_hexa().xpoints+ "et" + this.plateau.tri_2[i][j].getDessin_hexa().ypoints);
				 
//					System.out.println("coord = " + Arrays.toString(this.plateau.tri_2[i][j].getY_coord()));
                }
//        for (int i = 0; i < this.plateau.plateau_hexas.length ; i++) {
//        	for (int j = 0; j <  this.plateau.tri_1.length; j++) {
//        		if ( this.plateau.plateau_hexas[i][j].getDessin_hexa().contains(x, y)) {
//            		this.plateau.row = i;
//            		this.plateau.col = j;  
//            		this.setHexa_selected(this.plateau.plateau_hexas[i][j]);
//        		}
//        	}
//        }
//        System.out.println(this.getHexa_selected().i_hexa+"<-i et j->"+this.getHexa_selected().j_hexa);  
//        this.plateau.repaint();
//		System.out.println("------------------");

    }

	public Hexagone getHexa_selected() {
		return hexa_selected;
	}

	public void setHexa_selected(Hexagone hexa_selected) {
		this.hexa_selected = hexa_selected;
	}
}
