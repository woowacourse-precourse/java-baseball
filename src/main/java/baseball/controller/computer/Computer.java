package baseball.controller.computer;

import baseball.model.data.ComputerNumbers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Computer {

	public static LinkedHashMap<Integer, Integer> getNumbers() {
		List<Integer> numberList = new ArrayList<>();
		NumberGeneration.generateMultipleRandomNumber(numberList);

		return ComputerNumbers.storeNumbers(numberList);
	}
}
