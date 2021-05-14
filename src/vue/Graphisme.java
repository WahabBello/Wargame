package vue;
//
//import vue.Dessin_polygone;
//import vue.Plateau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Panel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
//import javax.swing.JToggleButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
//import javax.swing.JMenu;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Canvas;
import javax.swing.Box;
import javax.swing.ImageIcon;



// Classe principale du jeu à excuter pour l'affichage du graphisme 

public class Graphisme extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Hexagone hexa_selected;
	
//	public MouseListen data_event;
//	private JTextField textField;
	

	/**
	 * Execution de l' application pour afficher la graphisme
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plateau plateau = new Plateau();
					Dessin_polygone dessin_poly = new Dessin_polygone(plateau.tri_1, plateau.tri_2, plateau.row, plateau.col, plateau.tri_hexa);


					Graphisme frame = new Graphisme();
					
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					frame.getContentPane().add(contenant, BorderLayout.CENTER);
					frame.getContentPane().add(dessin_poly, BorderLayout.CENTER);
					frame.getContentPane().add(dessin_poly, BorderLayout.CENTER);
					frame.setSize(1100, 700);
					frame.setLocationRelativeTo(null);
					
					MouseListen data_event = new MouseListen(dessin_poly);
					dessin_poly.addMouseListener(data_event);
					
					dessin_poly.addMouseListener(new MouseListener() {

						@Override
						public void mouseClicked(MouseEvent e) {
							// TODO Auto-generated method stub
//							this.getHexa
							System.out.println(data_event.getHexa_selected().getType_hexa());
							
						}

						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							
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
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

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
		
		top_panel(contentPane);
		right_panel(contentPane);
		
	}

	public void top_panel (JPanel contentPane) {
		Panel panel_1 = new Panel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		

		FlowLayout fl_panel_1 = new FlowLayout(FlowLayout.LEFT, 5, 5);
		panel_1.setLayout(fl_panel_1);
		
		JButton btnNewButton_1 = new JButton("Menu");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Actions");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add Unit\u00E9");
		panel_1.add(btnNewButton_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("User : ");
		panel_1.add(lblNewLabel_1_1);
	}
	
	public void right_panel(JPanel contentPane) {
		Panel panel = new Panel();
		panel.setBounds(new Rectangle(15, 15, 10, 20));
		panel.setMinimumSize(new Dimension(8, 8));
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
//			panel.setBounds(40,50,150,150);
		
		JButton btnNewButton = new JButton("Passer le tour");
		panel.add(btnNewButton, BorderLayout.SOUTH);
		
		Panel panel_2 = new Panel();
		panel_2.setPreferredSize(new Dimension(5, 5));
		panel_2.setMinimumSize(new Dimension(6, 6));
		panel_2.setMaximumSize(new Dimension(0, 0));
		panel.add(panel_2, BorderLayout.CENTER);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel_2.setLayout(fl_panel_2);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(new Rectangle(0, 0, 60, 60));
		panel_2.add(canvas);
		
		JLabel lblNewLabel_3 = new JLabel("Unit\u00E9 : xxxx");
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("P. A : 100%");
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("P. D : 100%");
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("P. Dep : 100%");
		panel_2.add(lblNewLabel_2);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBackground(Color.DARK_GRAY);
		horizontalStrut.setPreferredSize(new Dimension(50, 11));
		panel_2.add(horizontalStrut);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Terrain: xxxx");
		panel_2.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Bonus Def. : 100%");
		panel_2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Point Depl. : 7");
		panel_2.add(lblNewLabel_3_1_1);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
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
}
