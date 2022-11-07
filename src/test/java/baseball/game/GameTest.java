package baseball.game;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class GameTest extends NsTest {

    @Test
    void 게임시작시_시작메세지가_출력되어야한다() {
        assertSimpleTest(
                () -> {
                    runMain();
                    assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.");
                }
        );
    }

    @Test
    void 사용자가_잘못된_입력을_할_경우_예외_처리_해야한다() {
        Game game = Game.create();
        assertThatThrownBy(() -> game.inputCheck("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리 입력만 가능합니다.");

        assertThatThrownBy(() -> game.inputCheck("000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9까지의 숫자만 입력이 가능합니다.");

        assertThatThrownBy(() -> game.inputCheck("b2a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9까지의 숫자만 입력이 가능합니다.");

        assertThatThrownBy(() -> game.inputCheck("112"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 수만 입력이 가능합니다.");

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
