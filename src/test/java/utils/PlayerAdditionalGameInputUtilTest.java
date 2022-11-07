package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerAdditionalGameInputUtilTest {

	@Test
	@DisplayName("게임 재시작 예외 검증")
	void 게임_재시작_입력_예외_검증() {
		// given, when
		String playerWrongInput = "3";
		String playerWrongInputTwo = "!";
		
		//then
		Assertions.assertThatThrownBy(() -> PlayerAdditionalGameInputUtil.checkOtherInputException(playerWrongInput))
				.isInstanceOf(IllegalArgumentException.class);
		Assertions.assertThatThrownBy(() -> PlayerAdditionalGameInputUtil.checkOtherInputException(playerWrongInputTwo))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
