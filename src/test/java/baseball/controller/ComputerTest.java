package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class RandomNumberTest {
	@Test
	public void randomNumberOverlapTest() {
		RandomNumber randomNumber = new RandomNumber();
		List<Integer> randomNumbers = randomNumber.getNumbers();
		int answer = randomNumbers.size();
		Set<Integer> randomNumberSet = new HashSet<>();

		randomNumbers.stream()
			.forEach(number -> randomNumberSet.add(number));

		assertThat(randomNumberSet.size()).isEqualTo(answer);
	}

	@Test
	public void randomNumberRangeTest() {
		final int START_NUMBER = 1;
		final int END_NUMBER = 9;
		RandomNumber randomNumber = new RandomNumber();
		List<Integer> randomNumbers = randomNumber.getNumbers();

		randomNumbers.stream()
			.forEach(number -> assertThat(number)
				.isGreaterThan(START_NUMBER - 1)
				.isLessThan(END_NUMBER + 1));
	}

	@Test
	public void randomNumberLengthTest() {
		RandomNumber randomNumber = new RandomNumber();
		List<Integer> randomNumbers = randomNumber.getNumbers();
		final int PERMIT_LENGTH = 3;

		assertThat(randomNumbers.size()).isEqualTo(PERMIT_LENGTH);
	}
}
