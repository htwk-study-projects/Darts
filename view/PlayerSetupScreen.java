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
    protected JButton homeButton;
    protected JComboBox<ColorIcon> comboBox1;
    protected JComboBox<ColorIcon> comboBox2;
    protected JComboBox<ColorIcon> comboBox3;
    protected JComboBox<ColorIcon> comboBox4;
    
    //die JTextField auch noch mit hier hoch
    
    private ColorIcon yellow = new ColorIcon(new Color(254,198,0));
    private ColorIcon red = new ColorIcon(new Color(201,17,0));
    private ColorIcon orange = new ColorIcon(new Color(252,108,0));
    private ColorIcon violett = new ColorIcon(new Color(148,36,149));
    private ColorIcon pink = new ColorIcon(new Color(194,43,106));
    private ColorIcon blue = new ColorIcon(new Color(26,47,172));
    private ColorIcon lightblue = new ColorIcon(new Color(0,136,195));
    private ColorIcon green = new ColorIcon(new Color(0,135,60));
    private ColorIcon lightgreen = new ColorIcon(new Color(40,154,2));
    private ColorIcon black = new ColorIcon(Color.black);
    private ColorIcon grey = new ColorIcon(new Color(130,134,137));

    
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
        homeButton = new JButton("Zurück");
        JButton[] setupButtons = {homeButton, startButton};
        DartsGUI.fontAdjust(DartsGUI.FONT_BIG, setupButtons);
        Line startBreakLine = new Line(setupButtons);

        
        
        // Panel für die Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 1)); // GridLayout für die Buttons
        JComponent[] startBreakBarElements = {new TransparentPanel(), new TransparentPanel(), new TransparentPanel(), startBreakLine};
        Bar startBreakBar = new Bar(startBreakBarElements);
        buttonPanel.add(startBreakBar);
     

        // Panel für das Textfeld
        JPanel gridBagPanel = new JPanel();
        gridBagPanel.setLayout(new GridBagLayout());

        JTextField gameNameText = new JTextField(16);
        JLabel gameNameLable = new JLabel("Spielname:");

        JLabel playerNameLable = new JLabel("Spieler:");
        JLabel player1Name = new JLabel("Spieler 1:");
        JTextField player1NameField = new JTextField(10);

        JLabel player2Name = new JLabel("Spieler 2:");
        JTextField player2NameField = new JTextField(10);

        JLabel player3Name = new JLabel("Spieler 3:");
        JTextField player3NameField = new JTextField(10);

        JLabel player4Name = new JLabel("Spieler 4:");
        JTextField player4NameField = new JTextField(10);
        
        JComponent[] LabelPlayer = {gameNameLable, playerNameLable, player1Name, player2Name, player3Name, player4Name};
        DartsGUI.fontAdjust(DartsGUI.FONT_BIG, LabelPlayer);

        // Erstellen von GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Abstand zwischen den Komponenten
        
        
        //Combo Box
        
        ColorIcon[] options = {yellow,red,orange,violett,pink,blue,lightblue,green,lightgreen,black,grey};
        comboBox1 = new JComboBox<>(options);
        comboBox2 = new JComboBox<>(options);
        comboBox3 = new JComboBox<>(options);
        comboBox4 = new JComboBox<>(options);
        
        
        
        // Zeile 0: Spieler Label
        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gridBagPanel.add(playerNameLable, gbc);

        // Zeile 1: Spielname Label und Textfeld
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gridBagPanel.add(gameNameLable, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gridBagPanel.add(gameNameText, gbc);

        // Zeile 2: Spieler 1 Label und Textfeld
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gridBagPanel.add(player1Name, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gridBagPanel.add(player1NameField, gbc);
        
        gbc.gridx = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gridBagPanel.add(comboBox1, gbc);

        // Zeile 3: Spieler 2 Label und Textfeld
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gridBagPanel.add(player2Name, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gridBagPanel.add(player2NameField, gbc);
        
        gbc.gridx = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gridBagPanel.add(comboBox2, gbc);

        // Zeile 4: Spieler 3 Label und Textfeld
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gridBagPanel.add(player3Name, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gridBagPanel.add(player3NameField, gbc);
        
        gbc.gridx = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gridBagPanel.add(comboBox3, gbc);

        // Zeile 5: Spieler 4 Label und Textfeld
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        gridBagPanel.add(player4Name, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gridBagPanel.add(player4NameField, gbc);
       
        gbc.gridx = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gridBagPanel.add(comboBox4, gbc);

        // Füge die Panels in das Hauptpanel ein
        this.add(titlePanel); // Titel-Panel in der mittleren Spalte, erste Zeile
        this.add(gridBagPanel); // GridBagPanel in der mittleren Spalte, zweite Zeile
        this.add(buttonPanel); // Button-Panel in der mittleren Spalte, dritte Zeile
    }
    
}
