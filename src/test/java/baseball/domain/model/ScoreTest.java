package baseball.domain.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {

	@Test
	@DisplayName("Score의 Enum Map을 Enum.value : 0 형태로 초기화")
	void Score_초기화_확인() {
		Map<BallCount, Integer> map = Map.of(
			BallCount.OUT, 0,
			BallCount.BALL, 0,
			BallCount.STRIKE, 0
		);
		assertThat(new Score()).isEqualTo(new Score(map));
	}
}