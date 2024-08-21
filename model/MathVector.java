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
	
	public MathVector crossProd(MathVector vector2) {
		 if (this.length != 3 || vector2.length != 3) {
	            throw new IllegalArgumentException("Kreuzprodukt ist nur für 3D-Vektoren definiert.");
		 }
		 double[] crossProductComponents = new double[3];
	     crossProductComponents[0] = this.vectorComponents[1] * vector2.vectorComponents[2] - this.vectorComponents[2] * vector2.vectorComponents[1];
	     crossProductComponents[1] = this.vectorComponents[2] * vector2.vectorComponents[0] - this.vectorComponents[0] * vector2.vectorComponents[2];
	     crossProductComponents[2] = this.vectorComponents[0] * vector2.vectorComponents[1] - this.vectorComponents[1] * vector2.vectorComponents[0];
	     return new MathVector(crossProductComponents);
	}
	
	public int intersectionAngleAntiClockwise(MathVector vector2) {
		double cosTheta = this.dotProd(vector2) / (this.vectorSize() * vector2.vectorSize());
	    int theta = (int) Math.toDegrees(Math.acos(cosTheta));
	    
	    double sinTheta = this.crossProd(vector2).vectorSize() / (this.vectorSize() * vector2.vectorSize());
	    
	    if(sinTheta < 0) return 360 - theta;
	    return theta;
	}
}
