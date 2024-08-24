package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PlayerSetupScreen extends JPanel {

    private JLabel title;
    private Bar titleBar;
    
    private Line startBreakLine;
    private Bar startBreakBar;
    protected JButton startButton;
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
        titleBar.barPlacementInGridLayout(this, 1);

        // Erstellen der Buttons
        startButton = new JButton("Weiter");
        backButton = new JButton("Zurück");
        JButton[] setupButtons = {backButton, startButton};
        DartsGUI.fontAdjust(DartsGUI.FONT_BIG, setupButtons);
        startBreakLine = new Line(setupButtons);
        startBreakLine.setOpaque(false);
        JComponent[] startBreakBarElements = {new TransparentPanel(), new TransparentPanel(), new TransparentPanel(), startBreakLine};
        startBreakBar = new Bar(startBreakBarElements);
        startBreakBar.setBackground(DartsGUI.BACKGROUND_COLOR);
        startBreakBar.barPlacementInGridLayout(this, 7);;
        
       playerNameInput = new PlayerNameInput();
       playerNameInput.setBackground(DartsGUI.BACKGROUND_COLOR);
       
       this.remove(4);
       this.add(playerNameInput, 4); //Spieler-Label und Combo Boxen
    }
    
}
