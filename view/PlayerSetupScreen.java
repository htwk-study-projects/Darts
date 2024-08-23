package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PlayerSetupScreen extends JPanel {

    private JLabel title;
    protected JButton startButton;
    protected JButton backButton;
 
    
    
    PlayerNameInput playerNameInput;

    
    public PlayerSetupScreen() {
    	
    	Color lightGray = Color.LIGHT_GRAY;

        // Setze das Layout des Hauptpanels
        this.setLayout(new GridLayout(3, 3));

        // Erstellen und Konfigurieren des Titel-Labels
        title = new JLabel("Player Setup");
        title.setFont(DartsGUI.FONT_TITLE);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // Panel für den Titel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1, 1));
        JComponent[] titleBarElements = {title, new TransparentPanel()};
        Bar titleBar = new Bar(titleBarElements);
        titlePanel.add(titleBar);

        // Erstellen der Buttons
        startButton = new JButton("Weiter");
        backButton = new JButton("Zurück");
        JButton[] setupButtons = {backButton, startButton};
        DartsGUI.fontAdjust(DartsGUI.FONT_BIG, setupButtons);
        Line startBreakLine = new Line(setupButtons);

        
        
        // Panel für die Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 1)); // GridLayout für die Buttons
        JComponent[] startBreakBarElements = {new TransparentPanel(), new TransparentPanel(), new TransparentPanel(), startBreakLine};
        Bar startBreakBar = new Bar(startBreakBarElements);
        buttonPanel.add(startBreakBar);
        
   
       playerNameInput = new PlayerNameInput();
     

        

        // Füge die Panels in das Hauptpanel ein
        this.add(titlePanel); // Titel-Panel in der mittleren Spalte, erste Zeile
        this.add(playerNameInput); //Spieler-Label und Combo Boxen
        this.add(buttonPanel); // Button-Panel in der mittleren Spalte, dritte Zeile
    }
    
}
