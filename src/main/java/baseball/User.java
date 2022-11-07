package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

class User {
	private List<Integer> numbers;

	public User() {
		numbers = new ArrayList<>();
		String stringNumbers = Console.readLine();

		generateNumbers(stringNumbers);
		validationNumbersLength();    //길이가 3인지 확인
		validationNumbersInteger();    //입력받은게 모두 숫자인지 확인.
	}

	public void generateNumbers(String stringNumbers) {
		int intNumbers = 0;
		try{
			intNumbers = Integer.parseInt(stringNumbers);
		} catch (IllegalArgumentException e){
			System.out.println("3자리의 숫자 외엔 입력할 수 없습니다.");
		}

		numbers.add(intNumbers / 100);
		numbers.add((intNumbers % 100) / 10);
		numbers.add((intNumbers % 100) % 10);
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
