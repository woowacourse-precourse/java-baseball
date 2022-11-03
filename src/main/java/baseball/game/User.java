package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.game.Const.*;

public class User {
	private List<Integer> numbers;

	public void receiveUserInput() {
		System.out.print(GAME_INPUT_WAIT_MESSAGE);
		String input = Console.readLine();
		validateUserInput(input);
		this.numbers = convertStringToNumbers(input);
	}

	public List<Integer> getNumbers() {
		return List.copyOf(numbers);
	}

	private List<Integer> convertStringToNumbers(String input) {
		List<Integer> numbers = Arrays.stream(input.split(""))
				.map(Integer::parseInt)
				.distinct()
				.collect(Collectors.toList());
		if (numbers.size() != GAME_LENGTH) {
			throw new IllegalArgumentException(GAME_EXCEPTION_DUPLICATE_MESSAGE);
		}
		return numbers;
	}

	private void validateUserInput(String input) {
		if (input.length() != GAME_LENGTH) {
			throw new IllegalArgumentException(GAME_EXCEPTION_LENGTH_MESSAGE);
		}
		if (!input.matches(POSITIVE_INTEGER_ONLY_REGEX)) {
			throw new IllegalArgumentException(GAME_EXCEPTION_INTEGER_MESSAGE);
		}
	}
}
