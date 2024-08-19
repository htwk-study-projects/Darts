package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameScreen extends JPanel {
	
	protected JButton backButton;
	protected JButton boardButton;
	
	public GameScreen() {
		
		this.setBackground(Color.red);
		
		backButton = new JButton("Zurück");
		backButton.setBounds(20, 100, 20, 30);
		this.add(backButton);
		
		boardButton = new JButton("Board");
		boardButton.setBounds(40, 100, 20, 30);
		this.add(boardButton);
		
		
	}
	
}
