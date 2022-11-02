package baseball.util;

public class SystemMessage {

	private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String END_OR_RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

	public static void printStart() {
		System.out.println(START_MESSAGE);
	}

	public static void printNumberInput() {
		System.out.print(NUMBER_INPUT_MESSAGE);
	}

	public static void printWin() {
		System.out.print(WIN_MESSAGE);
	}

	public static void printEndOrRetry() {
		System.out.println(END_OR_RETRY_MESSAGE);
	}
}
