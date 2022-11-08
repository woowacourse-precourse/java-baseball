package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ComputerNumberTest {
	@Test
	void 숫자_길이_확인() {
		List<Integer> result = new ComputerNumber().getComputerNumber();
		assertEquals(3, result.size());
	}

	@Test
	void 숫자_중복_확인() {
		int result = (int)new ComputerNumber().getComputerNumber().stream().distinct().count();
		assertEquals(3, result);
	}

	@Test
	void 숫자_범위_확인() {
		List<Integer> result = new ComputerNumber().getComputerNumber();

		assertTrue(result.stream().allMatch(num -> 1 < num || num <= 9));
	}
}
