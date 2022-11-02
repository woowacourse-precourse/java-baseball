package baseball;

import static baseball.Constant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class User {
	public List<Integer> numbers = new ArrayList<>();
	public String inputNumbers;

	public User() {
		playGame();
	}

	public void playGame() {
		this.inputNumbers = inputNumbers();
		this.numbers = convertStringToIntList(inputNumbers);
	}

	public String inputNumbers() {
		System.out.printf(INPUT_MESSAGE);
		return Console.readLine();
	}

	public List<Integer> convertStringToIntList(String string) {
		return Arrays.stream(string.chars()
				.map(num -> num - '0')
				.toArray())
			.boxed()
			.collect(Collectors.toList());
	}

}
