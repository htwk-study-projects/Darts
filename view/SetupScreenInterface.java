package view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRootPane;

public interface SetupScreenInterface {
	ButtonGroup getPointsGroup();
    ButtonGroup getModeInGroup();
    ButtonGroup getModeOutGroup();
    ButtonGroup getPlayersGroup();
    JButton getStartButton();
	JRootPane getRootPane();
}
