package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SetupScreen extends JPanel {
	
	protected JButton startButton;
	protected JButton homeButton;
	private MenuBar buttonPanel;
	
	public SetupScreen() {
		this.setLayout(new GridLayout(3,3));
		
		startButton = new JButton("Start");
		
		homeButton = new JButton("Abbrechen");
		
		JButton[] setupButtons = {startButton, homeButton};
		buttonPanel = new MenuBar(setupButtons, 2, 1);
		
		buttonPanel.menuPlacement(this, 4, 3, 3);
	}
}
