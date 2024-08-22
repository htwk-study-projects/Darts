package model;

import java.awt.Color;

public class Dart {
	private final static Color DART_COLOR= Color.black;
	
	private double[] throwParameter = new double[3];
	private Throw dartThrow;
	private Integer points;
	
	private Dart() {
		this.throwParameter = null;
		this.dartThrow = null;
		this.points = null;
	}
	
	public static Dart[] createDart(int number) {
		Dart[] darts = new Dart[number];
		for(int i = 0; i < number; i++) {
			darts[i] = new Dart();
		}
		return darts;
	}
	
	public void setThrowParameter(double[] tp) {
		this.throwParameter = tp.clone();
	}
	
	public Integer getPoints() {
		return points;
	}
	
	public void throwDart() {
		dartThrow = new Throw(throwParameter[0],throwParameter[1],throwParameter[2]);
		double distance = dartThrow.computeDistanceToDartBoardCenter();
		int angle = dartThrow.computeAngleOnDartBoard();
		points = DartboardMathModel.determinePoints(angle, distance);
	}


}
