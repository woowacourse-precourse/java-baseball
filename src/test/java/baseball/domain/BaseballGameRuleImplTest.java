package baseball.domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseballGameRuleImplTest {

	@Test
	void makeResultByGameRuleTest() {
		List<Integer> status;
		List<Integer> result;
		GameRule<Integer> baseballGameRule = new BaseballGameRuleImpl();

		status = null;
		baseballGameRule.makeResultByGameRule(status);
		result = baseballGameRule.getResultByGameRule();
		Assertions.assertThat(result).isEmpty();

		status = List.of(1, 2, 2, 3);
		baseballGameRule.makeResultByGameRule(status);
		result = baseballGameRule.getResultByGameRule();
		Assertions.assertThat(result).isEmpty();

		status = List.of(1, 2, 3, 1, 2, 3);
		baseballGameRule.makeResultByGameRule(status);
		result = baseballGameRule.getResultByGameRule();
		Assertions.assertThat(result).contains(0, 3);

		status = List.of(1, 2, 3, 1, 4, 3);
		baseballGameRule.makeResultByGameRule(status);
		result = baseballGameRule.getResultByGameRule();
		Assertions.assertThat(result).contains(0, 2);

		status = List.of(1, 3, 2, 1, 2, 3);
		baseballGameRule.makeResultByGameRule(status);
		result = baseballGameRule.getResultByGameRule();
		Assertions.assertThat(result).contains(2, 1);

		status = List.of(1, 2, 3, 1, 3, 4);
		baseballGameRule.makeResultByGameRule(status);
		result = baseballGameRule.getResultByGameRule();
		Assertions.assertThat(result).contains(1, 1);

		status = List.of(1, 2, 3, 3, 1, 2);
		baseballGameRule.makeResultByGameRule(status);
		result = baseballGameRule.getResultByGameRule();
		Assertions.assertThat(result).contains(3, 0);

		status = List.of(1, 2, 3, 4, 5, 6);
		baseballGameRule.makeResultByGameRule(status);
		result = baseballGameRule.getResultByGameRule();
		Assertions.assertThat(result).contains(0, 0);
	}

	@Test
	void getResultByGameRuleTest() {
		List<Integer> status;
		List<Integer> result;
		GameRule<Integer> baseballGameRule = new BaseballGameRuleImpl();

		result = baseballGameRule.getResultByGameRule();
		Assertions.assertThat(result).isEmpty();

		status = List.of(1, 2, 3, 1, 2);
		baseballGameRule.makeResultByGameRule(status);
		result = baseballGameRule.getResultByGameRule();
		Assertions.assertThat(result).isEmpty();

		status = List.of(1, 2, 3, 1, 2, 3);
		baseballGameRule.makeResultByGameRule(status);
		result = baseballGameRule.getResultByGameRule();
		Assertions.assertThat(result).contains(0, 3);
	}
}
