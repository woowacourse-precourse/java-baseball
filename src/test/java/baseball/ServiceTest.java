package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import baseball.service.GameService;

public class ServiceTest {
	@Test
	void checkSameLocationTest() {
		assertTrue(GameService.checkSameLocation("1", "1"));
	}
	@Test
	void checkSameLocationTest2() {
		assertFalse(GameService.checkSameLocation("1", "2"));
	}
	@Test
	void checkCompareNumber() {
		assertThat(GameService.compareNumber("123",
				"456")).isEqualTo(Arrays.asList(0, 0));
	}
}
