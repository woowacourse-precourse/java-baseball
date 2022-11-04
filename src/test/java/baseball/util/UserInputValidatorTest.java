package baseball.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName(value = "사용자 입력 검증 테스트")
class UserInputValidatorTest {

	@DisplayName("게임 내 숫자 예측 입력에 대한 테스트")
	@Nested
	class PlayPageUserInputTest {
		@Test
		public void 게임_숫자_입력시_숫자가_아닌_경우_예외_발생() {
			String userInput = "12a";

			Assertions.assertThatThrownBy(() -> UserInputValidator.validatePlayNumbers(userInput))
				.isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		public void 게임_숫자_입력시_세자리가_아닌_경우_예외_발생() {
			String userInput = "1234";

			Assertions.assertThatThrownBy(() -> UserInputValidator.validatePlayNumbers(userInput))
				.isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		public void 게임_숫자_입력시_중복되는_숫자가_있으면_예외_발생() {
			String userInput = "121";

			Assertions.assertThatThrownBy(() -> UserInputValidator.validatePlayNumbers(userInput))
				.isInstanceOf(IllegalArgumentException.class);
		}
	}

	@DisplayName("재시작 여부 입력에 대한 테스트")
	@Nested
	class RestartPageUserInputTest {
		@Test
		public void 재시작_여부_입력시_범위_밖의_숫자가_있으면_예외_발생() {
			String errorRangeInput = "3";

			Assertions.assertThatThrownBy(() -> UserInputValidator.validateRestartCode(errorRangeInput))
				.isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		public void 재시작_여부_입력시_한자리가_아닌_경우_예외_발생() {
			//given
			String errorLengthInput = "123";

			Assertions.assertThatThrownBy(() -> UserInputValidator.validateRestartCode(errorLengthInput))
				.isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		public void 재시작_여부_입력시_숫자가_아닌_경우_예외_발생() {
			//given
			String notNumberInput = "재시작";

			Assertions.assertThatThrownBy(() -> UserInputValidator.validateRestartCode(notNumberInput))
				.isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		public void 재시작_여부_입력시_빈_값인_경우_예외_발생() {
			//given
			String notNumberInput = "";

			Assertions.assertThatThrownBy(() -> UserInputValidator.validateRestartCode(notNumberInput))
				.isInstanceOf(IllegalArgumentException.class);
		}

	}
}