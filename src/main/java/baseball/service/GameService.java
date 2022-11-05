package baseball.service;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
	private enum Game{
		min(1),
		max(9),
		strike(1),
		ball(2),
		root(0);
		public final int def;
		Game(int judge) {
			this.def = judge;
		}
	}
	public static String createRandomNumber() {
		String random = "";

		for (int i = 0; i < 3; i++) {
			int randomNumber = Randoms.pickNumberInRange(Game.min.def, Game.max.def);
			randomNumber = relocationNumber(random, randomNumber);
			random += randomNumber;
		}

		return random;
	}
	public static int relocationNumber(String number, int addedNumber) {
		while (checkSameNumber(number, addedNumber)) {
			addedNumber = Randoms.pickNumberInRange(Game.min.def, Game.max.def);
		}
		return addedNumber;
	}
	public static boolean checkSameNumber(String number, int addedNumber) {
		return number.contains(String.valueOf(addedNumber));
	}
	public static List<Integer> compareNumber(String computer, String user) {
		List<Integer> result = Arrays.asList(Game.root.def, Game.root.def, Game.root.def);
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
			result.set(Game.root.def, i);
			isStrikeOrBall(computer, Character.toString(user.charAt(i)), result);
		}
		//result.add(strike);
		//result.add(ball);

		return result.subList(Game.strike.def,result.size());
	}
	public static boolean checkSameLocation(String computer, String user) {
		return computer.equals(user);
	}
	public static List<Integer> isStrikeOrBall(String computer, String user, List<Integer> result) {
		if (checkSameNumber(computer, Integer.parseInt(user))) {
			if (checkSameLocation(Character.toString(computer.charAt(result.get(Game.root.def))), user)) {
				result.set(Game.strike.def, result.get(Game.strike.def) + 1);
			}
			if (!checkSameLocation(Character.toString(computer.charAt(result.get(Game.root.def))), user)) {
				result.set(Game.ball.def, result.get(Game.ball.def) + 1);
			}
		}
		return result;
	}
}
