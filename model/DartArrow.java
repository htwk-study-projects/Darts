package model;

import java.util.Arrays;

public class DartArrow {
	
	private double[] throwParameter = new double[3];
	private Throw dartThrow;
	private Integer points;
	private Integer multiplier;
	
	private DartArrow() {
		this.throwParameter = new double[3];
		this.dartThrow = null;
		this.points = 0;
		this.multiplier = null;
	}
	
	public static DartArrow[] createDart(int number) {
		DartArrow[] darts = new DartArrow[number];
		for(int i = 0; i < number; i++) {
			darts[i] = new DartArrow();
		}
		return darts;
	}	
	
	@Override
	public String toString() {
		return "DartArrow [throwParameter=" + Arrays.toString(throwParameter) + ", dartThrow=" + dartThrow + ", points="
				+ points + ", multiplier=" + multiplier + "]";
	}

	public void setThrowParameter(double[] tp) {
		this.throwParameter = tp.clone();
	}
	
	public Integer getPoints() {
		return points;
	}
	
	public Integer getMultiplier() {
		return multiplier;
	}
	
	public Throw getDartThrow() {
		return dartThrow;
	}
	
	public void throwDart() {
		dartThrow = new Throw(throwParameter[0],throwParameter[1],throwParameter[2]);
		double distance = dartThrow.computeDistanceToDartBoardCenter();
		int angle = dartThrow.computeAngleOnDartBoard();
		this.points = DartboardMathModel.determinePoints(angle, distance);
		this.multiplier = DartboardMathModel.determineMultiplier(distance);
	}
	
}
