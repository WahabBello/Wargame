package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Actions_unite;
import controller.Plateau;

import modele.Joueur;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Panel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Canvas;
import javax.swing.Box;
import java.awt.Font;



// Classe principale du jeu à excuter pour l'affichage du graphisme 

public class Graphisme extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Hexagone hexa_selected;
	public Joueur player_actif;
	JLabel label_terrain;
	JLabel label_terrain_bd;	
	JLabel label_terrain_pd;
	MouseListen data_event;
	Plateau plateau;
	Dessin_polygone dessin_poly;
	JPopupMenu popupMenu_unite;
	Panel panel_1;
	JLabel label_user;
	ArrayList<Joueur> players;
	Actions_unite controller;
	JLabel label_unite;
	JLabel label_unite_pa;
	JLabel label_unite_pdef;
	JLabel label_unite_pdep;
	public Boolean mode_deplacer;

	String[] type_unites = { "Infanterie", "Infanterie Lourde", "Cavalerie", "Mage", "Archer"};
	
	/**
	 * Creation des differents onglets dans la fenetre
	 */
	public Graphisme() {
//		players = Joueur.getListe_joueurs();
		// selection_player(); 
		this.mode_deplacer = false;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 477);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(5, 5));
		contentPane.setBackground(new Color(184, 134, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel_plateau_jeu(contentPane);		
		top_panel(contentPane);
		right_panel(contentPane);	
	}

	//**** Partie sur lequel est affich� nos polygones 		
	public void panel_plateau_jeu(JPanel contentPane) {
		plateau = new Plateau();
		dessin_poly = new Dessin_polygone(plateau.plateau_hexas, plateau.row, plateau.col, plateau.tri_hexa);
			
		contentPane.add(dessin_poly, BorderLayout.CENTER);

		dessin_poly.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller = new Actions_unite(dessin_poly);
				// controller.selection(e, mode_deplacer);
				selection_hexa(e);
				update_infos();
			}			
		});
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(dessin_poly, popupMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Attaquer");
		mntmNewMenuItem.setActionCommand("");
		popupMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Deplacer");
		mntmNewMenuItem_1.setActionCommand("");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deplacement();
			}
		});
		popupMenu_1.add(mntmNewMenuItem_1);
	} 
	
	public void top_panel (JPanel contentPane) {
		panel_1 = new Panel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		

		FlowLayout fl_panel_1 = new FlowLayout(FlowLayout.LEFT, 5, 5);
		panel_1.setLayout(fl_panel_1);
		
		JButton btnNewButton_1 = new JButton("Menu");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Add Unit\u00E9");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOptionsUnites();
			}
		});
		panel_1.add(btnNewButton_3);

		popupMenu_unite = new JPopupMenu();
		
		JMenuItem item_infanterie_cavalerie = new JMenuItem(type_unites[2]);
		item_infanterie_cavalerie.setActionCommand("");
		item_infanterie_cavalerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_unite(type_unites[2]);
			}
		});
		popupMenu_unite.add(item_infanterie_cavalerie);
		
		JMenuItem item_infanterie_lourde = new JMenuItem(type_unites[1]);
		item_infanterie_lourde.setActionCommand("");
		item_infanterie_lourde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_unite(type_unites[1]);
			}
		});
		popupMenu_unite.add(item_infanterie_lourde);
		
		JMenuItem item_archer = new JMenuItem(type_unites[4]);
		item_archer.setActionCommand("");
		item_archer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_unite(type_unites[4]);
			}
		});
		popupMenu_unite.add(item_archer);	

		JMenuItem item_infanterie = new JMenuItem(type_unites[0]);
		item_infanterie.setActionCommand("");
		item_infanterie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_unite(type_unites[0]);
			}
		});
		popupMenu_unite.add(item_infanterie);
		
		JMenuItem item_mage = new JMenuItem(type_unites[3]);
		item_mage.setActionCommand("");
		item_mage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_unite(type_unites[3]);
			}
		});
		popupMenu_unite.add(item_mage);	
		
		label_user = new JLabel("User actif : ");
		panel_1.add(label_user);
	}
	
	public void right_panel(JPanel contentPane) {
		Panel panel = new Panel();
		panel.setPreferredSize(new Dimension(150, 10));
		panel.setSize(new Dimension(10, 10));
		panel.setBounds(new Rectangle(15, 15, 10, 20));
		panel.setMinimumSize(new Dimension(8, 8));
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(10, 5));
//			panel.setBounds(40,50,150,150);
		
		JButton btnNewButton = new JButton("Passer le tour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passer_tour();
			}
		});
		panel.add(btnNewButton, BorderLayout.SOUTH);
		
		Panel panel_2 = new Panel();
		panel_2.setMinimumSize(new Dimension(6, 6));
		panel_2.setMaximumSize(new Dimension(0, 0));
		panel.add(panel_2, BorderLayout.CENTER);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel_2.setLayout(fl_panel_2);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(new Rectangle(0, 0, 60, 60));
		panel_2.add(canvas);
		
		label_unite = new JLabel("Unit\u00E9 : Cavalerie");
		label_unite.setHorizontalAlignment(SwingConstants.CENTER);
		label_unite.setPreferredSize(new Dimension(140, 16));
		label_unite.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_unite);
		
		label_unite_pa = new JLabel("P. A : 100%");
		label_unite_pa.setHorizontalAlignment(SwingConstants.CENTER);
		label_unite_pa.setPreferredSize(new Dimension(130, 16));
		label_unite_pa.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_unite_pa);
		
		label_unite_pdef = new JLabel("P. Def : 100%");
		label_unite_pdef.setHorizontalAlignment(SwingConstants.CENTER);
		label_unite_pdef.setPreferredSize(new Dimension(130, 16));
		label_unite_pdef.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_unite_pdef);
		
		label_unite_pdep = new JLabel("P. Dep : 100%");
		label_unite_pdep.setHorizontalAlignment(SwingConstants.CENTER);
		label_unite_pdep.setPreferredSize(new Dimension(130, 16));
		label_unite_pdep.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_unite_pdep);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBackground(Color.DARK_GRAY);
		horizontalStrut.setPreferredSize(new Dimension(100, 11));
		panel_2.add(horizontalStrut);
		
		label_terrain = new JLabel("Terrain: Foret");
		label_terrain.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_terrain);
		
		label_terrain_bd = new JLabel("Bonus Def. : 100%");
		label_terrain_bd.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_terrain_bd);
		
		label_terrain_pd = new JLabel("Point Depl. : 7");
		label_terrain_pd.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_terrain_pd);
	}
	
	private void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
			     if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1){
			           popup.show(e.getComponent() , e.getX(), e.getY());
			     }
			}
		});
	}
	
	private void showOptionsUnites() {
    	 popupMenu_unite.show(panel_1, 60, 33);
	}
	
	private void add_unite(String type_unite) {	
		if (this.hexa_selected != null){
			if(player_actif.nb_unite != 0 && this.hexa_selected.getEtat() == 0) {
				controller.ajouter_unite(type_unite, player_actif, this.hexa_selected);			
			}else if(this.hexa_selected.getEtat() != 0){
				JOptionPane.showMessageDialog(this,"Hexagone deja occupee");
			}else{
				JOptionPane.showMessageDialog(this,"Vous avez epuise votre nombre d'unite");
			}
		}else{
			JOptionPane.showMessageDialog(this,"Selectionnner un hexagone d'abord");
		}
	}

	public void change_hexa(Hexagone hexa) {
		this.hexa_selected = hexa;
	}

	public void deplacement() {
		if (this.hexa_selected != null){
			controller.deplacer(this.hexa_selected, this.player_actif, this.mode_deplacer);
			this.mode_deplacer = true;
		}else{
			JOptionPane.showMessageDialog(this,"Selectionnner une ubite d'abord");
		}
		if (this.mode_deplacer){
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}

	public void selection_hexa(MouseEvent e){
		controller.selection(e, this.mode_deplacer, this.hexa_selected, this.player_actif);
		this.mode_deplacer = false;
		change_hexa(controller.hexa_selected);

	}

	public void update_infos() {
		if(this.hexa_selected != null ) {
			if(this.hexa_selected.getEtat() != 0 ) {
				label_unite.setText("Unit\u00E9 : " + this.hexa_selected.unite.getNom());
				label_unite_pa.setText("P. A : "+ this.hexa_selected.unite.getPoint_Attaque());
				label_unite_pdef.setText("P. Def   : " + this.hexa_selected.unite.getPoint_Defense());				
				label_unite_pdep.setText("P. Dep : " + this.hexa_selected.unite.getPoint_Deplacement());				
			}
			label_terrain.setText("Terrain: " + this.hexa_selected.getType_hexa());
			label_terrain_bd.setText("Bonus Def. : "+ this.hexa_selected.getBonus_defense());
			label_terrain_pd.setText("Point Depl. : " + this.hexa_selected.getPoint_deplacements());			
		}
	}	
	
	public void selection_player() {
		players = Joueur.getListe_joueurs();
		this.player_actif =  players.get(0);
		label_user.setText("User actif : " + this.player_actif.getUsername());
	}
	
	public void passer_tour() {
		int i = players.indexOf(this.player_actif); 
		if ((i+1) == players.size()) {
			this.player_actif =  players.get(0);
			label_user.setText("User actif : " + this.player_actif.getUsername());
		}else {
			this.player_actif =  players.get(i+1);
			label_user.setText("User actif : " + this.player_actif.getUsername());			
		}
	}
	
}
