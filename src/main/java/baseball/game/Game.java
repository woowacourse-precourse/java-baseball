package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Integer> computerNumbers;

	private Game() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public static Game create() {
		return new Game();
	}

	public void start() {
		computerNumbers = generateComputerNumbers();
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
}
