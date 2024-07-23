package view;

import java.awt.CardLayout;
import javax.swing.JFrame;

public class DartsGUI extends JFrame {
	
	private model.DartsData data;
	
	private CardLayout cardLayout;  // Instanzvariable für CardLayout
	
	public DartsGUI(model.DartsData gameData){
		
		this.data = gameData;
		
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		this.setTitle("DARTS");	
		this.setSize(1200, 820);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		HomeScreen home = new HomeScreen();
		this.add(home, "home");
		
		SetupScreen setup = new SetupScreen();
		this.add(setup, "setup");
		
		GameScreen game = new GameScreen();
		this.add(game, "game");
		
		home.playButton.addActionListener(e -> cardLayout.show(this.getContentPane(), "setup"));
		home.exitButton.addActionListener(e -> System.exit(0));
		
		setup.homeButton.addActionListener(e -> cardLayout.show(this.getContentPane(), "home"));
		setup.startButton.addActionListener(e -> cardLayout.show(this.getContentPane(), "game"));
		
		game.backButton.addActionListener(e -> cardLayout.show(this.getContentPane(), "home"));
		
	}

}
