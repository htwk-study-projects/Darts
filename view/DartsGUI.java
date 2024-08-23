package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class DartsGUI extends JFrame {
	
	private CardLayout cardLayout;  // Instanzvariable für CardLayout
	
	protected final static Font FONT_TITLE = new Font("Impact", Font.BOLD, 60);
	protected final static Font FONT_BIG = new Font("Impact", Font.BOLD, 22);
	protected final static Font FONT_NORMAL = new Font("Impact", Font.PLAIN, 16);
	protected final static Font FONT_SMALL = new Font("Impact", Font.PLAIN, 10);
	
	
	private HomeScreen homeScreen;
	private SetupScreen setupScreen;
	private PlayerSetupScreen setPlayerScreen;
	private GameScreen gameScreen;
	private DartArrowGraphic dartarrow;
	
	public DartsGUI(){
		
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		this.setTitle("DARTS");	
		this.setSize(1400, 920);
		/*
		this.setMinimumSize(new Dimension(1400, 920));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);*/
		
		dartarrow = new DartArrowGraphic();
		this.add(dartarrow,"arrow");
		
		homeScreen = new HomeScreen();
		this.add(homeScreen, "home");
		
		setupScreen = new SetupScreen();
		this.add(setupScreen, "setup");
		
		setPlayerScreen = new PlayerSetupScreen();
		this.add(setPlayerScreen, "player");
		
		gameScreen = new GameScreen();
		this.add(gameScreen, "game");
		
		homeScreen.playButton.addActionListener(e -> cardLayout.show(this.getContentPane(), "setup"));
		homeScreen.exitButton.addActionListener(e -> System.exit(0));
		
		setupScreen.backButton.addActionListener(e -> cardLayout.show(this.getContentPane(), "home"));
		setupScreen.startButton.addActionListener(e -> cardLayout.show(this.getContentPane(), "player"));
		
		setPlayerScreen.backButton.addActionListener(e ->cardLayout.show(this.getContentPane(), "setup"));
		setPlayerScreen.startButton.addActionListener(e ->cardLayout.show(this.getContentPane(), "game"));
		
		gameScreen.saveButton.addActionListener(e ->cardLayout.show(this.getContentPane(), "home"));
		gameScreen.backButton.addActionListener(e ->cardLayout.show(this.getContentPane(), "home"));
		
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

	public PlayerSetupScreen getSetPlayerScreen() {
		return setPlayerScreen;
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

}
