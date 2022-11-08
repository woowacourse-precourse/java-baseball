package baseball.view;

import java.util.Scanner;

public class InputView {

	Scanner scanner = new Scanner(System.in);
	private static final String inputMessage = "숫자를 입력해주세요 : ";
	private static final String retryMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String REGEX = "[1-9]+";
	private static final String retryREGEX = "[1-2]+";

	public void printInputMessage() {
		System.out.print(inputMessage);
		String input = scanner.nextLine();

		// 길이가 3이 아니면
		if (input.length() != 3) {
			throw new IllegalArgumentException();
		}
		// 1~9까지의 숫자가 아니면
		if (!input.matches(REGEX)) {
			throw new IllegalArgumentException();
		}

		// 같은 숫자를 입력할 경우
		// if(input.)


	}

	public void printRetryMessage() {

		System.out.print(retryMessage);
		String input = scanner.nextLine();

		// 길이가 1이 아니면
		if (input.length() != 1) {
			throw new IllegalArgumentException();
		}

		// 재시작/종류 구분 시 1,2 이외의 숫자나 문자를 입력할 경우
		if (!input.matches(retryREGEX)) {
			throw new IllegalArgumentException();
		}

	}

}
