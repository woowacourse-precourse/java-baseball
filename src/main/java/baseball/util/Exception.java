package baseball.util;

public class Exception {

	private static String input;
	private static final String RETRY_INPUT = "1";
	private static final String END_INPUT = "2";

	public static void isEndOrRetryInputValid() {
		if (input.equals(RETRY_INPUT) || input.equals(END_INPUT)) {
			return;
		}
		throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
