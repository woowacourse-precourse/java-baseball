package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {

	@DisplayName("숫자만으로 이루어진 입력인지 검증")
	@Test
	void 숫자_입력_검증() {

		// 영문자
		assertThatThrownBy(
			() -> ValidationUtils.validateInput("abc")
		).isInstanceOf(IllegalArgumentException.class);

		// 한글
		assertThatThrownBy(
			() -> ValidationUtils.validateInput("가나다라마바사")
		).isInstanceOf(IllegalArgumentException.class);

		// 특수문자
		assertThatThrownBy(
			() -> ValidationUtils.validateInput("◀▲▶▼⇓①◦→⁍•⁸⅕⅔")
		).isInstanceOf(IllegalArgumentException.class);

		// 이모지
		assertThatThrownBy(
			() -> ValidationUtils.validateInput("\uD83D\uDCEE\uD83D\uDD0D")
		).isInstanceOf(IllegalArgumentException.class);

		// 섞여있는 경우
		assertThatThrownBy(
			() -> ValidationUtils.validateInput("\uD83D23◀▲▶▼⇓①356뮤ar")
		).isInstanceOf(IllegalArgumentException.class);

		assertDoesNotThrow(() -> ValidationUtils.validateInput("123"));
	}
}
