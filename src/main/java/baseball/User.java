package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

class User {
	private List<Integer> numbers;

	public User() {
		numbers = new ArrayList<>();
		String stringNumbers = Console.readLine();

		validationNumbersLength(stringNumbers);    //길이가 3인지 확인
		validationNumbersInteger(stringNumbers);    //입력받은게 모두 숫자인지 확인.
		generateNumbers(stringNumbers);
	}

	public void generateNumbers(String stringNumbers) {
		int intNumbers = Integer.parseInt(stringNumbers);
		numbers.add(intNumbers / 100);
		numbers.add((intNumbers % 100) / 10);
		numbers.add((intNumbers % 100) % 10);
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}

	public void validationNumbersLength(String stringNumbers) throws IllegalArgumentException {
		if (stringNumbers.length() != 3) {
			throw new IllegalArgumentException("숫자를 총 3개 입력해주세요.");
		}
	}

	public void validationNumbersInteger(String stringNumbers) throws IllegalArgumentException {

		for (int i = 0; i < stringNumbers.length(); i++) {
			int digit = stringNumbers.charAt(i) - 48;

			if (digit < 1 || digit > 9) throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해주세요.");
			else this.getNumbers().add(digit);
		}
	}
}
