package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	@DisplayName("볼인 경우")
	public void getBallStrikeCountTest1() {
		List<Integer> randomNumberList = Arrays.asList(1, 4, 7);
		List<Integer> gameNumberList = Arrays.asList(4, 3, 9);
		List<Integer> ballStrikeCount = Calculator.getBallStrikeCount(randomNumberList, gameNumberList);
		List<Integer> result = Arrays.asList(1, 0);

		assertThat(ballStrikeCount).isEqualTo(result);
	}

	@Test
	@DisplayName("볼, 스트라이크인 경우")
	public void getBallStrikeCountTest2() {
		List<Integer> randomNumberList = Arrays.asList(3, 4, 9);
		List<Integer> gameNumberList = Arrays.asList(4, 3, 9);
		List<Integer> ballStrikeCount = Calculator.getBallStrikeCount(randomNumberList, gameNumberList);
		List<Integer> result = Arrays.asList(2, 1);

		assertThat(ballStrikeCount).isEqualTo(result);
	}

	@Test
	@DisplayName("낫싱인 경우")
	public void getBallStrikeCountTest3() {
		List<Integer> randomNumberList = Arrays.asList(2, 5, 8);
		List<Integer> gameNumberList = Arrays.asList(4, 3, 9);
		List<Integer> ballStrikeCount = Calculator.getBallStrikeCount(randomNumberList, gameNumberList);
		List<Integer> result = Arrays.asList(0, 0);

		assertThat(ballStrikeCount).isEqualTo(result);
	}

	@Test
	@DisplayName("3스트라이크인 경우")
	public void getBallStrikeCountTest4() {
		List<Integer> randomNumberList = Arrays.asList(4, 3, 9);
		List<Integer> gameNumberList = Arrays.asList(4, 3, 9);
		List<Integer> ballStrikeCount = Calculator.getBallStrikeCount(randomNumberList, gameNumberList);
		List<Integer> result = Arrays.asList(0, 3);

		assertThat(ballStrikeCount).isEqualTo(result);
	}
}
