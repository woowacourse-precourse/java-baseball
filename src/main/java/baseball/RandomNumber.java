package baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
	private static List<Integer> randomNumber;
	private static final String regex = "^[1-9]{3}$";
	private static final int NUMBERSIZE = 3;

	public RandomNumber() {
	}

	public List<Integer> getRandomNumberList() {
		return randomNumber;
	}

	public void createRandomNumber() {
		Set<Integer> randomNumberSet = new LinkedHashSet<>();
		while (randomNumberSet.size() < NUMBERSIZE) {
			int pickNumber = Randoms.pickNumberInRange(1, 9);
			if (!randomNumberSet.contains(pickNumber)) {
				randomNumberSet.add(pickNumber);
			}
		}
		randomNumber = new ArrayList<>(randomNumberSet);
	}

	public void checkUserInput() {
		if(!randomNumber.isEmpty()) {
			randomNumber.clear();
		}
		String userInput = Console.readLine();
		if (!userInput.matches(regex)) {
			throw new IllegalArgumentException();
		}
		randomNumber = new ArrayList<>();
		for (int i = 0; i < NUMBERSIZE; i++) {
			randomNumber.add(userInput.charAt(i) - '0');
		}
	}
}
