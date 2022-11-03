package baseball;

import static baseball.Constant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class User {
	public List<Integer> numbers = new ArrayList<>();

	public void play() {
		System.out.printf(INPUT_MESSAGE);
		String inputNumbers = Console.readLine();
		inputIsValidate(inputNumbers);
		numbers = convertStringToIntList(inputNumbers);
	}

	public List<Integer> convertStringToIntList(String string) {
		return Arrays.stream(string.chars()
				.map(num -> num - '0')
				.toArray())
			.boxed()
			.collect(Collectors.toList());
	}

	private static void inputIsValidate(String input) {
		if (!validateDuplication(input) || !validateLength(input) || !validateType(input)) {
			throw new IllegalArgumentException();
		}
	}

	private static boolean validateDuplication(String input) {
		Set<Character> checkDuplication = new HashSet<>();
		for (char number : input.toCharArray()) {
			checkDuplication.add(number);
		}
		return checkDuplication.size() == NUM_LENGTH;
	}

	private static boolean validateLength(String input) {
		if (input.length() == NUM_LENGTH) {
			return true;
		}
		return false;
	}

	private static boolean validateType(String input) {
		for (char number : input.toCharArray()) {
			if (number < '1' || number > '9') {
				return false;
			}
		}
		return true;
	}
}
