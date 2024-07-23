package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeScreen extends JPanel {

	protected JButton playButton;
	protected JButton settingsButton;
	protected JButton loadButton;
	protected JButton exitButton;
	
	private MenuBar homeMenu;

	public HomeScreen() {
		
		this.setLayout(new GridLayout(3,3));
		this.setBackground(Color.blue);
		playButton = new JButton("Spielen");
		settingsButton = new JButton("Einstellungen");
		loadButton = new JButton("Spiel laden");
		exitButton = new JButton("Beenden");
		
		JButton[] setupButtons = {playButton, settingsButton, loadButton, exitButton};
		homeMenu = new MenuBar(setupButtons, 4, 1);
		
		homeMenu.menuPlacement(this, 4, 3, 3);

	}
}
