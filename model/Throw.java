package model;

public class Throw {
	
	private final static int distanceToDartBoard = 237;
	private final static double G = 9.81;
	private final static MathVector gravityVector = new MathVector(new double[]{0,0,-0.5*G});
	private final static MathVector dartBoardCenter = new MathVector(new double[]{distanceToDartBoard,0,0});
	private final static MathVector dartBoardAngleVector = new MathVector(new double[]{0,1,0});
	
	private MathVector directionVector;
	private MathVector impactVector;

	public Throw(double xVelocity, double yVelocity, double zVelocity) {
		this.directionVector = new MathVector(new double[] {xVelocity, yVelocity, zVelocity});
		this.impactVector = computeImpactPoint();
	}
	
	// IP(t) = startpoint + t*directionVector + t^2*gravityVector
	// startoint = (0,0,0)
	private MathVector computeImpactPoint() {
		// xComponent is on impact equal to distanceToDartBoard 
		double scalarT = distanceToDartBoard / directionVector.getVectorComponents()[0];		
		MathVector scaledDirectionVector = directionVector.scalarMult(scalarT);
		MathVector scaledGravityVector = gravityVector.scalarMult(scalarT);
		return scaledDirectionVector.vectorAdd(scaledGravityVector);
	}
	
	public double computeDistanceToDartBoardCenter() {
		return dartBoardCenter.distanceToSecondVector(impactVector);
	}
	
	public int computeAngleOnDartBoard() {
		return dartBoardAngleVector.intersectionAngleAntiClockwise(impactVector);

	}
}
