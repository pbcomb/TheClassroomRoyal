import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BattlePanel extends JPanel {
	private JButton labPeasant = new JButton("Peasant");
	private JButton labStu = new JButton("Student");
	private JButton labMan = new JButton("Delinquent");

	public static BattleFight ay = new BattleFight(Color.WHITE);
	private Classroom player;
	public Classroom enemy;
	public BattlePanel gg = this;
	private JLabel labChoose = new JLabel("Choose Your Class");
	private JLabel stat1S = new JLabel("Str: " + 12);
	private JLabel stat1Dex = new JLabel("Dex: " + 12);
	private JLabel stat1V = new JLabel("Vit: " + 12);
	private JLabel stat1Def = new JLabel("Def: " + 12);
	
	private JLabel stat2S = new JLabel("Str: " + 11);
	private JLabel stat2Dex = new JLabel("Dex: " + 17);
	private JLabel stat2V = new JLabel("Vit: " + 12);
	private JLabel stat2Def = new JLabel("Def: " + 10);

	private JLabel stat3S = new JLabel("Str: " + 16);
	private JLabel stat3Dex = new JLabel("Dex: " + 6);
	private JLabel stat3V = new JLabel("Vit: " + 26);
	private JLabel stat3Def = new JLabel("Def: " + 9);

	private JPanel jp1 = new JPanel();

	private Font f = new Font("", Font.BOLD, 50);
	private Font f1 = new Font("", Font.BOLD, 40);
	private Font s = new Font("Roboto", Font.BOLD, 20);

	private boolean isStu = false;
	private boolean isPea = false;
	private boolean isDel = false;

	public BattlePanel(Color c) {
		setBackground(c);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	
		
		labPeasant.addActionListener(new ButtonEars());
		labStu.addActionListener(new ButtonEars());
		labMan.addActionListener(new ButtonEars());
		

		ay.setVisible(false);
		
		jp1.setLayout(new FlowLayout());

		labPeasant.setFont(f1);
		labStu.setFont(f1);
		labMan.setFont(f1);
		labChoose.setFont(f);

		stat1S.setFont(s);
		stat1Dex.setFont(s);
		stat1V.setFont(s);
		stat1Def.setFont(s);

		stat2S.setFont(s);
		stat2Dex.setFont(s);
		stat2V.setFont(s);
		stat2Def.setFont(s);

		stat3S.setFont(s);
		stat3Dex.setFont(s);
		stat3V.setFont(s);
		stat3Def.setFont(s);

		add(stat1S);
		add(stat1Dex);
		add(stat1V);
		add(stat1Def);

		add(stat2S);
		add(stat2Dex);
		add(stat2V);
		add(stat2Def);

		add(stat3S);
		add(stat3Dex);
		add(stat3V);
		add(stat3Def);

		add(labChoose);
		add(labPeasant);
		add(ay);
		add(labStu);
		add(labMan);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		

		
		labPeasant.setBounds(20, 80, 225, 100);
		labStu.setBounds(280, 80, 225, 100);
		labMan.setBounds(540, 80, 250, 100);

		stat1S.setBounds(30, 200, 225, 50);
		stat1Dex.setBounds(30, 250, 225, 50);
		stat1V.setBounds(30, 300, 225, 100);
		stat1Def.setBounds(30, 350, 225, 100);

		stat2S.setBounds(290, 200, 225, 50);
		stat2Dex.setBounds(290, 250, 225, 50);
		stat2V.setBounds(290, 300, 225, 100);
		stat2Def.setBounds(290, 350, 225, 100);

		stat3S.setBounds(550, 200, 225, 50);
		stat3Dex.setBounds(550, 250, 225, 50);
		stat3V.setBounds(550, 300, 225, 100);
		stat3Def.setBounds(550, 350, 225, 100);

		ay.setBounds(0, 0, 800, 600);
		labChoose.setBounds(160, 0, 500, 100);
		

		g.setColor(Color.GREEN);
		g.fillRect(20, 80, 225, 500);
		g.fillRect(280, 80, 225, 500);
		g.fillRect(540, 80, 250, 500);

	}
	
	private void initClassBattle(){
		 player = new Classroom( this );
	}
	

	private class ButtonEars implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(labPeasant)) {
				isPea = true;
			} else if (e.getSource().equals(labStu)) {
				isStu = true;

			} else if (e.getSource().equals(labMan)) {
				isDel = true;

			}
			
			initClassBattle();
			
		
			ay.setVisible(true);
			labPeasant.setVisible(false);
			labMan.setVisible(false);
			labChoose.setVisible(false);
			labStu.setVisible(false);

			stat1S.setVisible(false);
			stat1Dex.setVisible(false);
			stat1V.setVisible(false);
			stat1Def.setVisible(false);

			stat2S.setVisible(false);
			stat2Dex.setVisible(false);
			stat2V.setVisible(false);
			stat2Def.setVisible(false);

			stat3S.setVisible(false);
			stat3Dex.setVisible(false);
			stat3V.setVisible(false);
			stat3Def.setVisible(false);

		}
	}

	
	public BattlePanel getPanel() {
		return this;
	}
	
	
	public boolean getPea() {
		return isPea;
	}

	public boolean getStu() {
		return isStu;
	}

	public boolean getDel() {
		return isDel;
	}

}
