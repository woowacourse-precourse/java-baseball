package baseball.service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
	static final int min = 1;
	static final int max = 9;

	public static String createRandomNumber() {
		String random = "";

		for (int i = 0; i < 3; i++) {
			int randomNumber = Randoms.pickNumberInRange(min, max);
			randomNumber = relocationNumber(random, randomNumber);
			random += randomNumber;
		}

		return random;
	}
	public static int relocationNumber(String number, int addedNumber) {
		while (checkSameNumber(number, addedNumber)) {
			addedNumber = Randoms.pickNumberInRange(min, max);
		}
		return addedNumber;
	}
	public static boolean checkSameNumber(String number, int addedNumber) {
		return number.contains(String.valueOf(addedNumber));
	}
	public static List<String> convertStringToList(String word) {
		List<String> list = new ArrayList<>();

		for (int i = 0; i < word.length(); i++)
			list.add(String.valueOf(word.charAt(i)));
		return list;
	}
	public static List<Integer> compareNumber(List<String> computer, List<String> user) {
		List<Integer> result = new ArrayList<>();
		int ball = 0;
		int strike = 0;

		for (int i = 0; i < computer.size(); i++) {
			if (checkSameNumber(String.join("", computer), Integer.parseInt(user.get(i)))) {
				if (checkSameLocation(computer.get(i), user.get(i))) {
					strike++;
					continue;
				}
				ball++;
			}
		}
		result.add(strike);
		result.add(ball);

		return result;
	}
	public static boolean checkSameLocation(String computer, String user) {
		return computer.equals(user);
	}
}
