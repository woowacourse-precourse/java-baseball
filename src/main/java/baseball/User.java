package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class User {
	private List<Integer> numbers;

	public User(String stringNumbers) {
		numbers = new ArrayList<>();

		generateNumbers(stringNumbers);
		validationNumbersLength();    //길이가 3인지 확인
		validationNumbersInteger();    //입력받은게 모두 숫자인지 확인.
	}

	public void generateNumbers(String stringNumbers){
		for (int i=0;i<stringNumbers.length();i++){
			numbers.add(Integer.parseInt(stringNumbers.substring(i,i+1)));
		}
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}

	public void validationNumbersLength() throws IllegalArgumentException {
		if (numbers.size() != 3) {
			throw new IllegalArgumentException("숫자를 총 3개 입력해주세요.");
		}
	}

	public void validationNumbersInteger() throws IllegalArgumentException {
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) < 1 || numbers.get(i) > 9) throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해주세요.");
		}
	}
}
