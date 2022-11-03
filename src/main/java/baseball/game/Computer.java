package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
	private List<Integer> numbers;

	public List<Integer> getNumbers() {
		return List.copyOf(numbers);
	}

	public void generateComputerNumbers() {
		List<Integer> numbers = new ArrayList<>();
		while (numbers.size() < 3) {
			int number = Randoms.pickNumberInRange(1, 9);
			if (!numbers.contains(number)) {
				numbers.add(number);
			}
		}
		this.numbers = numbers;
	}
}
