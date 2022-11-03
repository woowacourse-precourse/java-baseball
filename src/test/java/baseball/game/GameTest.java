package baseball.game;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class GameTest extends NsTest {

	@Test
	void 게임시작시_시작메세지가_출력돼야한다() {
		assertSimpleTest(
				() -> {
					runMain();
					assertThat(output().equals("숫자 야구 게임을 시작합니다."))
							.isTrue();
				}
		);
	}

	@Test
	void 사용자의_입력이_3자리가_아니면_예외가_발생한다() {
		Game game = Game.create();
		assertThatThrownBy(() -> game.validateUserInput("12"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("1~9까지 3자리 숫자를 입력해주세요.");
	}

	@Test
	void 사용자의_입력이_정수가_아니면_예외가_발생한다() {
		Game game = Game.create();
		assertThatThrownBy(() -> game.validateUserInput("12삼"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("1~9까지 정수만 입력해주세요.");
	}


	@Override
	protected void runMain() {
		Application.main(new String[]{});
	}
}