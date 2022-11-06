package baseball.service;

import java.util.Arrays;
import java.util.List;

import baseball.Game;
import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
	public static String createRandomNumber() {
		String random = "";

		for (int i = 0; i < 3; i++) {
			int randomNumber = Randoms.pickNumberInRange(Game.min.getDef(), Game.max.getDef());
			randomNumber = relocationNumber(random, randomNumber);
			random += randomNumber;
		}

		return random;
	}
	public static int relocationNumber(String number, int addedNumber) {
		while (checkSameNumber(number, addedNumber)) {
			addedNumber = Randoms.pickNumberInRange(Game.min.getDef(), Game.max.getDef());
		}
		return addedNumber;
	}
	public static boolean checkSameNumber(String number, int addedNumber) {
		return number.contains(String.valueOf(addedNumber));
	}
	public static List<Integer> compareNumber(String computer, String user) {
		List<Integer> result = Arrays.asList(Game.root.getDef(), Game.root.getDef(), Game.root.getDef());
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
			result.set(Game.root.getDef(), i);
			isStrikeOrBall(computer, Character.toString(user.charAt(i)), result);
		}
		//result.add(strike);
		//result.add(ball);

		return result.subList(Game.strike.getDef(),result.size());
	}
	public static boolean checkSameLocation(String computer, String user) {
		return computer.equals(user);
	}
	public static List<Integer> isStrikeOrBall(String computer, String user, List<Integer> result) {
		if (checkSameNumber(computer, Integer.parseInt(user))) {
			if (checkSameLocation(Character.toString(computer.charAt(result.get(Game.root.getDef()))), user)) {
				result.set(Game.strike.getDef(), result.get(Game.strike.getDef()) + 1);
			}
			if (!checkSameLocation(Character.toString(computer.charAt(result.get(Game.root.getDef()))), user)) {
				result.set(Game.ball.getDef(), result.get(Game.ball.getDef()) + 1);
			}
		}
		return result;
	}
}
