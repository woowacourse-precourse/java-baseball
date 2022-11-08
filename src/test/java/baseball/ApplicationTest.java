package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 입력_글자_수_예외_테스트() {

        assertThatThrownBy(() -> Application.isValidNumber("1234"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Application.isValidNumber("21"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Application.isValidNumber("7"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Application.isValidNumber("774"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Application.isValidNumber("007"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Application.isValidNumber("1b3"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Application.isValidNumber(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Application.isValidNumber("\n"))
                .isInstanceOf(IllegalArgumentException.class);


    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}