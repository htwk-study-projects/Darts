package model;

/**
 * Represents a dart throw and performs calculations related to its impact on a dartboard.
 * Provides methods to compute the impact point, distance to the dartboard center, and angle on the dartboard.
 */
public class Throw {
	
	private final static int DISTANCE_TO_BOARD = 237;
	private final static double G = 9.81;
	private final static MathVector GRAVITY_VECTOR = new MathVector(new double[]{0,0,-0.1*G});
	private final static MathVector DARTBOARD_CENTER = new MathVector(new double[]{DISTANCE_TO_BOARD,0,0});
	private final static MathVector DARTBOARD_ANGLE_VECTOR = new MathVector(new double[]{0,1,0});
	
	private MathVector directionVector;
	private MathVector impactVector;
	private MathVector centerToImpactPointVector;

	public Throw(double xVelocity, double yVelocity, double zVelocity) {
		this.directionVector = new MathVector(new double[] {xVelocity, yVelocity, zVelocity});
		this.impactVector = computeImpactPoint();
		this.centerToImpactPointVector = computeCenterToImpactPointVector();
	}
	
	// IP(t) = startpoint + t*directionVector + t^2*gravityVector
	// startoint = (0,0,0)
	private MathVector computeImpactPoint() {
		// xComponent is on impact equal to distanceToDartBoard 
		double xVelocity = directionVector.getVectorComponents()[0];
	        if (xVelocity == 0) {
	            throw new IllegalStateException("Horizontalgeschwindigkeit darf nicht null sein.");
	        }
		double scalarT = DISTANCE_TO_BOARD / directionVector.getVectorComponents()[0];		
		MathVector scaledDirectionVector = directionVector.scalarMult(scalarT);
		MathVector scaledGravityVector = GRAVITY_VECTOR.scalarMult(Math.pow(scalarT, 2));
		return scaledDirectionVector.vectorAdd(scaledGravityVector);
	}
	
	private MathVector computeCenterToImpactPointVector() {
		return this.impactVector.vectorAdd(Throw.DARTBOARD_CENTER.scalarMult(-1));
	}
	
	public double computeDistanceToDartBoardCenter() {
		return DARTBOARD_CENTER.distanceToSecondVector(impactVector);
	}
	
	public int computeAngleOnDartBoard() {
		return DARTBOARD_ANGLE_VECTOR.intersectionAngleCounterClockwise(centerToImpactPointVector);
	}
	
	public MathVector getImpactVector() {
		return impactVector;
	}
}
