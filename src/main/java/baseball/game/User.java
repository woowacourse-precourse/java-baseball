package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
	private List<Integer> numbers;

	public void receiveUserInput() {
		System.out.print("숫자를 입력해주세요 : ");
		String input = Console.readLine();
		validateUserInput(input);
		this.numbers = convertStringToNumbers(input);
	}

	private List<Integer> convertStringToNumbers(String input) {
		List<Integer> numbers = Arrays.stream(input.split(""))
				.map(Integer::parseInt)
				.distinct()
				.collect(Collectors.toList());
		if (numbers.size() != 3) {
			throw new IllegalArgumentException("중복된 입력은 허용하지 않습니다.");
		}
		return numbers;
	}

	private void validateUserInput(String input) {
		if (input.length() != 3) {
			throw new IllegalArgumentException("1~9까지 3자리 숫자를 입력해주세요.");
		}
		if (!input.matches("^[1-9]*$")) {
			throw new IllegalArgumentException("1~9까지 정수만 입력해주세요.");
		}
	}
}
