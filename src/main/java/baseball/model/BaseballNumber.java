package baseball.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class BaseballNumber {
	private static final int DIGIT = 3;
	protected List<Integer> numbers;

	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(numbers);
	}

	protected void checkValidation(List<Integer> numbers) {
		numberIsNotNull(numbers);
		numberSizeIsCorrect(numbers);
		numberInRange(numbers);
		numberIsNotDuplicate(numbers);
	}

	private void numberIsNotNull(List<Integer> numbers) {
		if (numbers == null)
			throw new IllegalArgumentException("입력된 값이 null입니다.");
		for (Integer number : numbers) {
			if (number == null) {
				throw new IllegalArgumentException("입력된 값의 멤버가 null입니다.");
			}
		}
	}

	private void numberSizeIsCorrect(List<Integer> numbers) {
		if (numbers.size() != DIGIT)
			throw new IllegalArgumentException("입력된 수가 세 자리수가 아닙니다.");
	}

	private void numberInRange(List<Integer> numbers) {
		for (Integer number : numbers) {
			if (number < 1 || number > 9)
				throw new IllegalArgumentException("입력된 수가 세 자리수가 아닙니다.");
		}
	}

	private void numberIsNotDuplicate(List<Integer> numbers){
		Set<Integer> numbersSet = new HashSet<>(numbers);
		if(numbers.size() != numbersSet.size())
			throw new IllegalArgumentException("입력된 수에 중복이 있습니다.");
	}
}
