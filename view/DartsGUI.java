package view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.DartsData;

public class DartsGUI extends JFrame {
	
	private DartsData data;
	
	private CardLayout cardLayout;  // Instanzvariable für CardLayout
	
	public DartsGUI(DartsData d){
		this.data = d;
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		this.setTitle("DARTS");
		this.setSize( 1200, 820);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setLocationRelativeTo(null);
		
		HomeScreen home = new HomeScreen();
		this.add(home, "home");
		
		
		GameScreen game = new GameScreen();
		this.add(game, "game");
		
		home.startButton.addActionListener(e -> cardLayout.show(this.getContentPane(), "game"));
		game.backButton.addActionListener(e -> cardLayout.show(this.getContentPane(), "home"));
		
	}

}
