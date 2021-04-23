package vue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListen extends MouseAdapter {

	public Hexagone carte;
	
	public MouseListen(Hexagone carte) {
		this.carte = carte;
	}
    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        this.carte.row = this.carte.col = -1;

//        System.out.println(x+"<-->"+y);
        
        for (int i = 0; i < this.carte.tri_1.length; i++)
            for (int j = 0; j <  this.carte.tri_1.length; j++)
                if (this.carte.tri_1[i][j].contains(x, y) || this.carte.tri_2[i][j].contains(x, y)) {
                	if ( this.carte.tri_2[i][j].contains(x, y)) {
                		this.carte.row = i;
                		this.carte.col = j;
                		this.carte.tri_hexa= false;
                	}else {
                		this.carte.row = i;
                		this.carte.col = j;
                		this.carte.tri_hexa= true;
                	}
                }
        this.carte.repaint();
    }
}
