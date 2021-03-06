package controller;

import vue.Colline;
//import vue.Dessin_polygone;
import vue.Foret;
import vue.Hexagone;
import vue.Montagne;
import vue.Plaine;
import vue.Village;

// Classe principale du plateau de jeu � excuter pour l'affichage du graphisme 
public class Plateau{

	int size;	
	public Hexagone[][] plateau_hexas = new Hexagone[24][24];
	public int row = -1;
	public int col = -1;
	public boolean tri_hexa;
    int x_init[] = { 0, 20, 50, 70, 50, 20 };
    int y_init[] = { 30, 0, 0, 30, 60, 60 };
    int x_init_2[] = { 50, 70, 100, 120, 100, 70 };
    int y_init_2[] = { 60, 30, 30, 60, 90, 90 };
	
	public Plateau() {
		initPolygone();
    }

    // Initialisation du tableau de hexagone avec leurs differents types d'hexagone et coordonées
    
    private void initPolygone() {
        for (int x = 0; x < this.plateau_hexas.length; x++) {
            for (int y = 0; y <  this.plateau_hexas.length; y++) {
                if(y%2 == 0){
                    choix_type_hexa(this.plateau_hexas, x, y, x_init, y_init);
				}
				else
				{
                    choix_type_hexa(this.plateau_hexas, x, y, x_init, y_init_2);
				}

                for (int j = 0; j < x_init.length; j++) {
                    x_init[j] += 50;
                }
            }
            x_init[0] = 0;
            x_init[1] = 20;
            x_init[2] = 50;
            x_init[3] = 70;
            x_init[4] = 50;
            x_init[5] = 20;
            x_init_2[0] = 50;
            x_init_2[1] = 70;
            x_init_2[2] = 100;
            x_init_2[3] = 120;
            x_init_2[4] = 100;
            x_init_2[5] = 70;
            for (int j_x = 0; j_x < y_init.length; j_x++) {
                y_init[j_x] += 60;
                y_init_2[j_x] += 60;
            }
        }        
    }
    
    private void choix_type_hexa (Hexagone[][] plateau_hexas, int x, int y, int x_init[], int y_init[]) {
        if ((y <= 3 && y >= 0) && (x >= 2 && x < 10) ) {
            plateau_hexas[x][y] = new Village(x_init,y_init);
            plateau_hexas[x][y].i_hexa = x;
            plateau_hexas[x][y].j_hexa = y;
            plateau_hexas[x][y].setEtat(0);
        }else if (x >= 0 && x < 2 || x >= 10 && x < 12 ){
            plateau_hexas[x][y] = new Foret(x_init,y_init);
            plateau_hexas[x][y].i_hexa = x;
            plateau_hexas[x][y].j_hexa = y;
            plateau_hexas[x][y].setEtat(0);
        }else {
            plateau_hexas[x][y] = new Montagne(x_init, y_init);
            plateau_hexas[x][y].i_hexa = x;
            plateau_hexas[x][y].j_hexa = y;
            plateau_hexas[x][y].setEtat(0);
        }
    }
}