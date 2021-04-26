package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

// Initialisation des tableaux de polygone avec leurs differents couleurs

class Dessin_polygone extends JComponent {

    private static final long serialVersionUID = 1L;
    public Hexagone[][] tri_1;
    public Hexagone[][] tri_2;
    public int row;
    public int col;
    public boolean tri_hexa;

    public Dessin_polygone(Hexagone[][] tab_1, Hexagone[][] tab_2, int row, int col, boolean tri_hexa){
        this.tri_1 = tab_1;
        this.tri_2 = tab_2;
        this.row = row;
        this.col = col;
        this.tri_hexa = tri_hexa;
    }

    public void paint(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

//			        TexturePaint slatetp = new TexturePaint(this.slate, new Rectangle(0, 0, 90, 60));
//			        g2d.setPaint(slatetp);
//			        g2d.fillRect(0, 0, 860, 600);
        
         for (int x = 0; x < this.tri_1.length; x++) {
             for (int y = 0; y <  this.tri_1.length; y++) {
                 g2d.setColor(this.tri_1[x][y].getCouleur());
                 g2d.fillPolygon(this.tri_1[x][y].getDessin_hexa());

                 g2d.setColor(this.tri_2[x][y].getCouleur());
                 g2d.fillPolygon(this.tri_2[x][y].getDessin_hexa());
             }
             if (this.row != -1)
             {          	
                if (this.tri_hexa) {
                //    g2d.setColor(this.tri_1[this.row][this.col].getCouleur());
                   g2d.setColor(Color.WHITE);
                   g2d.fillPolygon(this.tri_1[this.row][this.col].getDessin_hexa());            		
                }else {
                //    g2d.setColor(this.tri_2[this.row][this.col].getCouleur());
                   g2d.setColor(Color.WHITE);
                   g2d.fillPolygon(this.tri_2[this.row][this.col].getDessin_hexa());
                }
             }
         }
    }

}

