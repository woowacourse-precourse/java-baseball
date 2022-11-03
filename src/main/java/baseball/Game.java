package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

import static baseball.validate.Validation.validateAnswer;
import static baseball.validate.Validation.validateOneOrTwo;

public class Game {
	private List<Integer> pitcher;

	public Game() {
		pitcher = new Pitcher().getNumber();
	}

	public int run() {
		int ballCount = 0;
		int strikeCount = 0;

		System.out.println("숫자 야구 게임을 시작합니다.");
		do {
			System.out.print("숫자를 입력해주세요 : ");
			String input = Console.readLine();

			validateAnswer(input);
			/*if (validateAnswer(input)) {
				return -1;
			}*/

			String[] splitInput = input.split("");

			List<Integer> hitter = new ArrayList<>();
			for (String s : splitInput) {
				hitter.add(Integer.parseInt(s));
			}

			ballCount = getBallCount(pitcher, hitter);
			strikeCount = getStrikeCount(pitcher, hitter);

			//printResult(ballCount, strikeCount);
		} while (strikeCount < 3);

		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String restartOrEndInput = Console.readLine();
		validateOneOrTwo(restartOrEndInput);

		return Integer.parseInt(restartOrEndInput);
	}


	private int getBallCount(List<Integer> pitcher, List<Integer> hitter) {
		int ball = 0;
		for (int i = 0; i < 3; i++) {
			if (pitcher.contains(hitter.get(i))) {
				ball++;
			}
		}

		int strike = getStrikeCount(pitcher ,hitter);
		ball -= strike;

		return ball;
	}

	private/*public*/ int getStrikeCount(List<Integer> pitcher, List<Integer> hitter) {
		int strike = 0;
		for (int i = 0; i < 3; i++) {
			if (pitcher.get(i) == hitter.get(i)) {
				strike++;
			}
		}

		return strike;
	}

	private void printResult(int ballCount, int strikeCount) {
		if (ballCount > 0 && strikeCount > 0) {
			System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
		} else if (ballCount == 0 && strikeCount == 0) {
			System.out.println("낫싱");
		} else if (strikeCount == 0) {
			System.out.printf("%d볼\n", ballCount);
		} else if (ballCount == 0) {
			System.out.printf("%d스트라이크\n", strikeCount);
			if (strikeCount == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			}
		}
	}
}
