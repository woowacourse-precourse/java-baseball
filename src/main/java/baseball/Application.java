package baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	private static List<Integer> computerNumber;
	private static List<Integer> userNumber;
	private static String regex = "^[1-9]{3}$";
	private static String regexCode = "^[1-2]$";
	private static final String GAMESTARTSTRING = "숫자 야구 게임을 시작합니다.";
	private static final String USERINPUTSTRING = "숫자를 입력해주세요 : ";
	private static final String GAMECLEARSTRING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String GAMEENDSTRING = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static void main(String[] args) {
		printStr(GAMESTARTSTRING);
		int gameCode = 1;

		while (gameCode != 2) {
			createRandomNumber();

			while (true) {
				printStr(USERINPUTSTRING);
				checkUserInput();
				String compareResultStr = compareNumber();
				printStr(compareResultStr);
				if (compareResultStr.equals("3스트라이크")) {
					printStr(GAMECLEARSTRING);
					break;
				}
			}

			while (true) {
				printStr(GAMEENDSTRING);
				String codeStr = Console.readLine();
				if (checkGameCode(codeStr)) {
					gameCode = Integer.parseInt(codeStr);
					break;
				}
				printStr("1과 2 중에 다시 입력해주세요.");
			}
		}
	}

	private static void printStr(String str) {
		System.out.println(str);
	}

	private static void createRandomNumber() {
		Set<Integer> randomNumberSet = new LinkedHashSet<>();
		while (randomNumberSet.size() < 3) {
			int pickNumber = Randoms.pickNumberInRange(1, 9);
			if (!randomNumberSet.contains(pickNumber)) {
				randomNumberSet.add(pickNumber);
			}
		}
		computerNumber = new ArrayList<>(randomNumberSet);
	}

	private static void checkUserInput() {
		String userInput = Console.readLine();
		if (!userInput.matches(regex)) {
			throw new IllegalArgumentException();
		}
		userNumber = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			userNumber.add(userInput.charAt(i) - '0');
		}
	}

	private static String compareNumber() {
		String resStr = "";
		int strike = 0;
		int ball = 0;

		for (int i = 0; i < 3; i++) {
			int computerNum = computerNumber.get(i);
			int userNum = userNumber.get(i);

			if (computerNum == userNum) {
				strike++;
			} else if (computerNumber.contains(userNum)) {
				ball++;
			}
		}

		if (ball == 0 && strike == 0) {
			resStr = "낫싱";
		}
		if (ball != 0) {
			resStr = ball + "볼 ";
		}
		if (strike != 0) {
			resStr += strike + "스트라이크";
		}

		return resStr;
	}

	private static boolean checkGameCode(String gameCodeStr) {
		if (gameCodeStr.matches(regexCode)) {
			return true;
		}
		return false;
	}
}