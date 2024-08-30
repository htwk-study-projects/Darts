package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class DartsGUI extends JFrame implements DartsGUIInterface{
	
	/**
	 * The CardLayout used for managing the layout of different screens in the application.
	 */
	private CardLayout cardLayout;
	
	protected final static Font FONT_TITLE = new Font("Impact", Font.BOLD, 60);
	protected final static Font FONT_BIG = new Font("Impact", Font.BOLD, 22);
	protected final static Font FONT_NORMAL = new Font("Impact", Font.PLAIN, 16);
	protected final static Font FONT_SMALL = new Font("Impact", Font.PLAIN, 13);
	protected static final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;
	
	private HomeScreen homeScreen;
	private SetupScreen setupScreen;
	private PlayerSetupScreen playerSetupScreen;
	private GameScreen gameScreen;
	private DebugScreen debugScreen;

	
	public DartsGUI(){
		
		this.cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		this.setTitle("DARTS");	
		this.setSize(1400, 920);
		
		this.setMinimumSize(new Dimension(1400, 920));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.homeScreen = new HomeScreen();
		this.add(homeScreen, "home");
		
		this.setupScreen = new SetupScreen();
		this.add(setupScreen, "setup");
		
		this.playerSetupScreen = new PlayerSetupScreen();
		this.add(playerSetupScreen, "player");
		
		this.gameScreen = new GameScreen();
		this.add(gameScreen, "game");
		
		
		this.debugScreen = new DebugScreen();
		this.add (debugScreen, "debug");
		
		homeScreen.exitButton.addActionListener(e -> System.exit(0));

		setupScreen.backButton.addActionListener(e -> cardLayout.show(this.getContentPane(), "home"));
			
		playerSetupScreen.backButton.addActionListener(e ->cardLayout.show(this.getContentPane(), "setup"));
		
		gameScreen.backButton.addActionListener(e ->cardLayout.show(this.getContentPane(), "home"));
		
		debugScreen.backButton.addActionListener(e ->cardLayout.show(this.getContentPane(), "home"));
		
		
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

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public HomeScreen getHomeScreen() {
		return homeScreen;
	}

	public SetupScreen getSetupScreen() {
		return setupScreen;
	}

	public PlayerSetupScreen getPlayerSetupScreen() {
		return playerSetupScreen;
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public DebugScreen getDebugScreen() {
		return debugScreen;
	}
}
