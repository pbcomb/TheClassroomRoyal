import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BattleFight extends JPanel {
	public static JButton btnAtk = new JButton("Attack");
	public static JButton btnWait = new JButton("Wait");
	public static JButton btnEva = new JButton("Evade");
	
	
	public static JButton retry = new JButton("Try Again?");
	
	public static boolean rundoge;

	public static JLabel loss = new JLabel("YOU DIED");
	
	private static BufferedImage player;
	private static BufferedImage enemy;

	private BattleClick plays;
	public static JLabel pdefeated = new JLabel("");
	public static JLabel lvl = new JLabel("Level 0" );

	public static JLabel myname = new JLabel("Thep");
	public static JLabel hp = new JLabel("HP: " + Classroom.thep.maxhp + " / " + Classroom.thep.maxhp);
	public static JLabel ehp = new JLabel("HP: " + "???"  );
	public static JLabel mexp = new JLabel("EXP: " + "0" + " / " + 50 );
	private Turns pp = new Turns();
	public boolean pwait;
	public boolean pattk;
	public boolean pevade;
	
	public static boolean sawyerSummoned = false;
	public static boolean getSummoned = false;

	private static int te;
	private static int enemyInd;
	private static ArrayList<String> names = new ArrayList<String>(
			Arrays.asList("Marc", "Nathan", "Ronald", "Nick", "Jack", "Bill",
					"Gerry", "Amanda", "Tim", "Kevin", "Adam", "Micheal"));
	public static String tempName = getNameh();

	public static JTextArea message = new JTextArea(
			"A new challenger has  appeared... " + tempName + "!"
					+ " What will you do?", 2, 2);

	public static JLabel enemyNameTag = new JLabel(tempName);
	public static JLabel upisnot = new JLabel();


	private Font f = new Font("", Font.BOLD, 25);
	private Font f1 = new Font("Roboto", Font.BOLD, 20);
	private Font f2 = new Font("", Font.BOLD, 15);
	private Font f3 = new Font("", Font.PLAIN,15);
	private Font f4 = new Font("",Font.BOLD,35);

	public BattleFight(Color c) {
		setBackground(c);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		addMouseListener(new ayy());
		summon();		
		btnAtk.addActionListener(new ButtonEars());
		btnEva.addActionListener(new ButtonEars());
		btnWait.addActionListener(new ButtonEars());
		retry.addActionListener(new ButtonEars());
		pdefeated.setFont(f2);
		myname.setFont(f1);
		btnAtk.setFont(f);
		message.setFont(f3);
		message.setWrapStyleWord(true);
		loss.setVisible(false);
		retry.setVisible(false);
		hp.setFont(f2);
		ehp.setFont(f2);
		mexp.setFont(f2);
		enemyNameTag.setFont(f1);
		lvl.setFont(f1);
		upisnot.setFont(f2);
		loss.setFont(f4);
		
		add(pdefeated);
		add(loss);
		add(retry);
		add(upisnot);
		add(lvl);
		add(myname);
		add(btnAtk);
		add(btnWait);
		add(btnEva);
		add(hp);
		add(ehp);
		add(mexp);
		add(message);
		add(enemyNameTag);
		System.out.println(tempName);

	}

	public static String getNameh() {
		if (names.size() != 0) {
		te = (int)(Math.random() * names.size());
		enemyInd = te;
		getSummoned = true;
		
		return names.get(te);
	}
		else {
			names.add( "DSaw" );
			summonSawyer();
			sawyerSummoned = true;
			btnAtk.setText("Study");
			btnWait.setText("Goof Off");
			btnEva.setText("Skip Class");
			Classroom.thug.str = 50;
			Classroom.thug.dex = 50;
			Classroom.thug.vit = 50;
			Classroom.thug.def = 50;
			return null;
		}
	}

	public static void removeEnemy() {
		names.remove(enemyInd);
		tempName = getNameh();
		
		if (tempName != null) {
		enemyNameTag.setText(tempName);
		summon();
		} else {
			enemyNameTag.setText("DSawyer");
		}
			
	}
	
	public static void updateEhp() {
	  ehp.setText("HP: " + Classroom.thug.health + " / " + Classroom.thug.maxhp);
	}
	
	public static void updateHp() {
		hp.setText("HP: " + Classroom.thep.health + " / " + Classroom.thep.maxhp);
	}
	public static void updateExp() {
		mexp.setText("EXP " + Classroom.thep.exp + " / " + Classroom.thep.maxexp);
	}
	public static void updateMessage(String type) {
		message.setText(type);
	}
	public static void updatelvl(int x) {
		lvl.setText("Level " + x );
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(5, 495, 485, 100);
		g.setColor(Color.CYAN);
		message.setWrapStyleWord(true);
		g.drawImage(player, 110, 234, null);
		g.drawImage(enemy, 575, 65, null);
		
		g.setColor(Color.RED);
		g.drawRect(300, 395, Classroom.thep.maxhp, 20);
		g.fillRect(300, 395, (Classroom.thep.health), 20);
		g.drawRect(400, 65, (Classroom.thug.maxhp), 20);
		g.fillRect(400, 65, (Classroom.thug.health), 20);
		g.setColor(Color.YELLOW);
		g.drawRect(350, 421, Classroom.thep.maxexp, 20);
		g.fillRect(350, 421, (Classroom.thep.exp), 20);
		
		
		pdefeated.setBounds(300, 250, 500, 100);
		loss.setBounds(400, 300, 200, 100);
		loss.setForeground(Color.RED);
		retry.setBounds(450,400,175,40);
		upisnot.setBounds(100,430,600,50);
		lvl.setBounds(100,175,100,50);
		lvl.setForeground(Color.GREEN);
		myname.setBounds(150, 200, 100, 50);
		btnAtk.setBounds(495, 495, 150, 100);
		btnWait.setBounds(645, 495, 150, 50);
		btnEva.setBounds(645, 545, 150, 50);
		message.setBounds(30, 500, 450, 50);
		enemyNameTag.setBounds(600, 0, 300, 100);
		hp.setBounds(300, 380, 200, 50);
		hp.setForeground(Color.BLACK);
		ehp.setBounds(400, 50, 200, 50);
		ehp.setForeground(Color.BLACK);
		mexp.setBounds(350, 400, 200, 50);
		mexp.setForeground(Color.ORANGE);
		
		

	}

	public static void summon() {

		try {
			player = ImageIO.read(new File("guy.png"));
		}

		catch (IOException e) {
			System.out.println(e);
		}

		try {
			enemy = ImageIO.read(new File("guy.png"));
		}

		catch (IOException e) {
			System.out.println(e);
		}

		if (tempName.equals("Nathan")) {
			try {
				enemy = ImageIO.read(new File("nathan.png"));
			}

			catch (IOException e) {
				System.out.println(e);
			}
		} else if (tempName.equals("Kevin")) {
			try {
				enemy = ImageIO.read(new File("kevin.png"));
			}

			catch (IOException e) {
				System.out.println(e);
			}
		} else if (tempName.equals("Amanda")) {
			try {
				enemy = ImageIO.read(new File("amanda.png"));
			}

			catch (IOException e) {
				System.out.println(e);
			}
		}

		else if (tempName.equals("Gerry")) {
			try {
				enemy = ImageIO.read(new File("gerry.png"));
			}

			catch (IOException e) {
				System.out.println(e);
			}
		} else if (tempName.equals("Bill")) {
			try {
				enemy = ImageIO.read(new File("bill.png"));
			}

			catch (IOException e) {
				System.out.println(e);
			}
		}

		else if (tempName.equals("Ronald")) {
			try {
				enemy = ImageIO.read(new File("ronald.png"));
			}

			catch (IOException e) {
				System.out.println(e);
			}
		} else if (tempName.equals("Nick")) {
			try {
				enemy = ImageIO.read(new File("nick.png"));
			}

			catch (IOException e) {
				System.out.println(e);
			}
		}

		else if (tempName.equals("Jack")) {
			try {
				enemy = ImageIO.read(new File("jack.png"));
			}

			catch (IOException e) {
				System.out.println(e);
			}
		} else if (tempName.equals("Marc")) {
			try {
				enemy = ImageIO.read(new File("marc.png"));
			}

			catch (IOException e) {
				System.out.println(e);
			}
		} else if (tempName.equals("Adam")) {
			try {
				enemy = ImageIO.read(new File("adam.png"));
			}

			catch (IOException e) {
				System.out.println(e);
			}
		} else if (tempName.equals("Tim")) {
			try {
				enemy = ImageIO.read(new File("tim.png"));
			}

			catch (IOException e) {
				System.out.println(e);
			}
		} else if (tempName.equals("Micheal")) {
			try {
				enemy = ImageIO.read(new File("micheal.png"));
			}

			catch (IOException e) {
				System.out.println(e);
			}
		}
	}
		
	public static void summonSawyer() {
			try {
				enemy = ImageIO.read(new File("dsaw.png"));
			}

			catch (IOException e) {
				System.out.println(e);
			}
		}
	

	private void initClassBattlep() {
		plays = new BattleClick(this);
	}

	private class ButtonEars implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(btnWait)) {
				pp.pwait();
				// System.out.println("a");
			}

			else if (e.getSource().equals(btnEva)) {
				pp.evaded();
				rundoge = true;
			}

			else if (e.getSource().equals(btnAtk)) {
				pp.attk();
			}
		
			initClassBattlep();
		}

	}

	private class ayy implements MouseListener {
		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
		}
	}

}
