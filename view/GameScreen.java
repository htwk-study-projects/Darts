package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameScreen extends JPanel {
	
	protected JButton backButton;
	
	public GameScreen() {
		
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(Color.red);
		
		backButton = new JButton("Zurück");
		backButton.setBounds(20, 100, 20, 30);
		this.add(backButton);
	}
}
