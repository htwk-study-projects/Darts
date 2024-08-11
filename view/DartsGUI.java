package view;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class DartsGUI extends JFrame {
	
	private CardLayout cardLayout;  // Instanzvariable für CardLayout
	
	protected final static Font FONT_TITLE = new Font("Arial", Font.BOLD, 32);
	protected final static Font FONT_BIG = new Font("Arial", Font.BOLD, 22);
	protected final static Font FONT_NORMAL = new Font("Arial", Font.PLAIN, 14);
	protected final static Font FONT_SMALL = new Font("Arial", Font.PLAIN, 10);
	
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
	
	public static void fontAdjust(Font font, JComponent[] elements) {
		for(JComponent element : elements) {
			element.setFont(font);
		}
	}
	
	public static void gridLayoutFill(JComponent gridElement, int rows, int columns) {
		int areas = rows * columns;
		for(int i = 0; i < areas; i++) {
			gridElement.add(new TransparentPanel());
		}
	}

}
