package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ComputerNumberTest {
	@Test
	void 숫자_길이_테스트() {
		List<Integer> result = new ComputerNumber().computerNumber;
		assertEquals(3, result.size());
	}
}
