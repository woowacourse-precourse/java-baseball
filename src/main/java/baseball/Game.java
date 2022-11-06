package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

import static baseball.Validation.validateAnswer;
import static baseball.Validation.validateOneOrTwo;

public class Game {
	private List<Integer> pitcher;

	public Game() {
		pitcher = new Pitcher().getNumber();
	}

	public int run() {
		int ballCount = 0;
		int strikeCount = 0;

		do {
			System.out.print("숫자를 입력해주세요 : ");
			String input = Console.readLine();
			validateAnswer(input);

			List<Integer> hitter = getHitterUsingInput(input);

			ballCount = getBallCount(pitcher, hitter);
			strikeCount = getStrikeCount(pitcher, hitter);

			printResult(ballCount, strikeCount);
		} while (strikeCount < 3);

		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String restartOrEndInput = Console.readLine();
		validateOneOrTwo(restartOrEndInput);

		return Integer.parseInt(restartOrEndInput);
	}

	//사용자에게 입력받은 문자열을 바탕으로, 3개의 요소가 들어있는 List로 바꾸어 리턴해주는 함수
	private List<Integer> getHitterUsingInput(String input) {
		List<Integer> hitter = new ArrayList<>();
		String[] splitInput = input.split("");

		for (String digitStr : splitInput) {
			hitter.add(Integer.parseInt(digitStr));
		}

		return hitter;
	}


	private int getBallCount(List<Integer> pitcher, List<Integer> hitter) {
		int ball = 0;
		for (int i = 0; i < 3; i++) {
			if (pitcher.contains(hitter.get(i))) {
				ball++;
			}
		}

		ball -= getStrikeCount(pitcher, hitter);
		return ball;
	}

	private int getStrikeCount(List<Integer> pitcher, List<Integer> hitter) {
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
