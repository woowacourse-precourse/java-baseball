package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
	private final List<Integer> number;

	public User() {
		this.number = new ArrayList<>();
	}

	private void init() {
		number.clear();
	}

	public void setNumber(String inputNumber) {
		init();
		number.addAll(Arrays.stream(inputNumber.split(ConstValue.ONE_LETTER_DIVISION_REGEX))
			.map(Integer::parseInt)
			.collect(Collectors.toList()));
	}

	public List<Integer> getNumber() {
		return number;
	}
}
