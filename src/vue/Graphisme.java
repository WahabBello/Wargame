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
	public Boolean mode_deplacer;
	public Boolean mode_attaquer; 
	JLabel label_terrain;
	JLabel label_terrain_bd;	
	JLabel label_terrain_pd;
	// MouseListen data_event;
	Plateau plateau;
	Dessin_polygone dessin_poly;
	JPopupMenu popupMenu_unite;
	JPopupMenu popupMenu_menu;
	Panel panel_1;
	JLabel label_user;
	ArrayList<Joueur> players;
	Actions_unite controller;
	JLabel label_etat_hexa;
	JLabel label_num_joueur;
	JLabel label_unite;
	JLabel label_unite_pa;
	JLabel label_unite_pdef;
	JLabel label_unite_pdep;
	JLabel label_unite_pdevie;

	String[] type_unites = { "Infanterie", "Infanterie Lourde", "Cavalerie", "Mage", "Archer"};
	
	/**  Creation des differents onglets dans la fenetre	 */

	public Graphisme() {
		this.mode_deplacer = false;
		this.mode_attaquer = false;
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

	//**** Partie sur lequel est affiche nos polygones 		
	public void panel_plateau_jeu(JPanel contentPane) {
	//**** Importation du plateau 2D contenant tous les hexagone. 		
		plateau = new Plateau();
	//**** Importation la classe contenant l'affichage du plateau avec les infos du plateau en parametre. 		
		dessin_poly = new Dessin_polygone(plateau.plateau_hexas, plateau.row, plateau.col, plateau.tri_hexa);
			
		contentPane.add(dessin_poly, BorderLayout.CENTER);

		// Ecoute des cliques sur le dessin polygone
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
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attaquer();
			}
		});
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
	
	// Methode d'affichages des informations en haut
	public void top_panel (JPanel contentPane) {
		panel_1 = new Panel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		

		FlowLayout fl_panel_1 = new FlowLayout(FlowLayout.LEFT, 5, 5);
		panel_1.setLayout(fl_panel_1);
		
		JButton btnNewButton_1 = new JButton("Menu");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOptionsSave();
			}
		});
		panel_1.add(btnNewButton_1);

	popupMenu_menu = new JPopupMenu();

	JMenuItem item_reprise = new JMenuItem("Reprise de la partie");
	item_reprise.setActionCommand("");
	item_reprise.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			fonction_non_dispo();
		}
	});
	popupMenu_menu.add(item_reprise);	

	JMenuItem item_save = new JMenuItem("Sauvegarde de la partie");
	item_save.setActionCommand("");
	item_save.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			fonction_non_dispo();
		}
	});
	popupMenu_menu.add(item_save);


		// ---
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
	
	// Methode d'affichages des informations a droite

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
		
		label_etat_hexa = new JLabel("INFORMATIONS DU JEU");
		label_etat_hexa.setHorizontalAlignment(SwingConstants.CENTER);
		label_etat_hexa.setPreferredSize(new Dimension(160, 16));
		label_etat_hexa.setFont(new Font("SansSerif", Font.BOLD, 13));
		panel_2.add(label_etat_hexa);

		label_etat_hexa = new JLabel("Etat Hexa : ??");
		label_etat_hexa.setHorizontalAlignment(SwingConstants.CENTER);
		label_etat_hexa.setPreferredSize(new Dimension(140, 16));
		label_etat_hexa.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_etat_hexa);
		
		// label_num_joueur = new JLabel("Joueur : ??");
		// label_num_joueur.setHorizontalAlignment(SwingConstants.CENTER);
		// label_num_joueur.setPreferredSize(new Dimension(140, 16));
		// label_num_joueur.setFont(new Font("SansSerif", Font.PLAIN, 14));
		// panel_2.add(label_num_joueur);
		
		label_unite = new JLabel("Unit\u00E9 : Cavalerie");
		label_unite.setHorizontalAlignment(SwingConstants.CENTER);
		label_unite.setPreferredSize(new Dimension(140, 16));
		label_unite.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_unite);
		
		label_unite_pa = new JLabel("P. A : ??");
		label_unite_pa.setHorizontalAlignment(SwingConstants.CENTER);
		label_unite_pa.setPreferredSize(new Dimension(130, 16));
		label_unite_pa.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_unite_pa);
		
		label_unite_pdef = new JLabel("P. Defense : ??");
		label_unite_pdef.setHorizontalAlignment(SwingConstants.CENTER);
		label_unite_pdef.setPreferredSize(new Dimension(130, 16));
		label_unite_pdef.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_unite_pdef);
		
		label_unite_pdep = new JLabel("P. Depla : ??");
		label_unite_pdep.setHorizontalAlignment(SwingConstants.CENTER);
		label_unite_pdep.setPreferredSize(new Dimension(130, 16));
		label_unite_pdep.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_unite_pdep);
		
		label_unite_pdevie = new JLabel("P. De Vie : ??");
		label_unite_pdevie.setHorizontalAlignment(SwingConstants.CENTER);
		label_unite_pdevie.setPreferredSize(new Dimension(130, 16));
		label_unite_pdevie.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_unite_pdevie);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBackground(Color.DARK_GRAY);
		horizontalStrut.setPreferredSize(new Dimension(100, 11));
		panel_2.add(horizontalStrut);
		
		label_terrain = new JLabel("Terrain: ??");
		label_terrain.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_terrain);
		
		label_terrain_bd = new JLabel("Bonus Def. : ??");
		label_terrain_bd.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_terrain_bd);
		
		label_terrain_pd = new JLabel("Point Depl. : ??");
		label_terrain_pd.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(label_terrain_pd);
	}

	// Methode d'affichages du pop up quand on fait click droit
	
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

	// Methode d'affichages du pop up quand on fait click les ajout unites
	
	private void showOptionsUnites() {
    	 popupMenu_unite.show(panel_1, 60, 33);
	}
	
	private void showOptionsSave() {
    	 popupMenu_menu.show(panel_1, 20, 33);
	}

	// Methode pour ajouter une unitee
	
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
	// Methode pour les fonctionnalités non implementé
	
	private void fonction_non_dispo() {	
		JOptionPane.showMessageDialog(this,"Fonctionnalté non disponible");
	}

	// Methode pour changer l'hexagone selectionner

	public void change_hexa(Hexagone hexa) {
		this.hexa_selected = hexa;
	}
	// Methode pour attaquer 

	public void attaquer() {
		if (this.hexa_selected != null){
			// controller.deplacer(this.hexa_selected, this.player_actif, this.mode_deplacer);
			this.mode_attaquer = true;
		}else{
			JOptionPane.showMessageDialog(this,"Selectionnner une unite d'abord");
		}
	}

	// Methode pour deplacement 

	public void deplacement() {
		if (this.hexa_selected != null){
			this.mode_deplacer = true;
		}else{
			JOptionPane.showMessageDialog(this,"Selectionnner une unite d'abord");
		}

	}


	// Methode pour selectioner  le 2 eme hexagone et ainsi attaquer ou se deplacer 

	public void selection_hexa(MouseEvent e){
		controller.selection(e, this.mode_deplacer, this.mode_attaquer, this.hexa_selected, this.player_actif, dessin_poly);
		this.mode_deplacer = false;
		this.mode_attaquer = false;
		change_hexa(controller.hexa_selected);

	}

	// Methode pour mise à jour les infos a droite selectionner le 2eme   

	public void update_infos() {
		if(this.hexa_selected != null ) {
			if(this.hexa_selected.getEtat() != 0 ) {
				// label_num_joueur.setText("Joueur : " + this.player_actif.getNumero_joueur());
				label_etat_hexa.setText("Etat Hexa : " + this.hexa_selected.getEtat());
				label_unite.setText("Unit\u00E9 : " + this.hexa_selected.unite.getNom());
				label_unite_pa.setText("P. A : "+ this.hexa_selected.unite.getPoint_Attaque());
				label_unite_pdef.setText("P. Defense   : " + this.hexa_selected.unite.getPoint_Defense());				
				label_unite_pdep.setText("P. Depla : " + this.hexa_selected.unite.getPoint_Deplacement_Restant());				
				label_unite_pdevie.setText("P. De Vie : " + this.hexa_selected.unite.getPoint_vie_restant());				
			}
			label_terrain.setText("Terrain: " + this.hexa_selected.getType_hexa());
			label_terrain_bd.setText("Bonus Def. : "+ this.hexa_selected.getBonus_defense());
			label_terrain_pd.setText("Point Depl. : " + this.hexa_selected.getPoint_deplacements());			
		}
	}	
	
	// Methode pour selectionner player actif  

	public void selection_player() {
		players = Joueur.getListe_joueurs();
		this.player_actif =  players.get(0);
		label_user.setText("User actif : " + this.player_actif.getUsername());
	}
	
	// Methode pour passer le tour   

	public void passer_tour() {
		int i = players.indexOf(this.player_actif); 
		
		if ((i+1) == players.size()) {
			this.player_actif =  players.get(0);
			label_user.setText("User actif : " + this.player_actif.getUsername());
		}else {
			this.player_actif =  players.get(i+1);
			label_user.setText("User actif : " + this.player_actif.getUsername());			
		}

		for (i=0; i < this.player_actif.getListe_unite().size(); i++ ){
			this.player_actif.getListe_unite().get(i).setPoint_Deplacement_Restant(this.player_actif.getListe_unite().get(i).getPoint_Deplacement());
		}
	}
	
}
