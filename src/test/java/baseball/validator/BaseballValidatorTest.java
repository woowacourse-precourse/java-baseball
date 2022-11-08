package baseball.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import baseball.model.BaseballRequest;
import baseball.model.RestartOrExitRequest;

class BaseballValidatorTest {

	private final BaseballValidator baseballValidator = new BaseballValidator();

	@Nested
	class Validate_BaseballRequest {

		@Test
		@DisplayName("요청 숫자가 3자리 미만이면 false를 반환한다.")
		void case1() throws Exception {
			// given
			final int number = 99;
			final BaseballRequest request = BaseballRequest.of(number);

			// when
			final boolean result = baseballValidator.validate(request);

			// then
			assertThat(result).isFalse();
		}

		@Test
		@DisplayName("요청 숫자가 3자리 초과면 false를 반환한다.")
		void case2() throws Exception {
			// given
			final int number = 1000;
			final BaseballRequest request = BaseballRequest.of(number);

			// when
			final boolean result = baseballValidator.validate(request);

			// then
			assertThat(result).isFalse();
		}

		@Test
		@DisplayName("3자리 숫자 중 중복 숫자가 존재하면 false를 반환한다.")
		void case3() throws Exception {
			// given
			final int number = 121;
			final BaseballRequest request = BaseballRequest.of(number);

			// when
			final boolean result = baseballValidator.validate(request);

			// then
			assertThat(result).isFalse();
		}

		@Test
		@DisplayName("서로 다른 3자리 숫자면 true를 반환한다.")
		void case4() throws Exception {
			// given
			final int number = 123;
			final BaseballRequest request = BaseballRequest.of(number);

			// when
			final boolean result = baseballValidator.validate(request);

			// then
			assertThat(result).isTrue();
		}

	}

	@Nested
	class Validate_RestartOrExitRequest {

		@Test
		@DisplayName("type이 1이면 true를 반환한다.")
		void case1() throws Exception {
			// given
			final int type = 1;
			final RestartOrExitRequest request = RestartOrExitRequest.of(type);

			// when
			final boolean result = baseballValidator.validate(request);

			// then
			assertThat(result).isTrue();
		}

		@Test
		@DisplayName("type이 2이면 true를 반환한다.")
		void case2() throws Exception {
			// given
			final int type = 2;
			final RestartOrExitRequest request = RestartOrExitRequest.of(type);

			// when
			final boolean result = baseballValidator.validate(request);

			// then
			assertThat(result).isTrue();
		}

		@Test
		@DisplayName("type이 1이나 2가 아니면 false를 반환한다.")
		void case3() throws Exception {
			// given
			final int type = 3;
			final RestartOrExitRequest request = RestartOrExitRequest.of(type);

			// when
			final boolean result = baseballValidator.validate(request);

			// then
			assertThat(result).isFalse();
		}

	}

}