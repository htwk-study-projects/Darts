package view;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public interface PlayerNameInputInterface {
	JTextField[] getNameInputs();
	JComboBox<ColorIcon>[] getColorInputs();
	JTextField getGameNameField();
	public void setChoosenPlayers(int selectedPlayerCount);
}
