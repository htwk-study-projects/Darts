package view;


import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HomeScreen extends JPanel {

	private JLabel title;
	
	private Bar homeMenu;
	protected JButton playButton;
	protected JButton loadButton;
	protected JButton exitButton;
	
	public HomeScreen() {
		
		DartBoardGraphic dartBoardGraphic = new DartBoardGraphic();
		dartBoardGraphic.setOpaque(false); // Damit der Hintergrund transparent bleibt
		
		this.setLayout(new GridLayout(3,3));
		DartsGUI.gridLayoutFill(this, 3, 3);
		
		title = new JLabel("Darts");
		title.setFont(DartsGUI.FONT_TITLE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		this.remove(1);
		this.add(title, 1);
		
		playButton = new JButton("Spielen");
		loadButton = new JButton("Spiel laden");
		exitButton = new JButton("Beenden");
		
		JButton[] homeButtons = {playButton, loadButton, exitButton};
		DartsGUI.fontAdjust(DartsGUI.FONT_BIG, homeButtons);
		
		homeMenu = new Bar(homeButtons, 3, 1);
		homeMenu.barPlacement(this, 4);
		

	}
}
