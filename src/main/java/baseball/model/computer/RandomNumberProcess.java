package baseball.model.computer;

import java.util.LinkedHashMap;
import java.util.List;

public class RandomNumberProcess {

	public static LinkedHashMap<Integer, Integer> storeNumbers(List<Integer> input) {
		return storeIntoMap(input);
	}

	public static LinkedHashMap<Integer, Integer> storeIntoMap(List<Integer> numbersArray) {

		LinkedHashMap<Integer, Integer> numbersWithIdx = new LinkedHashMap<>();

		for (int idx = 0; idx < numbersArray.size(); idx++) {
			numbersWithIdx.put(numbersArray.get(idx), idx);
		}
		return numbersWithIdx;
	}
}
