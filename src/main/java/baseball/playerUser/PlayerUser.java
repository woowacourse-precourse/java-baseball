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

	private boolean isNoDuplicatedNumber(String number) {
		Stream<Character> numberStream;
		List<Character> stringToCharacter = new ArrayList<>();
		List<Character> distinctDigits = new ArrayList<>();

		for (char elem : number.toCharArray()) {
			stringToCharacter.add(elem);
		}

		numberStream = stringToCharacter.stream();
		numberStream.distinct().forEach(distinctDigits::add);
		return distinctDigits.size() == 3;
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
