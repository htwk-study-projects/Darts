package model;

import java.util.Arrays;

/**
 * The {@code MathVector} class represents a mathematical vector and provides operations for vector manipulation.
 * This class supports vector addition, scalar multiplication, dot product calculation, distance measurement and a special intersectionangle calculation.
 */
public class MathVector {
	
	private double[] vectorComponents;
	private int length;
	
	public MathVector(double[] components) {
		if (components == null || components.length == 0) throw new IllegalArgumentException("Das Komponentenarray darf nicht null oder leer sein.");
		this.vectorComponents = components.clone();
		this.length = components.length;
	}
	
	public MathVector scalarMult(double scalar) {
		double[] scaledComponents = new double[this.length];
		for(int i=0; i< this.length; i++) {
			scaledComponents[i] = this.vectorComponents[i] * scalar;
		}
		return new MathVector(scaledComponents);
	}
	
	public MathVector vectorAdd(MathVector vector2) {
		if(vector2 == null || this.length != vector2.length) throw new IllegalArgumentException("Die Vektoren müssen die gleiche Länge haben und müssen definiert sein.");;
		
		double[] addedComponents = new double[this.length];
		for(int i = 0; i < this.length; i++) {
			addedComponents[i] = this.vectorComponents[i] + vector2.vectorComponents[i];
		}
		return new MathVector(addedComponents);
	}
	
	private double vectorSize() {
		double sumOfSquares = 0;
		for(double component : this.vectorComponents) {
			sumOfSquares += Math.pow(component, 2);
		}
		return Math.sqrt(sumOfSquares);
	}
	
	public double distanceToSecondVector(MathVector secondVector) {
		MathVector distanceVector = this.vectorAdd(secondVector.scalarMult(-1));
		return distanceVector.vectorSize();
	}
	
	public double dotProd(MathVector vector2) {
		if (vector2 == null || this.length != vector2.length) throw new IllegalArgumentException("Die Vektoren müssen die gleiche Länge haben.");	
		double scalarProd = 0;
		for( int i = 0; i < this.length;i++) {
			scalarProd += this.vectorComponents[i] * vector2.vectorComponents[i];
		}
		return scalarProd;
	}

	/**
	 * Computes the counterclockwise angle between this vector and another vector. The method is specialized for our dartboard representation.
	 * 
	 * @param vector2 the vector to compute the angle with
	 * @return the counterclockwise angle in degrees between this vector and the specified vector
	 */
	public int intersectionAngleCounterClockwise(MathVector vector2) {
		double cosTheta = this.dotProd(vector2) / (this.vectorSize() * vector2.vectorSize());
		cosTheta = Math.max(-1, Math.min(1, cosTheta));
	    double theta =  Math.toDegrees(Math.acos(cosTheta));
	    
	    if(vector2.vectorComponents[2] < 0) theta = 360 - theta; //dartboard is divided into two halves by the xy plane.
	    return (int) theta;
	}
	
	@Override
	public String toString() {
		return "MathVector [vectorComponents=" + Arrays.toString(vectorComponents) + "]";
	}
	
	public double[] getVectorComponents() {
		return vectorComponents.clone();
	}
}
