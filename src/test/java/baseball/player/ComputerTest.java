package baseball.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class ComputerTest extends NsTest {

	@Test
	void 랜덤_숫자_테스트_1부터_9까지만() {
		Computer computer = new Computer();
		String number = computer.number;
		assertThat(number).matches("^[1-9]*$");
	}

	@Test
	void 서도다른_숫자_3가지() {
		Computer computer = new Computer();
		String number = computer.number;
		String numberDistinctRemove = Arrays.stream(number.split("")).distinct()
				.collect(Collectors.joining());
		assertEquals(numberDistinctRemove, number, "중복 제거");
	}

	@Test
	void 숫자_길이_3() {
		Computer computer = new Computer();
		String number = computer.number;
		assertEquals(3,number.length());
	}

	@Override
	protected void runMain() {

	}
}