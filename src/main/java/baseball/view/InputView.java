package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import baseball.exception.InvalidInputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String RESTART_NUM = "1";
	public static final String END_NUM = "2";

	public static List<Integer> inputNum() {
		System.out.print(INPUT_NUMBER_MESSAGE);
		String inputNum = Console.readLine();

		return toList(inputNum);
	}

	public static String inputRestartOrEnd() {
		String inputNum = Console.readLine();

		if (!inputNum.equals(RESTART_NUM) && !inputNum.equals(END_NUM)) {
			InvalidInputException.commandError();
		}

		return inputNum;
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
}
