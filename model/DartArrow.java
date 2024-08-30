package model;

import java.util.Arrays;


/**
 * The {@code DartArrow} class represents a dart throw in a dart game. 
 * It encapsulates the parameters of the throw, the resulting points, 
 * and the multiplier based on the throw's accuracy.
 */
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
	
	/**
     * Factory method to create an array of {@code DartArrow} objects.
     *
     * @param number the number of {@code DartArrow} objects to create
     * @return an array of {@code DartArrow} objects
     */
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

	/**
     * Sets the throw parameters for this dart throw. Must be called before the dart is thrown.
     *
     * @param tp an array of doubles representing the throw parameters
     */
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
	
	/**
     * Executes the dart throw by calculating the distance to the dartboard center 
     * and the angle on the dartboard. The points and multiplier are determined 
     * based on these calculations.
     * 
     * Uses Throw and DartBoardMathModel
     */
	public void throwDart() {
		dartThrow = new Throw(throwParameter[0],throwParameter[1],throwParameter[2]);
		double distance = dartThrow.computeDistanceToDartBoardCenter();
		int angle = dartThrow.computeAngleOnDartBoard();
		this.points = DartboardMathModel.determinePoints(angle, distance);
		this.multiplier = DartboardMathModel.determineMultiplier(distance);
	}
	
}
