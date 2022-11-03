package baseball.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseball {
	private final List<Integer> numbers;

	public NumberBaseball(List<Integer> numbers) {
		this.numbers = numbers;
	}



	public List<Integer> getNumbers() {
		return numbers;
	}
}
