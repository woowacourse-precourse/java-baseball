package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import baseball.exception.InvalidInputException;
import camp.nextstep.edu.missionutils.Console;

public class GameView {
	private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String BALL_MESSAGE = "%d볼\n";
	private static final String STRIKE_MESSAGE = "%d스트라이크\n";
	private static final String BALL_STRIKE_MESSAGE = "%d볼 %d스트라이크\n";
	private static final String NOTHING_MESSAGE = "낫싱";

	public static void printStartMessage() {
		System.out.println(START_GAME_MESSAGE);
	}

	public static List<Integer> inputNum() {
		System.out.print(INPUT_NUMBER_MESSAGE);
		String inputNum = Console.readLine();

		return toList(inputNum);
	}

	private static List<Integer> toList(String inputNum) {
		validateNum(inputNum);

		return Arrays.stream(inputNum.split("\\B"))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	private static void validateNum(String num) {
		final String REGEX = "[0-9]+";

		if (!num.matches(REGEX)) {
			InvalidInputException.convertError();
		}
	}

	public static void printHint(int ball, int strike) {
		if (ball == 0 && strike == 0) {
			System.out.println(NOTHING_MESSAGE);
		} else if (ball == 0 && strike != 0) {
			System.out.printf(STRIKE_MESSAGE, strike);
		} else if (ball != 0 && strike == 0) {
			System.out.printf(BALL_MESSAGE, ball);
		} else if (ball != 0 && strike != 0) {
			System.out.printf(BALL_STRIKE_MESSAGE, ball, strike);
		}
	}
}
