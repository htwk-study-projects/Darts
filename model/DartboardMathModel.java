package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DartboardMathModel {

	private static Map<Integer[], Integer> fieldValueRelations = new HashMap<>();
	private final static Integer[] sectors = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,19,20};
	private final static Integer[] multipliers = new Integer[] {-1,0,1,2,3};
	
	static {
		fieldValueRelationsGenerator();
	}
	
	
	
	private static void fieldValueRelationsGenerator() {
		for(Integer sector : sectors) {
			List<Integer> values = new ArrayList<>();
			values = valuesGenerator(sector);
			for(Integer multiplier : multipliers) {
				Integer[] keyPair = new Integer[]{sector, multiplier};
				fieldValueRelations.put(keyPair, values.get(multiplier + 1));
			}
		}	
	}
	
	private static List<Integer> valuesGenerator(Integer baseValue){
		List<Integer> values = new ArrayList<>();
		values.add(50);
		values.add(25);
		for(int i = 1; i < multipliers.length -1; i++) {
			values.add(baseValue * i);
		}	
		return values;
	}
	
	public DartboardMathModel() {
		
	}
	

	
}
