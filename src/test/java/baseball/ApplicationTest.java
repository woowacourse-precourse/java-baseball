package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTest extends NsTest {
    @Test
    void 게임_1회_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "137", "135", "2");
                    assertThat(output()).contains("낫싱", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 게임_2회_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("147", "417", "453", "459", "1", "315", "351", "2");
                    assertThat(output()).contains("1볼", "1스트라이크", "2스트라이크", "3스트라이크", "게임 종료",
                            "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                4, 5, 9, 3, 5, 1
        );
    }

    @Test
    void 게임_3회_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("156", "641", "631", "1", "762", "726", "1", "123", "587", "2");
                    assertThat(output()).contains("2볼", "2스트라이크", "3스트라이크", "게임 종료",
                            "2볼 1스트라이크", "3스트라이크", "게임 종료",
                            "낫싱", "3스트라이크", "게임 종료");
                },
                6, 3, 1, 7, 2, 6, 5, 8, 7
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
