package baseball.playerUser;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PlayerUser {
	private static final PlayerUser instance = new PlayerUser();

	private PlayerUser() {
	}

	public static PlayerUser getInstance() {
		return instance;
	}

	public String getInputNumber() {
		String number = inputNumber();

		if (isExceptionalInput(number)) {
			throw new IllegalArgumentException();
		}

		return number;
	}

	private String inputNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		return Console.readLine();
	}

	private boolean isExceptionalInput(String number) {
		return !isRightNumberSize(number) || !isPositiveNumber(number) || !isNoDuplicatedNumber(
			number);
	}

	// todo : indent가 3이상 -> 리팩토링 필요
	private boolean isNoDuplicatedNumber(String number) {
		int numberSize = number.length();
		for (int i = 0; i < numberSize - 1; i++) {
			String subNumber = number.substring(i + 1);
			String digit = "" + number.charAt(i);
			if (subNumber.contains(digit))
				return false;
		}
		return true;
	}

	private boolean isPositiveNumber(String number) {
		Stream<Character> numberStream;
		List<Character> stringToCharacter = new ArrayList<>();

		for (char elem : number.toCharArray()) {
			stringToCharacter.add(elem);
		}
		numberStream = stringToCharacter.stream();

		return numberStream.noneMatch(elem -> elem < '1' || elem > '9');
	}

	private boolean isRightNumberSize(String number) {
		return number.length() == 3;
	}
}
