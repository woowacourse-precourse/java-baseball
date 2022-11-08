package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class IOHandler {

	private InputValidator inputValidator = new InputValidator();

	public void printInitMessage() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	public void printInputMessage() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public void printScore(Score score) {
		int ball = score.getBall();
		int strike = score.getStrike();
		if (ball == 0 && strike == 0) {
			System.out.println("낫싱");
			return;
		}
		String scoreString = buildNonZeroScoreString(ball, strike);
		System.out.println(scoreString);
	}

	public String buildNonZeroScoreString(int ball, int strike) {
		StringBuilder sb = new StringBuilder();
		if (ball > 0) {
			sb.append(ball + "볼");
		}
		if (ball > 0 && strike > 0) {
			sb.append(" ");
		}
		if (strike > 0) {
			sb.append(strike + "스트라이크");
		}
		return sb.toString();
	}

	public void printGameEndMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public List<Integer> getInputList() {
		String ansString = Console.readLine();
		inputValidator.validateAnsString(ansString);
		List<Integer> inputList = new ArrayList<>(3);
		for (char c : ansString.toCharArray()) {
			inputList.add(c-'0');
		}
		return inputList;
	}

	public int getRestartInt() {
		String restartString = Console.readLine();
		inputValidator.validateRestartString(restartString);
		return restartString.charAt(0)-'0';
	}
}
