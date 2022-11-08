package baseball.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import baseball.model.BaseballResponse;
import baseball.model.MatchDto;

class BaseballServiceTest {

	private final BaseballService baseballService = new BaseballService();

	@Nested
	class Match {

		@Test
		@DisplayName("컴퓨터 숫자 123, 사용자 숫자 124이면 0볼 2스트라이크이다.")
		void case1() throws Exception {
			// given
			final int computerNumber = 123;
			final int userNumber = 124;
			final int expectedBall = 0;
			final int expectedStrike = 2;
			final MatchDto matchDto = MatchDto.of(userNumber, computerNumber);

			// when
			final BaseballResponse result = baseballService.match(matchDto);

			// then
			assertThat(result.getBall()).isEqualTo(expectedBall);
			assertThat(result.getStrike()).isEqualTo(expectedStrike);
		}

		@Test
		@DisplayName("컴퓨터 숫자 123, 사용자 숫자 123이면 0볼 3스트라이크이다.")
		void case2() throws Exception {
			// given
			final int computerNumber = 123;
			final int userNumber = 123;
			final int expectedBall = 0;
			final int expectedStrike = 3;
			final MatchDto matchDto = MatchDto.of(userNumber, computerNumber);

			// when
			final BaseballResponse result = baseballService.match(matchDto);

			// then
			assertThat(result.getBall()).isEqualTo(expectedBall);
			assertThat(result.getStrike()).isEqualTo(expectedStrike);
		}

		@Test
		@DisplayName("컴퓨터 숫자 321, 사용자 숫자 123이면 2볼 1스트라이크이다.")
		void case3() throws Exception {
			// given
			final int computerNumber = 321;
			final int userNumber = 123;
			final int expectedBall = 2;
			final int expectedStrike = 1;
			final MatchDto matchDto = MatchDto.of(userNumber, computerNumber);

			// when
			final BaseballResponse result = baseballService.match(matchDto);

			// then
			assertThat(result.getBall()).isEqualTo(expectedBall);
			assertThat(result.getStrike()).isEqualTo(expectedStrike);
		}

	}

}