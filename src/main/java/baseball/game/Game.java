package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
	private List<Integer> computerNumbers;
	private List<Integer> userNumbers;

	private Game() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public static Game create() {
		return new Game();
	}

	public void start() {
		computerNumbers = generateComputerNumbers();
		userNumbers = receiveUserInput();
	}

	public List<Integer> getComputerNumbers() {
		return List.copyOf(computerNumbers);
	}

	private List<Integer> generateComputerNumbers() {
		List<Integer> numbers = new ArrayList<>();
		while (numbers.size() < 3) {
			int number = Randoms.pickNumberInRange(1, 9);
			if (!numbers.contains(number)) {
				numbers.add(number);
			}
		}
		return numbers;
	}

	private List<Integer> receiveUserInput() {
		System.out.print("숫자를 입력해주세요 : ");
		String input = Console.readLine();
		validateUserInput(input);
		return Arrays.stream(input.split(""))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	public void validateUserInput(String input) {
		if (input.length() != 3) {
			throw new IllegalArgumentException("1~9까지 3자리 숫자를 입력해주세요.");
		}
		if (!input.matches("^[1-9]*$")) {
			throw new IllegalArgumentException("1~9까지 정수만 입력해주세요.");
		}
	}
}
