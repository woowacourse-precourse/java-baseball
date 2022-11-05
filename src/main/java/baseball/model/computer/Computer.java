package baseball.model.computer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Computer {

	public static LinkedHashMap<Integer, Integer> getNumbers() {
		List<Integer> numberList = new ArrayList<>();
		NumberGeneration.generateMultipleRandomNumber(numberList);

		return DataProcess.storeNumbers(numberList);
	}

}
