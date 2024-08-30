package model;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code GameMode} class defines and manages the game modes for a darts game,
 * including the rules for scoring and ending the game.
 */
public class GameMode {
	
	private static final int STRAIGHT_IN_OUT = 0;
	private static final int DOUBLE_IN_OUT = 2;
	private static final int TRIPLE_IN_OUT = 3;
	private static final Map<String, Integer> IN_OUT_MODES = new HashMap<>();
	private static final Map<Integer, String> MODE_NAMES = new HashMap<>();
	
	private int gamePoints;
	private int inMode;
	private int outMode;
	
	static {
		initInOutModes();
	}
	
	private static void initInOutModes() {
		String[] modeNames = {"straight", "double", "triple"};
		int[] modeNumbers = {STRAIGHT_IN_OUT, DOUBLE_IN_OUT, TRIPLE_IN_OUT};
		for(int i = 0; i < modeNames.length; i++) {
			IN_OUT_MODES.put(modeNames[i], modeNumbers[i]);
			MODE_NAMES.put(modeNumbers[i], modeNames[i]);
		}
	}
	
	@Override
	public String toString() {
		return " mit In Mode: " + MODE_NAMES.get(inMode) + ", Out Mode: " + MODE_NAMES.get(outMode);
	}

	/**
     * Constructs a {@code GameMode} with the specified game points and mode settings.
     * 
     * @param selectedPoints the total points required to win the game
     * @param inMode the mode required to start scoring (e.g., "straight", "double", "triple"), 
     * @param outMode the mode required to end scoring (e.g., "straight", "double", "triple")
     */
	public GameMode(int selectedPoints, String inMode, String outMode) {
		this.gamePoints = selectedPoints;
		this.inMode = IN_OUT_MODES.get(inMode.toLowerCase());
		this.outMode = IN_OUT_MODES.get(outMode.toLowerCase());
	}
	
	public int getGamePoints() {
		return this.gamePoints;
	}
	
	/**
     * Checks if the current hit multiplier satisfies the "in" mode condition.
     * 
     * @param hitMultiplier the multiplier of the current dart throw
     * @return {@code true} if the "in" mode condition is fulfilled, {@code false} otherwise
     */
	public boolean isGameInModeConditionFulfilled(int hitMultiplier) {
		switch(inMode) {
			case STRAIGHT_IN_OUT: return true;
			case DOUBLE_IN_OUT: return DOUBLE_IN_OUT == hitMultiplier || hitMultiplier == -1;
			case TRIPLE_IN_OUT: return TRIPLE_IN_OUT == hitMultiplier;
			default: return false;
		}
	}
	
	/**
     * Checks if the current hit multiplier satisfies the "out" mode condition.
     * 
     * @param hitMultiplier the multiplier of the current dart throw
     * @return {@code true} if the "out" mode condition is fulfilled, {@code false} otherwise
     */
	public boolean isGameOutModeConditionFulfilled(int hitMultiplier) {
		switch(outMode) {
			case STRAIGHT_IN_OUT: return true;
			case DOUBLE_IN_OUT: return DOUBLE_IN_OUT == hitMultiplier || hitMultiplier == -1;
			case TRIPLE_IN_OUT: return TRIPLE_IN_OUT == hitMultiplier;
			default: return false;
		}
	}
	
	/**
     * Determines if the points scored are valid for the "out" mode condition.
     * 
     * @param currentPlayerPoints the current points of the player
     * @param currentThrowPoints the points scored in the current throw
     * @param statusOutMode the status of the "out" mode condition
     * @return {@code true} if the points are valid for "out" mode, {@code false} otherwise
     */
	public boolean arePointValidForOutMode(int currentPlayerPoints, int currentThrowPoints, boolean statusOutMode) {
		return currentPlayerPoints - currentThrowPoints >= outMode || (currentPlayerPoints - currentThrowPoints == 0 && statusOutMode);			
	}	
}
