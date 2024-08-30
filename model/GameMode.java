package model;

import java.util.HashMap;
import java.util.Map;

public class GameMode {
	
	protected static final int STRAIGHT_IN_OUT = 0;
	protected static final int DOUBLE_IN_OUT = 2;
	protected static final int TRIPLE_IN_OUT = 3;
	private static final Map<String, Integer> IN_OUT_MODES = new HashMap<>();
	
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
		}
	}
	
	@Override
	public String toString() {
		return "GameMode [gamePoints=" + gamePoints + ", inMode=" + inMode + ", outMode=" + outMode + "]";
	}

	public GameMode(int selectedPoints, String inMode, String outMode) {
		this.gamePoints = selectedPoints;
		this.inMode = IN_OUT_MODES.get(inMode.toLowerCase());
		this.outMode = IN_OUT_MODES.get(outMode.toLowerCase());
	}
	
	public int getGamePoints() {
		return this.gamePoints;
	}
	
	public boolean isGameInModeConditionFulfilled(int hitMultiplier) {
		switch(inMode) {
			case STRAIGHT_IN_OUT: return true;
			case DOUBLE_IN_OUT: return DOUBLE_IN_OUT == hitMultiplier;
			case TRIPLE_IN_OUT: return TRIPLE_IN_OUT == hitMultiplier;
			default: return false;
		}
	}
	
	public boolean isGameOutModeConditionFulfilled(int hitMultiplier) {
		switch(outMode) {
			case STRAIGHT_IN_OUT: return true;
			case DOUBLE_IN_OUT: return DOUBLE_IN_OUT == hitMultiplier;
			case TRIPLE_IN_OUT: return TRIPLE_IN_OUT == hitMultiplier;
			default: return false;
		}
	}
	
	//problematisch, punkte werden auch bei nicht erfüllterm outMode abgezogen wenn es genau auf 0 geht
	public boolean arePointValidForOutMode(int currentPlayerPoints, int currentThrowPoints, boolean statusOutMode) {
		if(currentPlayerPoints - currentThrowPoints >= outMode || (currentPlayerPoints - currentThrowPoints == 0 && statusOutMode) ){
			return true;
		}
		return false;
	}
}
