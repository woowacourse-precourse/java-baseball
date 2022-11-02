package baseball.domain;

import baseball.util.Random;

import java.util.List;

public class Computer {

	public static List<Integer> getNumbers() {
		return Random.getThreeUniqueNumbers();
	}

}
