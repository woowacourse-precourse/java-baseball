package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {

	static final int ZERO = 0;
	static final int MIN_RANDOM_VALUE = 1;
	static final int MAX_RANDOM_VALUE = 9;
	static final int MIN_PATTERN_VALUE = 1;
	static final int MAX_PATTERN_VALUE = 9;
	static final int MAX_NUMBERS_COUNT = 3;
	static final int INIT_STRIKE_COUNT = 0;
	static final int MAX_STRIKE_COUNT = 3;

	static final String INIT_GAME_START_VALUE = "1";
	static final String MESSAGE_START = "숫자 야구 게임을 시작합니다.";
	static final String MESSAGE_REQUEST_INPUT = "숫자를 입력해주세요 : ";
	static final String MESSAGE_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	static final String MESSAGE_RETRY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	static final String MESSAGE_NOTHING = "낫싱";
	static final String MESSAGE_BALL = "볼";
	static final String MESSAGE_BLANK = " ";
	static final String MESSAGE_STRIKE = "스트라이크";
	static final String FLAG_RETRY_STRING = "1";
	static final String FLAG_STOP_STRING = "2";
	static final String PATTERN = "^[" + MIN_PATTERN_VALUE +
									"-" + MAX_PATTERN_VALUE +
									"]{" + MAX_NUMBERS_COUNT + "}?$";

	public static void main(String[] args) {
		System.out.println(MESSAGE_START);

		String gameStart = INIT_GAME_START_VALUE;

		/* 프로그램 메인 구조, 게임 중단 플래그가 세워질 때 까지 반복, 예외 발생 시 프로그램 중단 */
		while (gameStart.equals(FLAG_RETRY_STRING)) {
			gameStart = playBall();
		}
	}

	public static String playBall() {
		/* 컴퓨터 숫자 정하기 파트 */
		List<Integer> computersNumbersList = List.copyOf(setComputersNumbers());

		/* 게임 시퀀스 루프 */
		int strike = INIT_STRIKE_COUNT;
		while (strike < MAX_STRIKE_COUNT) {
			String userInputNumbers = inputUserNumbers();
			validateInputPattern(userInputNumbers);
			List<Integer> usersNumbersList = List.copyOf(validateDuplication(userInputNumbers));

			strike = compareNumbers(usersNumbersList, computersNumbersList);
		}

		/* 게임 재시작 여부 확인 파트 */
		System.out.println(MESSAGE_GAME_OVER);
		System.out.println(MESSAGE_RETRY);
		String playAgain = checkRePlay();

		return validateRePlayOrStop(playAgain);
	}

	public static List<Integer> setComputersNumbers() {
		List<Integer> computersNumbers = new ArrayList<>(MAX_NUMBERS_COUNT);

		while (computersNumbers.size() < MAX_NUMBERS_COUNT) {
			final int RANDOM_NUMBER = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);

			if (!computersNumbers.contains(RANDOM_NUMBER)) {
				computersNumbers.add(RANDOM_NUMBER);
			}
		}

		return computersNumbers;
	}

	public static String checkRePlay() {
		System.out.println(MESSAGE_REQUEST_INPUT);
		return Console.readLine();
	}

	public static String validateRePlayOrStop(String playAgain) {
		if (!(playAgain.equals(FLAG_RETRY_STRING) || playAgain.equals(FLAG_STOP_STRING))) {
			throw new IllegalArgumentException();
		}

		return playAgain;
	}

	public static String inputUserNumbers() {
		System.out.print(MESSAGE_REQUEST_INPUT);
		return Console.readLine();
	}

	public static void validateInputPattern(String userInputNumbers) {
		if (!Pattern.matches(PATTERN, userInputNumbers)) {
			throw new IllegalArgumentException();
		}
	}

	public static List<Integer> validateDuplication(String userInputNumbers) {
		List<Integer> duplicationTestList = new ArrayList<>(MAX_NUMBERS_COUNT);

		for (int indexNumber = ZERO; indexNumber < MAX_NUMBERS_COUNT; indexNumber++) {
			char charAtIndex = userInputNumbers.charAt(indexNumber);
			int intIndex = Character.getNumericValue(charAtIndex);

			if (duplicationTestList.contains(intIndex)) {
				throw new IllegalArgumentException();
			}

			duplicationTestList.add(intIndex);
		}

		return duplicationTestList;
	}

	public static int compareNumbers(List<Integer> usersNumbersList, List<Integer> computersNumbersList) {
		int strike = ZERO;
		int ball = ZERO;

		for (int indexNumber = ZERO; indexNumber < MAX_NUMBERS_COUNT; indexNumber++) {
			if (computersNumbersList.contains(usersNumbersList.get(indexNumber))) {
				ball++;
			}
			if (computersNumbersList.get(indexNumber).equals(usersNumbersList.get(indexNumber))) {
				ball--;
				strike++;
			}
		}

		printCompareResult(strike, ball);

		return strike;
	}

	public static void printCompareResult(int strike, int ball) {
		if (strike == ZERO && ball == ZERO) {
			System.out.println(MESSAGE_NOTHING);
		}
		if (strike == ZERO && ball != ZERO) {
			System.out.println(ball + MESSAGE_BALL);
		}
		if (strike != ZERO && ball == ZERO) {
			System.out.println(strike + MESSAGE_STRIKE);
		}
		if (strike != ZERO && ball != ZERO) {
			System.out.println(ball + MESSAGE_BALL + MESSAGE_BLANK + strike + MESSAGE_STRIKE);
		}
	}
}
