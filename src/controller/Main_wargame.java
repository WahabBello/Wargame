package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

//import vue.Dessin_polygone;
import vue.Graphisme;

public class Main_wargame {

	public Main_wargame() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Execution de l' application pour afficher la graphisme
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Graphisme frame = new Graphisme();
					
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					frame.getContentPane().add(contenant, BorderLayout.CENTER);
//					frame.getContentPane().add(dessin_poly, BorderLayout.CENTER);
//					frame.getContentPane().add(dessin_poly, BorderLayout.CENTER);
					frame.setSize(1000, 600);
					frame.setLocationRelativeTo(null);
					
					

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
