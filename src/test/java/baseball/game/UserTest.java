package baseball.game;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest extends NsTest {
	User user;

	@BeforeEach
	void setUp() {
		user = new User();
	}

	@Test
	void 사용자의_입력이_3자리가_아니면_예외가_발생한다() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("1111"))
						.isInstanceOf(IllegalArgumentException.class)
						.hasMessage("1~9까지 3자리 숫자를 입력해주세요.")
		);
	}

	@Test
	void 사용자의_입력이_정수가_아니면_예외가_발생한다() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("12삼"))
						.isInstanceOf(IllegalArgumentException.class)
						.hasMessage("1~9까지 정수만 입력해주세요.")
		);
	}

	@Test
	void 사용자의_입력에_중복이_있으면_예외가_발생한다() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException("112"))
						.isInstanceOf(IllegalArgumentException.class)
						.hasMessage("중복된 입력은 허용하지 않습니다.")
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}
}