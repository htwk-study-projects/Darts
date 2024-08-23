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
	
	 protected JComboBox<ColorIcon> comboBox1;
	 protected JComboBox<ColorIcon> comboBox2;
	 protected JComboBox<ColorIcon> comboBox3;
	 protected JComboBox<ColorIcon> comboBox4;
	 
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
	 
	 ColorIcon[] options = {yellow,red,orange,violett,pink,blue,lightblue,green,lightgreen,black,grey};
	 
	 private JTextField gameNameText;
	 private JLabel gameNameLable;
	 
	 private JLabel playerNameLable;
	 
	 private JLabel player1Name;
	 private JTextField player1NameField;
	 
	 private JLabel player2Name;
	 private JTextField player2NameField;
	 
	 private JLabel player3Name;
	 private JTextField player3NameField;
	 
	 private JLabel player4Name;
	 private JTextField player4NameField;
	 
	 GridBagConstraints gbc = new GridBagConstraints();
	
	public PlayerNameInput(){
		
		comboBox1 = new JComboBox<>(options);
	    comboBox2 = new JComboBox<>(options);
	    comboBox3 = new JComboBox<>(options);
	    comboBox4 = new JComboBox<>(options);
		
	    this.setLayout(new GridBagLayout());

	    gameNameText = new JTextField(16);
	    gameNameLable = new JLabel("Spielname:");

	    playerNameLable = new JLabel("Spieler:");
	    
	    player1Name = new JLabel("Spieler 1:");
	    player1NameField = new JTextField(10);

	    player2Name = new JLabel("Spieler 2:");
	    player2NameField = new JTextField(10);

	    player3Name = new JLabel("Spieler 3:");
	    player3NameField = new JTextField(10);

	    player4Name = new JLabel("Spieler 4:");
	    player4NameField = new JTextField(10);
	    
	    JComponent[] LabelPlayer = {gameNameLable, playerNameLable, player1Name, player2Name, player3Name, player4Name};
	    DartsGUI.fontAdjust(DartsGUI.FONT_BIG, LabelPlayer);

	    gbc.insets = new Insets(5, 5, 5, 5); // Abstand zwischen den Komponenten
	    
	    // Zeile 0: Spieler Label
	    gbc.gridy = 1;
	    gbc.gridx = 1;
	    gbc.gridwidth = 1;
	    gbc.anchor = GridBagConstraints.WEST;
	    this.add(playerNameLable, gbc);

	    // Zeile 1: Spielname Label und Textfeld
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.anchor = GridBagConstraints.WEST;
	    this.add(gameNameLable, gbc);

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
