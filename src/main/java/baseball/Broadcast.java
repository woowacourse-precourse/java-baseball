package baseball;

public class Broadcast {
	private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String END_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.";

	static void printStartMessage() {
		System.out.println(START_MESSAGE);
	}

	static void printInputMessage() {
		System.out.print(INPUT_MESSAGE);
	}

	static void printResultMessage(String resultMessage) {
		System.out.println(resultMessage);
	}

	static void printEndMessage(int PLAYING_NUMBER_SIZE) {
		System.out.printf((END_MESSAGE) + "%n", PLAYING_NUMBER_SIZE);
	}

	static void printRestartMessage(int START_INPUT, int END_INPUT) {
		System.out.printf((RESTART_MESSAGE) + "%n", START_INPUT, END_INPUT);
	}
}
