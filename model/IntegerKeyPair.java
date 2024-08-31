package model;

import java.util.Objects;

/**
 * The {@code IntegerKeyPair} class represents a pair of integers used as a key in key-value mappings.
 * It provides methods for comparison and hashing based on the integer values.
 */
public class IntegerKeyPair {
	
	private final Integer firstKey;
	private final Integer secondKey;
	
	public IntegerKeyPair(Integer firstKey, Integer secondKey) {
		this.firstKey = firstKey;
		this.secondKey = secondKey;
	}
	
	@Override
	public String toString() {
		return "[" + firstKey + "," + secondKey + "]";
	}

	/**
     * Compares this key pair to another object for equality. Two {@code IntegerKeyPair} instances are
     * considered equal if both integer values are equal.
     * 
     * @param tryObj the object to compare with this key pair
     * @return {@code true} if the specified object is equal to this key pair, {@code false} otherwise
     */
	@Override
	public boolean equals(Object tryObj) {
		if(this == tryObj) return true;
		if(tryObj == null || this.getClass() != tryObj.getClass()) return false;
		IntegerKeyPair obj = (IntegerKeyPair) tryObj;
		return Objects.equals(firstKey, obj.firstKey) && Objects.equals(secondKey, obj.secondKey);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.firstKey, this.secondKey);
	}


	
}
