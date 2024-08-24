package model;

public class DartArrow {
	
	private double[] throwParameter = new double[3];
	private Throw dartThrow;
	private Integer points;
	private Integer multiplier;
	
	private DartArrow() {
		this.throwParameter = null;
		this.dartThrow = null;
		this.points = null;
		this.multiplier = null;
	}
	
	public static DartArrow[] createDart(int number) {
		DartArrow[] darts = new DartArrow[number];
		for(int i = 0; i < number; i++) {
			darts[i] = new DartArrow();
		}
		return darts;
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
	
	public void throwDart() {
		dartThrow = new Throw(throwParameter[0],throwParameter[1],throwParameter[2]);
		double distance = dartThrow.computeDistanceToDartBoardCenter();
		int angle = dartThrow.computeAngleOnDartBoard();
		System.out.println(distance + "cm " + angle +"°");
		points = DartboardMathModel.determinePoints(angle, distance);
		multiplier = DartboardMathModel.determineMultiplier(distance);
	}
	
}
