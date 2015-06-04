import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class BattleFail extends JPanel{
	
	private JPanel jp1 = new JPanel();
	private JLabel a = new JLabel("ayy");
	private Font f = new Font("", Font.BOLD, 25);
	
	public BattleFail(Color c) {
		setBackground(c);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jp1.setLayout(new FlowLayout());
		a.setFont(f);
		add(a);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		a.setBounds(100, 200, 159, 100);
		g.fillRect(0, 50, 800, 600);
		
		
	}

}