package vue;
//
//import vue.Dessin_polygone;
//import vue.Plateau;

import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import javax.swing.border.LineBorder;

import controller.Actions_unite;
//import controller.MouseListen;
import controller.Plateau;

//import controller.Dessin_polygone;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Panel;
//import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
//import javax.swing.JScrollPane;
//import javax.swing.JViewport;
//import javax.swing.ScrollPaneConstants;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Canvas;
import javax.swing.Box;
//import javax.swing.ImageIcon;
import java.awt.Font;
//import java.awt.GridBagLayout;



// Classe principale du jeu Ã  excuter pour l'affichage du graphisme 

public class Graphisme extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Hexagone hexa_selected;
	JLabel label_terrain;
	JLabel label_terrain_bd;	
	JLabel label_terrain_pd;
	MouseListen data_event;
	Plateau plateau;
	Dessin_polygone dessin_poly;
	JPopupMenu popupMenu_unite;
	Panel panel_1;
	
	/**
	 * Creation des differents onglets dans la fenetre
	 */
	public Graphisme() {
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

	//**** Partie sur lequel est affichï¿½ nos polygones 		
	public void panel_plateau_jeu(JPanel contentPane) {
		plateau = new Plateau();
		dessin_poly = new Dessin_polygone(plateau.plateau_hexas, plateau.row, plateau.col, plateau.tri_hexa);
		
//		 JScrollPane jsp = new JScrollPane(dessin_poly);
//		 JViewport jvp = new JViewport();
//		 jvp = jsp.getViewport();
//		 jvp.setViewPosition(new Point(30,200));

//		Panel panel_plateau = new Panel();
//		panel_plateau.add(dessin_poly);
//		panel_plateau.setLayout(new GridBagLayout());
//		panel_plateau.setBorder(LineBorder.createBlackLineBorder());
	
	
//		JScrollPane scrollPane = new JScrollPane(dessin_poly, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scrollPane.setPreferredSize(new Dimension(600, 600));
		
		contentPane.add(dessin_poly, BorderLayout.CENTER);
//		data_event = new MouseListen(dessin_poly);
//		dessin_poly.addMouseListener(data_event);
		
//		dessin_poly.addMouseListener(new Actions_unite(dessin_poly));
		dessin_poly.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Actions_unite controller = new Actions_unite(dessin_poly);
				controller.selection(e);
				change_hexa(controller.hexa_selected);
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
		
		JMenuItem item_infanterie_cavalerie = new JMenuItem("Cavalerie");
		item_infanterie_cavalerie.setActionCommand("");
		item_infanterie_cavalerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_unite("Cavalerie");
			}
		});
		popupMenu_unite.add(item_infanterie_cavalerie);
		
		JMenuItem item_infanterie_lourde = new JMenuItem("Infanterie Lourde");
		item_infanterie_lourde.setActionCommand("");
		item_infanterie_lourde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_unite("Infanterie Lourde");
			}
		});
		popupMenu_unite.add(item_infanterie_lourde);
		
		JMenuItem item_archer = new JMenuItem("Archer");
		item_archer.setActionCommand("");
		item_archer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_unite("Archer");
			}
		});
		popupMenu_unite.add(item_archer);	

		JMenuItem item_infanterie = new JMenuItem("Infanterie");
		item_infanterie.setActionCommand("");
		item_infanterie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_unite("Infanterie");
			}
		});
		popupMenu_unite.add(item_infanterie);
		
		JMenuItem item_mage = new JMenuItem("Mage");
		item_mage.setActionCommand("");
		item_mage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_unite("Mage");
			}
		});
		popupMenu_unite.add(item_mage);	
		
		JLabel label_user = new JLabel("User : ");
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
		
		JLabel lblNewLabel_3 = new JLabel("Unit\u00E9 : Cavalerie");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("P. A : 100%");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("P. D : 100%");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("P. Dep : 100%");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_2.add(lblNewLabel_2);
		
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
	
	private void add_unite(String type_unité) {
		System.out.println(type_unité);
	}

	public void change_hexa(Hexagone hexa) {
		this.hexa_selected = hexa;
	}

	public void update_infos() {
		label_terrain.setText("Terrain: " + this.hexa_selected.getType_hexa());
		label_terrain_bd.setText("Bonus Def. : "+ this.hexa_selected.getBonus_defense());
		label_terrain_pd.setText("Point Depl. : " + this.hexa_selected.getPoint_deplacements());
	}	
	
}
