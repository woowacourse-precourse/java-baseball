package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

	@Test
	@DisplayName("컴퓨터가 던진 3개의 랜덤 공 중복 검증")
	void 랜덤값_중복_검증() {
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

	@Test
	@DisplayName("컴퓨터가 던진 3개의 랜덤 공 바운더리 검증")
	void 랜덤값_바운더리_검증() {
		// given
		Computer computer = new Computer();
		int upperBound = 9;
		int lowerBound = 1;
		for (int testCase = 0; testCase < 1000; testCase++) {
			// when
			computer.pitchThreeUniqueBalls();
			List<Integer> computerBalls = computer.getComputerBalls();
			// then
			Assertions.assertThat(isOverUpperBound(computerBalls, upperBound)).isEqualTo(false);
			Assertions.assertThat(isUnderLowerBound(computerBalls, lowerBound)).isEqualTo(false);
		}
	}

	private boolean isOverUpperBound(List<Integer> balls, int upperBound) {
		for (int ball : balls) {
			if (ball > upperBound) {
				return true;
			}
		}
		return false;
	}

	private boolean isUnderLowerBound(List<Integer> balls, int lowerBound) {
		for (int ball : balls) {
			if (ball < lowerBound) {
				return true;
			}
		}
		return false;
	}

	@Test
	@DisplayName("컴퓨터 던진 공 개수 3개 검증")
	void 컴퓨터_던진_공_개수_검증() {
		// given
		Computer computer = new Computer();
		int size = 3;
		// when
		computer.pitchThreeUniqueBalls();
		List<Integer> computerBalls = computer.getComputerBalls();
		// then
		Assertions.assertThat(computerBalls.size()).isEqualTo(size);
	}
}
