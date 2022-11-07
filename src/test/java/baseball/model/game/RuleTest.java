package baseball.model.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RuleTest {
	Rule rule = new Rule();

	@DisplayName("스트라이크를 확인한다")
	@Test
	void verifyStrike() {
		assertThat(rule.isStrike(2, 1, 2, 1)).isTrue();
	}

	@DisplayName("볼을 확인한다")
	@Test
	void verifyBall() {
		assertThat(rule.isBall(6, 5, 6, 2)).isTrue();
	}
}
