package baseball.game;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class GameTest extends NsTest {

    @Test
    void 게임시작시_시작메세지가_출력돼야한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "2");
                    assertThat(output()).contains("숫자 야구 게임을 시작합니다.");
                },
                1,2,3
        );
    }

    @Test
    void 재시작시_잘못된_입력을_하면_예외가_발생한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("123","3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("1 또는 2만 입력해주세요.");
                },
                1,2,3
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}