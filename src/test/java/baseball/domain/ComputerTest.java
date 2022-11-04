package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerTest {

	@Test
	void computerDuplicatedNumber() {
		Computer computer = new Computer();
		computer.generateNumber();
		int distinctCount = (int)computer.getNumber().stream().distinct().count();

		Assertions.assertThat(computer.getNumber().size()).isEqualTo(distinctCount);
	}
}
