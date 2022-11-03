package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import baseball.exception.InvalidInputException;
import camp.nextstep.edu.missionutils.Console;

public class GameView {
	private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";


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
			InvalidInputException.numberError();
		}
	}

}
