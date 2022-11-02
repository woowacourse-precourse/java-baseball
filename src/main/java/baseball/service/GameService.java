package baseball.service;

import org.mockito.internal.matchers.Null;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
	final int min = 1;
	final int max = 9;

	public String createRandomNumber() {
		String random = "";

		for (int i = 0; i < 3; i++) {
			int randomNumber = Randoms.pickNumberInRange(min, max);
			while (checkEqualNumber(random, randomNumber)) {
				randomNumber = Randoms.pickNumberInRange(min, max);
			}
			random += randomNumber;
		}

		return random;
	}

	public boolean checkEqualNumber(String number, int addedNumber) {
		if (number.contains(String.valueOf(addedNumber)))
			return true;
		return false;
	}

	public void checkException(String number) {
		checkNullException(number);
		isSameWord(number);

		for (int i = 0; i < number.length(); i++) {
			checkUserNumber(Character.getNumericValue(number.charAt(i)));
		}
	}

	public void isSameWord(String number) {
		String tmp = "";

		for (int i = 0; i < number.length(); i++) {
			if (checkEqualNumber(tmp, Character.getNumericValue(number.charAt(i)))) {
				throw new IllegalArgumentException("같은 숫자가 있습니다.");
			}
			tmp += number.charAt(i);
		}
	}
	public void checkUserNumber(int userNumber) {
		if (userNumber < 1 || userNumber > 9) {
			throw new IllegalArgumentException("숫자 범위를 벗어났습니다.");
		}
	}
	public void checkNullException(String number) {
		if (number == null || number.isEmpty())
			throw new IllegalArgumentException("NULL값 에러");
		if (number.length() != 3)
			throw new IllegalArgumentException("숫자 길이 에러");
	}
}
