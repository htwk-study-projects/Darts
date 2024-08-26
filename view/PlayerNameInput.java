package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerNameInput extends JPanel implements PlayerNameInputInterface{
	 
	 private static final ColorIcon YELLOW = new ColorIcon(new Color(254,198,0));
	 private static final ColorIcon RED = new ColorIcon(new Color(158,3,3));
	 private static final ColorIcon ORANGE = new ColorIcon(new Color(252,108,0));
	 private static final ColorIcon VIOLETT = new ColorIcon(new Color(148,36,149));
	 private static final ColorIcon PINK = new ColorIcon(new Color(194,43,106));
	 private static final ColorIcon BLUE = new ColorIcon(new Color(26,47,172));
	 private static final ColorIcon LIGHTBLUE = new ColorIcon(new Color(0,136,195));
	 private static final ColorIcon GREEN = new ColorIcon(new Color(0,135,60));
	 private static final ColorIcon LIGHTGREEN = new ColorIcon(new Color(40,154,2));
	 private static final ColorIcon BLACK = new ColorIcon(new Color(64,64,64));
	 private static final ColorIcon GREY = new ColorIcon(new Color(130,134,137));
	 
	 private static final ColorIcon[] OPTIONS = {YELLOW,RED,ORANGE,VIOLETT,PINK,BLUE,LIGHTBLUE,GREEN,LIGHTGREEN,BLACK,GREY};

	 private Line gameNameLine;
	 private JTextField gameNameField;
	 private JLabel gameNameLabel;
	 
	 private Line player1Line;
	 private JLabel player1Label;
	 private JTextField player1NameField;
	 private JComboBox<ColorIcon> comboBox1;
	 
	 private Line player2Line;
	 private JLabel player2Label;
	 private JTextField player2NameField;
	 private JComboBox<ColorIcon> comboBox2;
	 
	 private Line player3Line;
	 private JLabel player3Label;
	 private JTextField player3NameField;
	 private JComboBox<ColorIcon> comboBox3;
	 
	 private Line player4Line;
	 private JLabel player4Label;
	 private JTextField player4NameField;
	 private JComboBox<ColorIcon> comboBox4;
	 
	 private Bar playerNameInputBar;
	 private JComponent[] playerNameInputBarElements;
	 private int choosenPlayers = 4;
	
	public PlayerNameInput(){

	    gameNameLabel = new JLabel("Spielname:");
	    gameNameField = new JTextField(16);
	    JComponent[] gameNameLineElements = {gameNameLabel, gameNameField};
	    gameNameLine = new Line(gameNameLineElements);
	    
	    player1Label = new JLabel("Spieler 1:");
	    player1NameField = new JTextField(10);
		comboBox1 = new JComboBox<>(OPTIONS);
		JComponent[] glayer1LineElements = {player1Label, player1NameField, comboBox1};
		player1Line = new Line(glayer1LineElements);
		
		player2Label = new JLabel("Spieler 2:");
	    player2NameField = new JTextField(10);
		comboBox2 = new JComboBox<>(OPTIONS);
		JComponent[] player2LineElements = {player2Label, player2NameField, comboBox2};
		player2Line = new Line(player2LineElements);
	    
		player3Label = new JLabel("Spieler 3:");
	    player3NameField = new JTextField(10);
		comboBox3 = new JComboBox<>(OPTIONS);
		JComponent[] player3LineElements = {player3Label, player3NameField, comboBox3};
		player3Line = new Line(player3LineElements );
	    
		player4Label = new JLabel("Spieler 4:");
	    player4NameField = new JTextField(10);
		comboBox4 = new JComboBox<>(OPTIONS);
		JComponent[] player4LineElements = {player4Label, player4NameField, comboBox4};
		player4Line = new Line(player4LineElements);
		
	    JComponent[] Labels = {gameNameLabel, player1Label, player2Label, player3Label, player4Label};
	    DartsGUI.fontAdjust(DartsGUI.FONT_BIG, Labels);
	    
	    
	    
	    adjustplayerNameInputBarElements();
	    for(JComponent component : playerNameInputBarElements) {
			component.setOpaque(false);	
		}
	    playerNameInputBar = new Bar(playerNameInputBarElements);
	    playerNameInputBar.setBackground(DartsGUI.BACKGROUND_COLOR);
	    this.add(playerNameInputBar);	    
	}
	
	@Override
	public JTextField[] getNameInputs() {
		return new JTextField[] {player1NameField, player2NameField, player3NameField, player4NameField};
	}
	
	@Override
	public JComboBox<ColorIcon>[] getColorInputs() {
		List<JComboBox<ColorIcon>> colorInput = Arrays.asList(comboBox1, comboBox2, comboBox3, comboBox4);
	    @SuppressWarnings("unchecked")
	    JComboBox<ColorIcon>[] colorInputArray = colorInput.toArray(new JComboBox[0]);
	    return colorInputArray;
	}
	
	public void setChoosenPlayers(int selectedPlayerCount) {
		this.choosenPlayers = selectedPlayerCount;
		adjustplayerNameInputBarElements();
		playerNameInputBar.setComponents(playerNameInputBarElements);
        this.revalidate();
        this.repaint();
	}
	
	private void adjustplayerNameInputBarElements() {
		JComponent[] player = {player1Line, player2Line, player3Line, player4Line};
		playerNameInputBarElements = new JComponent[5];
		playerNameInputBarElements[0] = gameNameLine;
		for(int i = 1; i <= choosenPlayers; i++) {
			playerNameInputBarElements[i] = player[i-1];
		}
		for(int j = choosenPlayers+1; j < playerNameInputBarElements.length; j++) {
			playerNameInputBarElements[j] = new TransparentPanel();
		}
	}

	@Override
	public JTextField getGameNameField() {
		return gameNameField;
	}
	
	
}
