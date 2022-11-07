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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
