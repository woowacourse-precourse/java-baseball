package baseball.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Numbers {
    private List<Integer> numbers = new ArrayList<>();

    public void createRandomNumbers() {
	while (numbers.size() < 3) {
	    int randomNumber = Randoms.pickNumberInRange(1, 9);
	    if (!numbers.contains(randomNumber)) {
		numbers.add(randomNumber);
	    }
	}
    }

    public void setNumbers(String inputNumber) {
	clearNumbers();
	for (Character c: inputNumber.toCharArray()) {
	    numbers.add(Character.getNumericValue(c));
	}
    }

    private void clearNumbers() {
	numbers.clear();
    }

    public List<Integer> getNumbers() {
	return numbers;
    }

    public int compareStrikeByInput(Numbers n) {
	List<Integer> inputNumbers = n.getNumbers();
	int countStrike = 0;

	for (int i = 0; i < 3; ++i) {
	    if (numbers.get(i).equals(inputNumbers.get(i))) {
		countStrike++;
	    }
	}

	return countStrike;
    }

    public int compareBallByInput(Numbers n) {
	List<Integer> inputNumbers = n.getNumbers();
	int countBall = 0;

	for (int i = 0; i < 3; ++i) {
	    if (numbers.get(i).equals(inputNumbers.get(i))) {
		continue;
	    }
	    if (!numbers.contains(inputNumbers.get(i))) {
		continue;
	    }
	    countBall++;
	}

	return countBall;
    }
}