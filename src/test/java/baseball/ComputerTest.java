package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

	@Test
	@DisplayName("컴퓨터가 던진 3개의 공 중복 검증")
	void 컴퓨터가_던진_3개의공_중복_검증() {
		// given
		Computer computer = new Computer();
		// when
		for (int testCase = 0; testCase < 1000; testCase++) {
			computer.pitchThreeUniqueBalls();
			List<Integer> computerBalls = computer.getComputerBalls();
			// then
			Assertions.assertThat(isDuplicate(computerBalls)).isEqualTo(false);
		}
	}

	private boolean isDuplicate(List<Integer> balls) {
		Set<Integer> uniqueBalls = new HashSet<>();
		for (int ball : balls) {
			if (uniqueBalls.contains(ball)) {
				return true;
			}
			uniqueBalls.add(ball);
		}
		return false;
	}
}
