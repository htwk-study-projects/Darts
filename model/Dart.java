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
	
	static public Dart[] createDart(int number) {
		Dart[] darts = new Dart[number];
		for(int i = 0; i < number; i++) {
			darts[i] = new Dart();
		}
		return darts;
	}
	
	public void setThrowParameter(double[] tp) {
		this.throwParameter = tp.clone();
	}
}
