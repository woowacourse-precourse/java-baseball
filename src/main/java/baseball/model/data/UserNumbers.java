package baseball.model.data;

import java.util.LinkedHashMap;

public class UserNumbers {

	public static LinkedHashMap<Integer, Integer> storeNumbers(String input) {
		return storeIntoMap(storeIntoArray(input));
	}

	public static LinkedHashMap<Integer, Integer> storeIntoMap(String[] numbersArray) {

		LinkedHashMap<Integer, Integer> numbersWithIdx = new LinkedHashMap<>();

		for (int idx = 0; idx < numbersArray.length; idx++) {
			numbersWithIdx.put(Integer.parseInt(numbersArray[idx]), idx);
		}

		return numbersWithIdx;
	}

	private static String[] storeIntoArray(String input) {
		return input.split("");
	}
}
