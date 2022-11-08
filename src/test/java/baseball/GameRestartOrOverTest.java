package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class GameRestartOrOverTest extends NsTest {

    @Test
    void 사용자가_1이나_2_이외의_값을_입력했을_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Application.gameRestartOrOver("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임을_종료할_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    Application.gameRestartOrOver("2");
                    assertThat(output()).contains("게임이 종료되었습니다");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Override
    protected void runMain() {
        try {
            Application.main(new String[]{});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
