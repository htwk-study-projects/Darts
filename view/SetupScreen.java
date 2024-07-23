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
		
		JButton[] setupButtons = {homeButton, startButton};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, setupButtons);
		buttonPanel = new MenuBar(setupButtons, 1, 2);
		buttonPanel.menuPlacement(this, 4, 3, 3);
	}
}
