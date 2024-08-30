package view;

import java.awt.CardLayout;
import java.awt.Container;


public interface DartsGUIInterface {
	Container getContentPane();
	
	CardLayout getCardLayout();
	HomeScreen getHomeScreen();
	SetupScreen getSetupScreen();
	PlayerSetupScreen getPlayerSetupScreen();
	GameScreen getGameScreen();
	DebugScreen getDebugScreen();

	void setVisible(boolean b);
	
}
