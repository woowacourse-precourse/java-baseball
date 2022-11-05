package baseball.view;

import java.util.Scanner;

public class InputView {
	private static final String startMessage = "숫자를 입력해주세요 : ";
	private static final String retryMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static String printStartMessage() {
		return startMessage;
	}
	public static String printRetryMessage() {
		return retryMessage;
	}
}
