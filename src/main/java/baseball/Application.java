package baseball;

import java.util.ArrayList;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		int gameControllerNumber;
		int errNumber = 0;
		int exitNumber = 2;

		do {
			System.out.println("숫자 야구 게임을 시작합니다!!!");
			ArrayList<Integer> generateAnswer = generateAnswer();
			// System.out.println("정답은" + generateAnswer);
			gameControllerNumber = gameController(generateAnswer);
		} while (gameControllerNumber != exitNumber && gameControllerNumber != errNumber);
		System.out.println("게임 종료");
		if (gameControllerNumber == errNumber) {
			throw new IllegalArgumentException();
		}
	}

	public static int gameController(ArrayList<Integer> generateAnswer) {

		int gameControllerNumber;
		int errNumber = 0;
		ArrayList<Integer> inputUserValue;

		while (true) {
			inputUserValue = inputUserValue();
			if (inputUserValue.get(0) == errNumber) {
				gameControllerNumber = errNumber;
				break;
			}
			String compareAnswerAndValue = compareAnswerAndValue(generateAnswer, inputUserValue);
			System.out.println(compareAnswerAndValue);
			if (compareAnswerAndValue.equals("3스트라이크")) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				gameControllerNumber = restart();
				break;
			}
		}
		return gameControllerNumber;
	}

	public static ArrayList<Integer> generateAnswer() {
		ArrayList<Integer> answerNumber = new ArrayList<>();

		while (answerNumber.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!answerNumber.contains(randomNumber)) {
				answerNumber.add(randomNumber);
			}
		}
		return answerNumber;
	}

	public static ArrayList<Integer> inputUserValue() {
		ArrayList<Integer> inputNumberArray = new ArrayList<>();
		String inputNumber = Console.readLine();
		int firstBall = 0;
		int secondBall = 1;
		int thirdBall = 2;
		int errNumber = 0;

		if (inputNumber.charAt(firstBall) == inputNumber.charAt(secondBall)
			|| inputNumber.charAt(firstBall) == inputNumber.charAt(thirdBall)
			|| inputNumber.charAt(secondBall) == inputNumber.charAt(thirdBall) || inputNumber.length() != 3
			|| !Character.isDigit(inputNumber.charAt(firstBall)) || !Character.isDigit(inputNumber.charAt(secondBall))
			|| !Character.isDigit(inputNumber.charAt(thirdBall)) || inputNumber.charAt(firstBall) == 0
			|| inputNumber.charAt(secondBall) == 0 || inputNumber.charAt(thirdBall) == 0) {
			inputNumberArray.add(errNumber);

			return inputNumberArray;
		}

		inputNumberArray.add(Character.getNumericValue(inputNumber.charAt(firstBall)));
		inputNumberArray.add(Character.getNumericValue(inputNumber.charAt(secondBall)));
		inputNumberArray.add(Character.getNumericValue(inputNumber.charAt(thirdBall)));

		return inputNumberArray;
	}

	public static String compareAnswerAndValue(ArrayList<Integer> generateAnswer, ArrayList<Integer> inputUserValue) {

		String outputInText = "";
		int strikeCount = 0;
		int ballCount = 0;
		int firstBall = 0;
		int secondBall = 1;
		int thirdBall = 2;

		for (int j = 0; j < 3; j++) {
			if (Objects.equals((generateAnswer.get(firstBall)), inputUserValue.get(j)) && j == firstBall) {
				strikeCount++;
			}
			if (Objects.equals((generateAnswer.get(firstBall)), inputUserValue.get(j)) && j != firstBall) {
				ballCount++;
			}
		}

		for (int j = 0; j < 3; j++) {
			if (Objects.equals((generateAnswer.get(secondBall)), inputUserValue.get(j)) && j == secondBall) {
				strikeCount++;
			}
			if (Objects.equals((generateAnswer.get(secondBall)), inputUserValue.get(j)) && j != secondBall) {
				ballCount++;
			}
		}

		for (int j = 0; j < 3; j++) {
			if (Objects.equals((generateAnswer.get(thirdBall)), inputUserValue.get(j)) && j == thirdBall) {
				strikeCount++;
			}
			if (Objects.equals((generateAnswer.get(thirdBall)), inputUserValue.get(j)) && j != thirdBall) {
				ballCount++;
			}
		}

		outputInText = outputInText(outputInText, strikeCount, ballCount);

		return outputInText;
	}

	public static String outputInText(String outputInText, int strikeCount, int ballCount) {
		if (strikeCount == 0 && ballCount == 0) {
			outputInText += "낫싱";
		} else if (strikeCount == 0) {
			outputInText += (ballCount + "볼");
		} else if (ballCount == 0) {
			outputInText += (strikeCount + "스트라이크");
		} else {
			outputInText += (ballCount + "볼") + " " + (strikeCount + "스트라이크");
		}
		return outputInText;
	}

	public static int restart() {
		System.out.println("계속하시겠습니까?1=계속,2=끝");
		int toBeContinue = Integer.parseInt(Console.readLine());
		int continueNumber = 1;
		int exitNumber = 2;

		if (toBeContinue != continueNumber && toBeContinue != exitNumber) {
			toBeContinue = exitNumber;
		}
		return toBeContinue;
	}
}

