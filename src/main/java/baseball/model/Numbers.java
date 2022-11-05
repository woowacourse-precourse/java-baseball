package baseball.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Numbers {
    private static List<Integer> numbers = new ArrayList<>();

    public static void createRandomNumbers() {
	while (numbers.size() < 3) {
	    int randomNumber = Randoms.pickNumberInRange(1, 9);
	    if (!numbers.contains(randomNumber)) {
		numbers.add(randomNumber);
	    }
	}
    }

    public static void setNumbers(String inputNumber) {
	for (Character c: inputNumber.toCharArray()) {
	    numbers.add(Character.getNumericValue(c));
	}
    }

    public static List<Integer> getNumbers() {
	return numbers;
    }

    public static int checkStrike(Numbers n) {
	List<Integer> compareNumbers = n.getNumbers();
	int countStrike = 0;

	for (int i = 0; i < 3; ++i) {
	    if (numbers.get(i).equals(compareNumbers.get(i))) {
		countStrike++;
	    }
	}

	return countStrike;
    }

    public static int checkBall(Numbers n) {
	List<Integer> compareNumbers = n.getNumbers();
	int countBall = 0;

	for (int i = 0; i < 3; ++i) {
	    if (numbers.get(i).equals(compareNumbers.get(i))) {
		continue;
	    }
	    if (!numbers.contains(compareNumbers.get(i))) {
		continue;
	    }
	    countBall++;
	}

	return countBall;
    }
}