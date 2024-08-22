package model;

import java.util.HashMap;
import java.util.Map;

public class GameMode {
	
	protected static final int STRAIGHT_IN_OUT = -2;
	protected static final int DOUBLE_IN_OUT = 2;
	protected static final int TRIPLE_IN_OUT = 3;
	
	private static final Map<String, Integer> IN_OUT_MODES = new HashMap<>();
	
	private int gamePoints;
	private int inMode;
	private int outMode;
	
	static {
		initInOutModes();
	}
	
	static private void initInOutModes() {
		String[] modeNames = {"straigth", "double", "triple"};
		int[] modeNumbers = {STRAIGHT_IN_OUT, DOUBLE_IN_OUT, TRIPLE_IN_OUT};
		for(int i = 0; i < modeNames.length; i++) {
			IN_OUT_MODES.put(modeNames[i], modeNumbers[i]);
		}
	}
	
	public GameMode(int selectedPoints, String inMode, String outMode) {
		this.gamePoints = selectedPoints;
		this.inMode = IN_OUT_MODES.get(inMode.toLowerCase());
		this.outMode = IN_OUT_MODES.get(outMode.toLowerCase());
	}
	
}
