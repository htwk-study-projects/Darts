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

	 private Line gameNameLine;
	 private JTextField gameNameText;
	 private JLabel gameNameLabel;
	 
	 private Line player1Line;
	 private JLabel player1Name;
	 private JTextField player1NameField;
	 protected JComboBox<ColorIcon> comboBox1;
	 
	 private Line player2Line;
	 private JLabel player2Name;
	 private JTextField player2NameField;
	 protected JComboBox<ColorIcon> comboBox2;
	 
	 private Line player3Line;
	 private JLabel player3Name;
	 private JTextField player3NameField;
	 protected JComboBox<ColorIcon> comboBox3;
	 
	 private Line player4Line;
	 private JLabel player4Name;
	 private JTextField player4NameField;
	 protected JComboBox<ColorIcon> comboBox4;
	 
	 private Bar playerNameInputBar;
	
	public PlayerNameInput(){

	    gameNameLabel = new JLabel("Spielname:");
	    gameNameText = new JTextField(16);
	    JComponent[] gameNameLineElements = {gameNameLabel, gameNameText};
	    gameNameLine = new Line(gameNameLineElements);
	    
	    player1Name = new JLabel("Spieler 1:");
	    player1NameField = new JTextField(10);
		comboBox1 = new JComboBox<>(OPTIONS);
		JComponent[] glayer1LineElements = {player1Name, player1NameField, comboBox1};
		player1Line = new Line(glayer1LineElements);
		
		player2Name = new JLabel("Spieler 2:");
	    player2NameField = new JTextField(10);
		comboBox2 = new JComboBox<>(OPTIONS);
		JComponent[] player2LineElements = {player2Name, player2NameField, comboBox2};
		player2Line = new Line(player2LineElements);
	    
		player3Name = new JLabel("Spieler 3:");
	    player3NameField = new JTextField(10);
		comboBox3 = new JComboBox<>(OPTIONS);
		JComponent[] player3LineElements = {player3Name, player3NameField, comboBox3};
		player3Line = new Line(player3LineElements );
	    
		player4Name = new JLabel("Spieler 4:");
	    player4NameField = new JTextField(10);
		comboBox4 = new JComboBox<>(OPTIONS);
		JComponent[] player4LineElements = {player4Name, player4NameField, comboBox4};
		player4Line = new Line(player4LineElements);
		
	    JComponent[] Labels = {gameNameLabel, player1Name, player2Name, player3Name, player4Name};
	    DartsGUI.fontAdjust(DartsGUI.FONT_BIG, Labels);
	    
	    JComponent[] playerNameInputBarElements = {gameNameLine, player1Line, player2Line, player3Line, player4Line};
	    for (JComponent component : playerNameInputBarElements) {
			component.setOpaque(false);	
		}
	    playerNameInputBar = new Bar(playerNameInputBarElements);
	    playerNameInputBar.setBackground(DartsGUI.BACKGROUND_COLOR);
	    this.add(playerNameInputBar);	    
	}

}
