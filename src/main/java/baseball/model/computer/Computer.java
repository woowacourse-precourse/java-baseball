package baseball.model.computer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Computer {

	static RandomNumberProcess data = new RandomNumberProcess();

	public static LinkedHashMap<Integer, Integer> getNumbers() {
		List<Integer> numberList = new ArrayList<>();
		NumberGeneration.generateMultipleRandomNumber(numberList);

		return data.storeNumbers(numberList);
	}

}
