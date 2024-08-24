package view;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public interface PlayerNameInputInterface {
	JTextField[] getNameInputs();
	JComboBox<ColorIcon>[] getColorInputs();
	public void setChoosenPlayers(int selectedPlayerCount);
}
