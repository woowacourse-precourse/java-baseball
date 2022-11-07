package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

class PitcherTest {
	private final int PLAYING_NUMBER_SIZE = 3;
	private final int MIN_NUMBER = 1;
	private final int MAX_NUMBER = 9;
	private final String REGEX = String.format("^[%d-%d]*$", MIN_NUMBER, MAX_NUMBER);
	Pattern numberPattern = Pattern.compile(REGEX);

	@Test
	void case1() {
		for (int i = 0; i < 10_000_000; i++) {
			Pitcher pitcher = new Pitcher();
			int threeDigitNumber = pitcher.getPlayingNumber();
			List<Integer> threeNumbers = pitcher.getPlayingNumbers();
			Set<Integer> nonDuplicateNumbers = new HashSet<>(threeNumbers);
			int threeNumber = threeNumbers.get(0) * 100 + threeNumbers.get(1) * 10 + threeNumbers.get(2);
			boolean resultOfREGEX = numberPattern.matcher(Integer.toString(threeDigitNumber)).matches();

			assertThat(threeDigitNumber).isEqualTo(threeNumber);
			assertThat(threeNumbers.size()).isEqualTo(PLAYING_NUMBER_SIZE);
			assertThat(nonDuplicateNumbers.size()).isEqualTo(PLAYING_NUMBER_SIZE);
			assertThat(resultOfREGEX).isTrue();
		}
	}
}
