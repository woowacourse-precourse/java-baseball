package baseball.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

	@Test
	void generateRandomNumber_메소드로_서로_다른_세개의_숫자_선택() {
		//when, then
		assertThat(RandomNumberGenerator.generate()).doesNotHaveDuplicates();
	}
}