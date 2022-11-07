package baseball;

import static baseball.Validation.validateAnswer;
import static baseball.Validation.validateOneOrTwo;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

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

			ballCount = Result.getBallCount(pitcher, hitter);
			strikeCount = Result.getStrikeCount(pitcher, hitter);

			System.out.println(Result.getResult(ballCount, strikeCount));
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
}
