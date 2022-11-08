package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Computer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
	@Test
	@DisplayName("컴퓨터 숫자 중복 테스트")
	public void computerNumbersOverlapTest() {
		Computer computer = new Computer();
		List<Integer> computerNumbers = computer.getNumbers();
		Set<Integer> computerNumberSet = new HashSet<>(computerNumbers);

		assertThat(computerNumberSet.size()).isEqualTo(computerNumbers.size());
	}

	@Test
	@DisplayName("컴퓨터 숫자 범위 테스트")
	public void computerNumbersRangeTest() {
		final int START_NUMBER = 1;
		final int END_NUMBER = 9;
		Computer computer = new Computer();
		List<Integer> computerNumbers = computer.getNumbers();

		computerNumbers.stream()
			.forEach(number -> assertThat(number)
				.isGreaterThan(START_NUMBER - 1)
				.isLessThan(END_NUMBER + 1));
	}

	@Test
	@DisplayName("컴퓨터 숫자 길이 테스트")
	public void computerNumbersLengthTest() {
		final int PERMIT_LENGTH = 3;
		Computer computer = new Computer();
		List<Integer> computerNumbers = computer.getNumbers();

		assertThat(computerNumbers.size()).isEqualTo(PERMIT_LENGTH);
	}
}
