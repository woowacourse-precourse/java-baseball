package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import baseball.restrict.RestrictIntegerConstants;

class ComputerTest implements RestrictIntegerConstants {

	@Test
	void makeRandomNumberTest() {
		List<Integer> randomNumberList;
		List<Integer> duplicateCheck = new ArrayList<>();
		Computer computer = new Computer();

		computer.makeRandomNumber();
		randomNumberList = computer.getRandomNumberList();
		for (int randomNumberIndex = 0; randomNumberIndex < LIMIT_LIST_SIZE; randomNumberIndex++) {
			int randomNumber = randomNumberList.get(randomNumberIndex);

			Assertions.assertThat(randomNumber).isBetween(MIN_NUMBER, MAX_NUMBER);
			Assertions.assertThat(duplicateCheck).doesNotContain(randomNumber);
			duplicateCheck.add(randomNumber);
		}
	}

	@Test
	void clearRandomNumberListTest() {
		List<Integer> randomNumberList;
		Computer computer = new Computer();

		computer.makeRandomNumber();
		randomNumberList = computer.getRandomNumberList();
		Assertions.assertThat(randomNumberList).isNotEmpty();

		computer.clearRandomNumberList();
		randomNumberList = computer.getRandomNumberList();
		Assertions.assertThat(randomNumberList).isEmpty();
	}
}
