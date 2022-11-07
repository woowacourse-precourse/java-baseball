package baseball.service;

import java.util.Arrays;
import java.util.List;

import baseball.dto.BaseballDto;
import baseball.utils.Game;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballService {
	public static String createRandomNumber() {
		int randomNumber;
		String random = "";

		for (int i = 0; i < Game.size.getValue(); i++) {
			randomNumber = Randoms.pickNumberInRange(Game.min.getValue(), Game.max.getValue());
			random += relocateNumber(random, randomNumber);
		}

		return random;
	}

	public static int relocateNumber(String number, int addedNumber) {
		while (checkSameNumber(number, addedNumber)) {
			addedNumber = Randoms.pickNumberInRange(Game.min.getValue(), Game.max.getValue());
		}
		return addedNumber;
	}

	public static boolean checkSameNumber(String number, int addedNumber) {
		return number.contains(String.valueOf(addedNumber));
	}

	public static List<Integer> compareNumber() {
		String computer = BaseballDto.getComputer();
		String user = BaseballDto.getUser();
		List<Integer> result = Arrays.asList(Game.root.getValue(), Game.root.getValue(),
				Game.root.getValue()); // 0으로 초기화

		for (int i = 0; i < computer.length(); i++) {
			result.set(Game.root.getValue(), i);
			isStrikeOrBall(computer, Character.toString(user.charAt(i)), result);
		}

		return result.subList(Game.strike.getValue(), result.size());
	}

	public static boolean checkSameLocation(String computer, String user) {
		return computer.equals(user);
	}

	public static void isStrikeOrBall(String computer, String user, List<Integer> result) {
		int index = result.get(Game.root.getValue());

		if (checkSameNumber(computer, Integer.parseInt(user))) {
			if (checkSameLocation(Character.toString(computer.charAt(index)), user)) {
				result.set(Game.strike.getValue(), (result.get(Game.strike.getValue()) + 1));
			}
			if (!(checkSameLocation(Character.toString(computer.charAt(index)), user))) {
				result.set(Game.ball.getValue(), (result.get(Game.ball.getValue()) + 1));
			}
		}
	}
}
