package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DartboardMathModel {
	
	private final static Integer SECTORNUMBER = 20;
	private final static Integer[] MULTIPLIERS = {-1,0,1,2,3};
	private final static Double[] DISTANCES = {6.35, 15.9, 99.0, 107.0, 162.0, 170.0};
	
	private final static Integer[] SECTORS;
	private final static Map<IntegerKeyPair, Integer> FIELD_VALUE_RELATIONS = new HashMap<>();
	private final static Map<Integer, Integer> ANGLE_SECTOR_RELATION = new HashMap<>();
	
	static {
		SECTORS = sectorGenerator();
		fieldValueRelationsGenerator();
		angleSectorRelationGenerator();
	}
	
	private static void fieldValueRelationsGenerator() {
		for(Integer sector : SECTORS) {
			List<Integer> values = valuesGenerator(sector);
			for(Integer multiplier : MULTIPLIERS) {
				IntegerKeyPair keyPair = new IntegerKeyPair(sector, multiplier);
				FIELD_VALUE_RELATIONS.put(keyPair, values.get(multiplier + 1));
			}
		}	
	}
	
	private static List<Integer> valuesGenerator(Integer baseValue){
		Integer BULLSEYE = 50;
		Integer OUTERBULLSEYE = 25;	
		List<Integer> values = new ArrayList<>();
		values.add(BULLSEYE);
		values.add(OUTERBULLSEYE);
		for(int i = 1; i < MULTIPLIERS.length -1; i++) {
			values.add(baseValue * i);
		}	
		return values;
	}
	
	private static Integer[] sectorGenerator() {
		Integer[] sectors = new Integer[SECTORNUMBER];
		for(int i = 1; i <= SECTORNUMBER; i++) sectors[i-1] = i;
		return sectors;
	}
	
	private static void angleSectorRelationGenerator() {
		Integer[] sectorSequence = {6,13,4,18,1,20,5,12,9,14,11,8,16,7,19,3,17,2,15,10,6};
		for(int i = 0; i < sectorSequence.length; i++) {
			ANGLE_SECTOR_RELATION.put(i, sectorSequence[i]);
		}
	}
	
	public Map<IntegerKeyPair, Integer> getFieldValueRelations() {
		return FIELD_VALUE_RELATIONS;
	}
	
	public void printFieldValueRelations() {
        for (Map.Entry<IntegerKeyPair, Integer> entry : FIELD_VALUE_RELATIONS.entrySet()) {
        	IntegerKeyPair keyArray = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(keyArray + " Wert: " + value);
        }
	}
	
	public static Integer determinePoints(Integer angle, Double distance) {
		Integer sector = determineSector(angle);
		Integer multiplier = determineMultiplier(distance);
		Integer points;
		IntegerKeyPair keyPair = new IntegerKeyPair(sector, multiplier);
		points = FIELD_VALUE_RELATIONS.get(keyPair);
		if(points != null) return points;
		return 0;
	}
	
	public static Integer determineSector(Integer angle) {
		Random random = new Random();
		Integer hitSector;
		double hitSectorTemp;
		final double degreePerSector = 18.0;
		
		hitSectorTemp = angle/degreePerSector + 0.5;
		hitSector = (int)(angle/degreePerSector + 0.5);
		boolean isWireHit = (hitSectorTemp - hitSector) == 0;
		if(isWireHit) return ANGLE_SECTOR_RELATION.get(hitSector - random.nextInt(2));
		return ANGLE_SECTOR_RELATION.get(hitSector);
	}
	
	public static Integer determineMultiplier(Double distance) {
		Random random = new Random();
		final Integer OutOfBoard = null;
		final Integer[] MULTIPLIER_VALUES_ORDER = {-1, 0, 1, 3, 1, 2, OutOfBoard};
		for(int i = 0; i < DISTANCES.length; i++) {
			if(distance.equals(DISTANCES[i])) return MULTIPLIER_VALUES_ORDER[i + random.nextInt(2)];
			else if(distance < DISTANCES[i]) return MULTIPLIER_VALUES_ORDER[i];
		}
		return OutOfBoard;
	}

	
}
