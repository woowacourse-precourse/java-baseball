package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BaseballResponseTest {

	@Nested
	class IsStrikeOut {

		@Test
		@DisplayName("스트라이크 카운트가 3미만이면 false를 반환한다.")
		void case1() throws Exception {
			// given
			final int strike = 1;
			final int ball = 0;
			final BaseballResponse response = BaseballResponse.of(strike, ball);

			// when
			final boolean result = response.isStrikeOut();

			// then
			assertThat(result).isFalse();
		}

		@Test
		@DisplayName("스트라이크 카운트가 3이면 true를 반환한다.")
		void case2() throws Exception {
			// given
			final int strike = 3;
			final int ball = 0;
			final BaseballResponse response = BaseballResponse.of(strike, ball);

			// when
			final boolean result = response.isStrikeOut();

			// then
			assertThat(result).isTrue();
		}

	}

	@Nested
	class IsNothing {

		@Test
		@DisplayName("스트라이크와 볼 카운트가 모두 0이면 true를 반환한다.")
		void case1() throws Exception {
			// given
			final int strike = 0;
			final int ball = 0;
			final BaseballResponse response = BaseballResponse.of(strike, ball);

			// when
			final boolean result = response.isNothing();

			// then
			assertThat(result).isTrue();
		}

		@Test
		@DisplayName("스트라이크와 볼 카운트 중 하나라도 0이 아니면 false를 반환한다.")
		void case2() throws Exception {
			// given
			final int strike = 0;
			final int ball = 1;
			final BaseballResponse response = BaseballResponse.of(strike, ball);

			// when
			final boolean result = response.isNothing();

			// then
			assertThat(result).isFalse();
		}

	}

	@Nested
	class ToString {

		@Test
		@DisplayName("스트라이크 카운트가 3이면 3스트라이크를 반환한다.")
		void case1() throws Exception {
			// given
			final int strike = 3;
			final int ball = 0;
			final BaseballResponse response = BaseballResponse.of(strike, ball);
			final String expected = "3스트라이크";

			// when
			final String result = response.toString();

			// then
			assertThat(result).isEqualTo(expected);
		}

		@Test
		@DisplayName("스트라이크 카운트가 1이고 볼 카운트가 2면 2볼 1스트라이크를 반환한다.")
		void case2() throws Exception {
			// given
			final int strike = 1;
			final int ball = 2;
			final BaseballResponse response = BaseballResponse.of(strike, ball);
			final String expected = "2볼 1스트라이크";

			// when
			final String result = response.toString();

			// then
			assertThat(result).isEqualTo(expected);
		}

		@Test
		@DisplayName("스트라이크와 볼 카운트 모두 0이면 낫싱을 반환한다.")
		void case3() throws Exception {
			// given
			final int strike = 0;
			final int ball = 0;
			final BaseballResponse response = BaseballResponse.of(strike, ball);
			final String expected = "낫싱";

			// when
			final String result = response.toString();

			// then
			assertThat(result).isEqualTo(expected);
		}

	}

}