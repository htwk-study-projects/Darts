package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerNameInput extends JPanel {
	 
	 private static final ColorIcon YELLOW = new ColorIcon(new Color(254,198,0));
	 private static final ColorIcon RED = new ColorIcon(new Color(201,17,0));
	 private static final ColorIcon ORANGE = new ColorIcon(new Color(252,108,0));
	 private static final ColorIcon VIOLETT = new ColorIcon(new Color(148,36,149));
	 private static final ColorIcon PINK = new ColorIcon(new Color(194,43,106));
	 private static final ColorIcon BLUE = new ColorIcon(new Color(26,47,172));
	 private static final ColorIcon LIGHTBLUE = new ColorIcon(new Color(0,136,195));
	 private static final ColorIcon GREEN = new ColorIcon(new Color(0,135,60));
	 private static final ColorIcon LIGHTGREEN = new ColorIcon(new Color(40,154,2));
	 private static final ColorIcon BLACK = new ColorIcon(Color.black);
	 private static final ColorIcon GREY = new ColorIcon(new Color(130,134,137));
	 
	 private static final ColorIcon[] OPTIONS = {YELLOW,RED,ORANGE,VIOLETT,PINK,BLUE,LIGHTBLUE,GREEN,LIGHTGREEN,BLACK,GREY};

	 private JTextField gameNameText;
	 private JLabel gameNameLabel;
	 
<<<<<<< HEAD
	 private JLabel playerNameLable;
=======
	 private JLabel playerNameLabel;
>>>>>>> 800b60b42782fe9cbd200b7332caaff7459dd532
	 
	 private JLabel player1Name;
	 private JTextField player1NameField;
	 protected JComboBox<ColorIcon> comboBox1;
	 
	 private JLabel player2Name;
	 private JTextField player2NameField;
	 protected JComboBox<ColorIcon> comboBox2;
	 
	 private JLabel player3Name;
	 private JTextField player3NameField;
	 protected JComboBox<ColorIcon> comboBox3;
	 
	 private JLabel player4Name;
	 private JTextField player4NameField;
	 protected JComboBox<ColorIcon> comboBox4;
	 
	 private GridBagConstraints gbc = new GridBagConstraints();
	
	public PlayerNameInput(){
	    this.setLayout(new GridBagLayout());

	    gameNameLabel = new JLabel("Spielname:");
	    gameNameText = new JTextField(16);
	    JComponent[] gameNameLineElements = {gameNameLabel, gameNameText};
	    Line gameNameLine = new Line(gameNameLineElements );
	    
	    playerNameLabel = new JLabel("Spieler:");
	    
	    player1Name = new JLabel("Spieler 1:");
	    player1NameField = new JTextField(10);
		comboBox1 = new JComboBox<>(OPTIONS);

	    player2Name = new JLabel("Spieler 2:");
	    player2NameField = new JTextField(10);
	    comboBox2 = new JComboBox<>(OPTIONS);
	    
	    player3Name = new JLabel("Spieler 3:");
	    player3NameField = new JTextField(10);
	    comboBox3 = new JComboBox<>(OPTIONS);
	    
	    player4Name = new JLabel("Spieler 4:");
	    player4NameField = new JTextField(10);
	    comboBox4 = new JComboBox<>(OPTIONS);
	    
	    JComponent[] LabelPlayer = {gameNameLabel, playerNameLabel, player1Name, player2Name, player3Name, player4Name};
	    DartsGUI.fontAdjust(DartsGUI.FONT_BIG, LabelPlayer);

	    gbc.insets = new Insets(5, 5, 5, 5); // Abstand zwischen den Komponenten
	    
	    // Zeile 0: Spieler Label
	    gbc.gridy = 1;
	    gbc.gridx = 1;
	    gbc.gridwidth = 1;
	    gbc.anchor = GridBagConstraints.WEST;
	    this.add(playerNameLabel, gbc);

	    // Zeile 1: Spielname Label und Textfeld
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.anchor = GridBagConstraints.WEST;
	    this.add(gameNameLabel, gbc);

	    gbc.gridx = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(gameNameText, gbc);

	    // Zeile 2: Spieler 1 Label und Textfeld
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.fill = GridBagConstraints.NONE;
	    this.add(player1Name, gbc);

	    gbc.gridx = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(player1NameField, gbc);
	    
	    gbc.gridx = 2;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(comboBox1, gbc);

	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    gbc.fill = GridBagConstraints.NONE;
	    this.add(player2Name, gbc);

	    gbc.gridx = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(player2NameField, gbc);
	    
	    gbc.gridx = 2;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(comboBox2, gbc);

	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.fill = GridBagConstraints.NONE;
	    this.add(player3Name, gbc);

	    gbc.gridx = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(player3NameField, gbc);
	    
	    gbc.gridx = 2;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(comboBox3, gbc);

	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    gbc.fill = GridBagConstraints.NONE;
	    this.add(player4Name, gbc);

	    gbc.gridx = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(player4NameField, gbc);
	   
	    gbc.gridx = 2;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    this.add(comboBox4, gbc);
	    
	}

}
