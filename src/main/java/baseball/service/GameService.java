package baseball.service;

import java.util.ArrayList;
import java.util.List;

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

	public List<String> convertStringToList(String word) {
		List<String> list = new ArrayList<>();

		for (int i = 0; i < word.length(); i++)
			list.add(String.valueOf(word.charAt(i)));
		return list;
	}
	public List<Integer> compareNumber(List<String> computer, List<String> user) {
		List<Integer> result = new ArrayList<>();
		int cnt = 0;
		int strike = 0;

		for (int i = 0; i < computer.size(); i++) {
			if (checkEqualNumber(String.join("", computer), Integer.parseInt(user.get(i)))) {
				if (removeSameNumber(computer.get(i), user.get(i))) {
					strike++;
					continue;
				}
				cnt++;
			}
		}
		result.add(strike);
		result.add(cnt);

		return result;
	}

	public boolean removeSameNumber(String computer, String user) {
		if (computer.equals(user)) {
			return true;
		}
		return false;
	}
	/*
	예외 처리
	 */
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
