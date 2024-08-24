package view;

import javax.swing.JButton;
import javax.swing.JRootPane;

public interface PlayerSetupScreenInterface {
	
    JButton getPlayButton();
    PlayerNameInput getPlayerNameInput();
	JRootPane getRootPane();
	void repaint();
}
