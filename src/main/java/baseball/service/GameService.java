package baseball.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
	static final int min = 1;
	static final int max = 9;
	private static int strike = 1;
	private static int ball = 2;
	private static int root = 0;
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
	public static List<Integer> compareNumber(String computer, String user) {
		List<Integer> result = Arrays.asList(0, 0, 0);
		/*
		for (int i = 0; i < computer.length(); i++) {
			if (checkSameNumber(computer, Character.getNumericValue(user.charAt(i)))) {
				if (checkSameLocation(Character.toString(computer.charAt(i)), Character.toString(user.charAt(i)))) {
					strike++;
					continue;
				}
				ball++;
			}
		}
		 */
		for (int i = 0; i < computer.length(); i++) {
			result.set(root, i);
			isStrikeOrBall(computer, Character.toString(user.charAt(i)), result);
		}
		//result.add(strike);
		//result.add(ball);

		return result.subList(strike,result.size());
	}
	public static boolean checkSameLocation(String computer, String user) {
		return computer.equals(user);
	}
	public static List<Integer> isStrikeOrBall(String computer, String user, List<Integer> result) {
		if (checkSameNumber(computer, Integer.parseInt(user))) {
			if (checkSameLocation(Character.toString(computer.charAt(result.get(root))), user)) {
				result.set(strike, result.get(strike) + 1);
			}
			if (!checkSameLocation(Character.toString(computer.charAt(result.get(root))), user)) {
				result.set(ball, result.get(ball) + 1);
			}
		}
		return result;
	}
}
