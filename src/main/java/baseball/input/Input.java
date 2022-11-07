package baseball.input;

public class Input {
	private static String input;

	public static int validateRestartOrEndInput(String userInput) {
		if (!(userInput.equals("1") || userInput.equals("2"))) {
			throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
		}

		return Integer.parseInt(userInput);
	}
}
