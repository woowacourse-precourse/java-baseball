package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameStartControllerTest extends NsTest {

    @Test
    void 시작과_종료_문구_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("숫자 야구 게임을 시작하겠습니다.","종료 되었습니다.");
                },
                1, 3, 5
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
