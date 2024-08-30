package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PlayerSetupScreen extends JPanel implements PlayerSetupScreenInterface{

    private JLabel title;
    private Bar titleBar;
    
    private Line startBreakLine;
    private Bar startBreakBar;
    protected JButton playButton;
    protected JButton backButton;
    
    private PlayerNameInput playerNameInput;

    
    public PlayerSetupScreen() {

        this.setLayout(new GridLayout(3, 3));
        DartsGUI.gridLayoutFill(this, 3, 3);
        
        title = new JLabel("Player Setup");
        title.setFont(DartsGUI.FONT_TITLE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        JComponent[] titleBarElements = {title, new TransparentPanel()};
        titleBar = new Bar(titleBarElements);
        titleBar.setBackground(DartsGUI.BACKGROUND_COLOR);
        
        playerNameInput = new PlayerNameInput();
        playerNameInput.setBackground(DartsGUI.BACKGROUND_COLOR);
        
        playButton = new JButton("Weiter");
        backButton = new JButton("zum Game Setup");
        JButton[] setupButtons = {backButton, playButton};
        DartsGUI.fontAdjust(DartsGUI.FONT_BIG, setupButtons);
        startBreakLine = new Line(setupButtons);
        startBreakLine.setOpaque(false);
        JComponent[] startBreakBarElements = {new TransparentPanel(), new TransparentPanel(), new TransparentPanel(), startBreakLine};
        startBreakBar = new Bar(startBreakBarElements);
        startBreakBar.setBackground(DartsGUI.BACKGROUND_COLOR);
        
        titleBar.barPlacementInGridLayout(this, 1);
        this.remove(4);
        this.add(playerNameInput, 4);
        startBreakBar.barPlacementInGridLayout(this, 7);
    }


	@Override
	public JButton getPlayButton() {
		return playButton;
	}


	@Override
	public PlayerNameInput getPlayerNameInput() {
		return playerNameInput;
	}
    
}
