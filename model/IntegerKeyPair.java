package model;

import java.util.Objects;

public class IntegerKeyPair {
	
	private Integer firstKey;
	private Integer secondKey;
	
	public IntegerKeyPair(Integer firstKey, Integer secondKey) {
		this.firstKey = firstKey;
		this.secondKey = secondKey;
	}
	
	@Override
	public String toString() {
		return "[" + firstKey + "," + secondKey + "]";
	}

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
