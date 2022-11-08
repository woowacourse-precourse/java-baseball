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

	public static void main(String[] args) {

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
}