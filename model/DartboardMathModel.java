package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DartboardMathModel {

	private final Map<IntegerKeyPair, Integer> fieldValueRelations = new HashMap<>();
	private final Integer[] sectors;
	private final static Integer[] MULTIPLIERS = {-1,0,1,2,3};
	
	private void fieldValueRelationsGenerator() {
		for(Integer sector : sectors) {
			List<Integer> values = new ArrayList<>();
			values = valuesGenerator(sector);
			for(Integer multiplier : MULTIPLIERS) {
				IntegerKeyPair keyPair = new IntegerKeyPair(sector, multiplier);
				fieldValueRelations.put(keyPair, values.get(multiplier + 1));
			}
		}	
	}
	
	private List<Integer> valuesGenerator(Integer baseValue){
		Integer bullseye = 50;
		Integer outerBullseye = 25;	
		List<Integer> values = new ArrayList<>();
		values.add(bullseye);
		values.add(outerBullseye);
		for(int i = 1; i < MULTIPLIERS.length -1; i++) {
			values.add(baseValue * i);
		}	
		return values;
	}
	
	private Integer[] sectorGenerator(int endNumber) {
		Integer[] sectors = new Integer[endNumber];
		for(int i = 1; i <= endNumber; i++) sectors[i-1] = i;
		return sectors;
	}
	
	public DartboardMathModel() {
		sectors = sectorGenerator(20);
		fieldValueRelationsGenerator();
	}

	public  Map<IntegerKeyPair, Integer> getFieldValueRelations() {
		return fieldValueRelations;
	}
	
	public Integer determinePoints(Integer sector, Integer multiplier) {
		Integer points;
		IntegerKeyPair keyPair = new IntegerKeyPair(sector, multiplier);
		points = fieldValueRelations.get(keyPair);
		if(points == null) return 0;
		return points;
	}

	public void printFieldValueRelations() {
        for (Map.Entry<IntegerKeyPair, Integer> entry : fieldValueRelations.entrySet()) {
        	IntegerKeyPair keyArray = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(keyArray + " Wert: " + value);
        }
	}
	
}
