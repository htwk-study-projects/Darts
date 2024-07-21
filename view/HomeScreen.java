package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeScreen extends JPanel {

	protected JButton startButton;

	public HomeScreen() {
		
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(Color.blue);
		
		startButton = new JButton("Start");
		startButton.setBounds(20, 100, 20, 30);
		this.add(startButton);
	}
}
