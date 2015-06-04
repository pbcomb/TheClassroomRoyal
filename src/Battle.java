import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Battle extends JFrame {
	private JButton bStart = new JButton("Start");
	private static BattlePanel p1 = new BattlePanel(Color.WHITE);
	private JLabel title = new JLabel("The Classroom Royal");
	private JButton bTut = new JButton("Help");
	private JButton btnBack = new JButton("Go Back");
	
	private JLabel instru1 = new JLabel("In The Classroom Royal there are 4 main stats str, vit, def, and dex, each one specializing in different aspects. ");
	private JLabel instru2 = new JLabel("Str will increase damage dealt, vit increases max health, defense reduces damage taken, and dex increases evade chance.");
	private JLabel instru3 = new JLabel("There are three classes, Peasant, Student, and Deliquent each one specializing in different aspects");
	private JLabel instru4 = new JLabel("Peasant is an all-arounder type, Student is a dex-based class who relies on evading, and Delinquent has a large health pool and hits hard");
	private JLabel instru5 = new JLabel("There are three main actions that you can perform in your turn, Attack, Wait, and Evade");
	private JLabel instru6 = new JLabel("Attack will do damage to the enemy based on your str, Wait will heal you based on your missing hp");
	private JLabel instru7 = new JLabel("After defeating an enemy, you will gain exp, after reaching the set amount of exp you will level up.");
	private Font ifont = new Font("", Font.BOLD, 13);
	private JLabel instru8 = new JLabel("Your main goal is to defeat all of your classmates, where you challenge DSawyer and attempt to defeat him.");
	private JLabel instru9 = new JLabel("(you can't wait twice in a row) and Evade will give you a chance to evade the attack and heal based on dex");

	public Battle() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("The Classroom Royal v1.0");
		JPanel jp = new JPanel();
		jp.setBackground(Color.WHITE);
		jp.setPreferredSize(new Dimension(800, 600));
		jp.setLayout(null);
		p1.setVisible(false);
		btnBack.setVisible(false);
		setResizable(false);
		bStart.setBounds(225, 450, 150, 30);
		bTut.setBounds(425, 450, 150, 30);
		bStart.addActionListener(new ButtonEars());
		bTut.addActionListener(new ButtonEars());
		btnBack.addActionListener(new ButtonEars());
		btnBack.setBounds(20, 550, 150, 30);
		p1.setBounds(0, 0, 810, 610);
		title.setBounds(125, 30, 600, 100);
		
		instru1.setVisible(false);
		instru2.setVisible(false);
		instru3.setVisible(false);
		instru4.setVisible(false);
		instru5.setVisible(false);
		instru6.setVisible(false);
		instru7.setVisible(false);
		instru8.setVisible(false);
		instru9.setVisible(false);
		
		instru1.setFont(ifont);
		instru2.setFont(ifont);
		instru3.setFont(ifont);
		instru4.setFont(ifont);
		instru5.setFont(ifont);
		instru6.setFont(ifont);
		instru7.setFont(ifont);
		instru8.setFont(ifont);
		instru9.setFont(ifont);
		
		instru1.setBounds(5, 20, 800, 40);
		instru2.setBounds(5, 40, 800, 40);
		instru3.setBounds(5, 60, 800, 40);
		instru4.setBounds(5, 80, 800, 40);
		instru5.setBounds(5, 100, 800, 40);
		instru6.setBounds(5, 120, 800, 40);
		instru9.setBounds(5, 140, 800, 40);
		instru7.setBounds(5, 160, 800, 40);
		instru8.setBounds(5, 180, 800, 40);
		
		jp.add(instru1);
		jp.add(instru2);
		jp.add(instru3);
		jp.add(instru4);
		jp.add(instru5);
		jp.add(instru6);
		jp.add(instru7);
		jp.add(instru8);
		jp.add(instru9);
		
		

		Font f = new Font("", Font.BOLD, 50);
		title.setFont( f );
		jp.add(bStart);
		jp.add(p1);
		jp.add(title);
		jp.add(bTut);
		jp.add(btnBack);
		getContentPane().add(jp);
		pack();
	}

	public void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
			}
		});
	}

	private class ButtonEars implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(bStart)) {
			p1.setVisible(true);
			bStart.setVisible(false);
			bTut.setVisible(false);
			} 
			else if (e.getSource().equals(bTut)) {
				btnBack.setVisible(true);
				bStart.setVisible(false);
				title.setVisible(false);
				bTut.setVisible(false);
				instru1.setVisible(true);
				instru2.setVisible(true);
				instru3.setVisible(true);
				instru4.setVisible(true);
				instru5.setVisible(true);
				instru6.setVisible(true);
				instru7.setVisible(true);
				instru8.setVisible(true);
				instru9.setVisible(true);
			}	else if (e.getSource().equals(btnBack)) {
					bStart.setVisible(true);
					title.setVisible(true);
					bTut.setVisible(true);
					btnBack.setVisible(false);
					instru1.setVisible(false);
					instru2.setVisible(false);
					instru3.setVisible(false);
					instru4.setVisible(false);
					instru5.setVisible(false);
					instru6.setVisible(false);
					instru7.setVisible(false);
					instru8.setVisible(false);
					instru9.setVisible(false);
				}
				
			//p1.repaint();
			
		}
	}
}
