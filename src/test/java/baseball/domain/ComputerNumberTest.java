package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ComputerNumberTest {
	@Test
	void Random_길이_테스트() {
		List<Integer> result = ComputerNumber.createRandomNumber();
		assertEquals(3, result.size());
	}
}
