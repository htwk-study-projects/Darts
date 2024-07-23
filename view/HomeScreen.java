package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeScreen extends JPanel {

	protected JButton playButton;
	protected JButton loadButton;
	protected JButton exitButton;
	
	private MenuBar homeMenu;

	public HomeScreen() {
		
		this.setLayout(new GridLayout(3,3));
		//this.setBackground(Color.blue);
		playButton = new JButton("Spielen");
		loadButton = new JButton("Spiel laden");
		exitButton = new JButton("Beenden");
		
		JButton[] homeButtons = {playButton, loadButton, exitButton};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, homeButtons);
		homeMenu = new MenuBar(homeButtons, 3, 1);
		
		homeMenu.menuPlacement(this, 4, 3, 3);

	}
}
