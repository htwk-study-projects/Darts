package model;

public class MathVector {
	
	private final double[] vectorComponents;
	private final int length;
	
	public MathVector(double[] components) {
		if (components == null || components.length == 0) {
	        throw new IllegalArgumentException("Das Komponentenarray darf nicht null oder leer sein.");
	    }
		this.vectorComponents = components.clone();
		this.length = components.length;
	}
	
	public double[] getVectorComponents() {
		return vectorComponents.clone();
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
		double scalarProd = 0;
		for( int i = 0; i < this.length;i++) {
			scalarProd += this.vectorComponents[i] * vector2.vectorComponents[i];
		}
		return scalarProd;
	}
	
	public int intersectionAngleAntiClockwise(MathVector vector2) {
		double cosTheta = this.dotProd(vector2) / (this.vectorSize() * vector2.vectorSize());
	    double theta =  Math.toDegrees(Math.acos(cosTheta));
	    
	    if(vector2.vectorComponents[2] < 0) theta = 360 - theta; //DartBoard xy-Area is mirror
	    return (int) theta;
	}
}
