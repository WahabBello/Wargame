package vue;

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
import javax.swing.JLabel;



// Classe principale du jeu à excuter pour l'affichage du graphisme 

public class Graphisme extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
					frame.setBackground(Color.black);
					
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.add(dessin_poly, BorderLayout.CENTER);
					frame.setSize(1100, 700);
			
					dessin_poly.addMouseListener(new MouseListen(dessin_poly));
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
		contentPane.setBackground(new Color(184, 134, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Panel panel = new Panel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Passer le tour");
		panel.add(btnNewButton, BorderLayout.SOUTH);
		
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
		
		JLabel lblNewLabel = new JLabel("Data 1 : 100%");
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data 2 : 100%");
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data 3: 100%");
		panel_1.add(lblNewLabel_2);
		
//		Plateau frame = new Plateau();
//		Dessin_polygone carte = new Dessin_polygone(frame.tri_1, frame.tri_2, frame.row, frame.col, frame.tri_hexa);
//		carte.add(carte);
		
//		textField = new JTextField();
//		textField.setBackground(new Color(46, 139, 87));
//		contentPane.add(textField, BorderLayout.CENTER);
//		textField.setColumns(10);
	}

}
