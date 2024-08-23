package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PlayerSetupScreen extends JPanel {

    private JLabel title;
    protected JButton startButton;
    protected JButton backButton;
    
    PlayerNameInput playerNameInput;

    
    public PlayerSetupScreen() {

        this.setLayout(new GridLayout(3, 3));
        DartsGUI.gridLayoutFill(this, 3, 3);
        title = new JLabel("Player Setup");
        title.setFont(DartsGUI.FONT_TITLE);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // Panel für den Titel
        JComponent[] titleBarElements = {title, new TransparentPanel()};
        Bar titleBar = new Bar(titleBarElements);
        titleBar.barPlacement(this, 1);

        // Erstellen der Buttons
        startButton = new JButton("Weiter");
        backButton = new JButton("Zurück");
        JButton[] setupButtons = {backButton, startButton};
        DartsGUI.fontAdjust(DartsGUI.FONT_BIG, setupButtons);
        Line startBreakLine = new Line(setupButtons);
        JComponent[] startBreakBarElements = {new TransparentPanel(), new TransparentPanel(), new TransparentPanel(), startBreakLine};
        Bar startBreakBar = new Bar(startBreakBarElements);
        startBreakBar.barPlacement(this, 7);;
        
       playerNameInput = new PlayerNameInput();
       
       this.remove(4);
       this.add(playerNameInput, 4); //Spieler-Label und Combo Boxen
    }
    
}
