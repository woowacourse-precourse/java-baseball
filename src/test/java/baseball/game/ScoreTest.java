package baseball.game;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ScoreTest {
	Score score;

	@Test
	void 정답과_입력이_같으면_이겨야한다() {
		score = Score.calculate(List.of(1, 2, 3), List.of(1, 2, 3));
		assertThat(score.isWin())
				.isTrue();
	}

	@Test
	void 정답이_123이고_입력이_132_일때_1스트라이크_2볼_이어야한다() {
		score = Score.calculate(List.of(1, 2, 3), List.of(1, 3, 2));
		assertThat(score.getStrike())
				.isEqualTo(1);
		assertThat(score.getBall())
				.isEqualTo(2);
	}

	@Test
	void 정답이_123이고_입력이_124_일때_2스트라이크_0볼_이어야한다() {
		score = Score.calculate(List.of(1, 2, 3), List.of(1, 2, 4));
		assertThat(score.getStrike())
				.isEqualTo(2);
		assertThat(score.getBall())
				.isEqualTo(0);
	}

	@Test
	void 정답이_123이고_입력이_312_일때_0스트라이크_3볼_이어야한다() {
		score = Score.calculate(List.of(1, 2, 3), List.of(3, 1, 2));
		assertThat(score.getStrike())
				.isEqualTo(0);
		assertThat(score.getBall())
				.isEqualTo(3);
	}

	@Test
	void 정답이_123이고_입력이_321_일때_1스트라이크_2볼_이어야한다() {
		score = Score.calculate(List.of(1, 2, 3), List.of(3, 2, 1));
		assertThat(score.getStrike())
				.isEqualTo(1);
		assertThat(score.getBall())
				.isEqualTo(2);
	}

	@Test
	void 정답이_123이고_입력이_456_일때_0스트라이크_0볼_이어야한다() {
		score = Score.calculate(List.of(1, 2, 3), List.of(4, 5, 6));
		assertThat(score.getStrike())
				.isEqualTo(0);
		assertThat(score.getBall())
				.isEqualTo(0);
	}
}