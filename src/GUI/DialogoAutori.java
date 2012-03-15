package GUI;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;

public class DialogoAutori extends JDialog {

	/**
	 * Create the dialog.
	 */
	public DialogoAutori() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Autori ITAco");
		setBounds(100, 100, 326, 409);
		getContentPane().setLayout(null);
		
		JLabel lblAutori = new JLabel("Autori:");
		lblAutori.setBounds(52, 282, 61, 16);
		getContentPane().add(lblAutori);
		
		JLabel lblLucaMarturana = new JLabel("Luca Marturana");
		lblLucaMarturana.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblLucaMarturana.setForeground(SystemColor.controlHighlight);
		lblLucaMarturana.setBounds(110, 282, 120, 16);
		getContentPane().add(lblLucaMarturana);
		
		JLabel lblAlessandroGallotta = new JLabel("Alessandro Gallotta");
		lblAlessandroGallotta.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblAlessandroGallotta.setForeground(SystemColor.controlHighlight);
		lblAlessandroGallotta.setBounds(110, 254, 135, 16);
		getContentPane().add(lblAlessandroGallotta);
		
		JLabel lblNewLabel = new JLabel("Rosario Villari");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblNewLabel.setForeground(SystemColor.controlHighlight);
		lblNewLabel.setBounds(110, 314, 125, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Copyright © 2012, tutti i diritti riservati");
		lblNewLabel_1.setBounds(40, 350, 298, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(DialogoAutori.class.getResource("/img/itacoluca.png")));
		lblNewLabel_2.setBounds(6, 22, 332, 202);
		getContentPane().add(lblNewLabel_2);

	}
}
