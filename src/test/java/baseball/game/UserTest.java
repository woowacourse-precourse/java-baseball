package baseball.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
	User user;

	@BeforeEach
	void setUp() {
		user = new User();
	}

	@Test
	void 사용자의_입력이_3자리가_아니면_예외가_발생한다() {
		assertThatThrownBy(() -> user.setNumbers("1111"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("1~9까지 3자리 숫자를 입력해주세요.");
	}

	@Test
	void 사용자의_입력이_정수가_아니면_예외가_발생한다() {
		assertThatThrownBy(() -> user.setNumbers("12삼"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("1~9까지 정수만 입력해주세요.");
	}

	@Test
	void 사용자의_입력에_중복이_있으면_예외가_발생한다() {
		assertThatThrownBy(() -> user.setNumbers("112"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("중복된 입력은 허용하지 않습니다.");
	}
}