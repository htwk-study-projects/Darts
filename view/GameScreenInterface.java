package view;

import javax.swing.JRootPane;

public interface GameScreenInterface {
	GameScreenSideBar getGameScreenSideBar();
	DartArrowGraphic getDartArrow();
	DartBoardGraphic getBoard();
	JRootPane getRootPane();
}
