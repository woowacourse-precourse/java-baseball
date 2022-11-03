package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BaseballTest {
	@Nested
	class SplitDigits {
		@Test
		void case1() {
			String threeDigitNumber = "369";
			List<Integer> result = List.of(3, 6, 9);
			assertThat(Baseball.splitDigits(threeDigitNumber)).isEqualTo(result);
		}

		@Test
		void case2() {
			String threeDigitNumber = "4235";
			List<Integer> result = List.of(4, 2, 3, 5);
			assertThat(Baseball.splitDigits(threeDigitNumber)).isEqualTo(result);
		}

		@Test
		void case3() {
			String threeDigitNumber = "";
			List<Integer> result = Collections.emptyList();
			assertThat(Baseball.splitDigits(threeDigitNumber)).isEqualTo(result);
		}
	}

	@Nested
	class make3DigitNumberTest {
		private static final int PLAYING_NUMBER_SIZE = 3;

		@Test
		void case1() {
			for (int i = 0; i < 100000; i++) {
				String threeDigitNumber = Baseball.make3DigitNumber();
				List<Integer> threeNumbers = Baseball.splitDigits(threeDigitNumber);
				Set<Integer> nonDuplicateNumbers = new HashSet<>(threeNumbers);

				assertThat(threeNumbers.size()).isEqualTo(PLAYING_NUMBER_SIZE);
				assertThat(nonDuplicateNumbers.size()).isEqualTo(PLAYING_NUMBER_SIZE);
				for (int number : threeNumbers) {
					assertThat(number).isBetween(1, 9);
				}
			}
		}
	}

}
