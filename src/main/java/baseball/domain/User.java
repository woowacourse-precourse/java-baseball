package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
	private static final String ONE_LETTER_DIVISION_REGEX = "";
	private final List<Integer> number;

	public User() {
		this.number = new ArrayList<>();
	}

	public void init() {
		number.clear();
	}

	public void setNumber(String inputNumber) {
		init();
		number.addAll(Arrays.stream(inputNumber.split(ONE_LETTER_DIVISION_REGEX))
			.map(Integer::parseInt)
			.collect(Collectors.toList()));
	}
}
