package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Nested
    class ResultTest {
        @Test
        void 잘못된점수_음수_테스트() {
            int score = -1;
            assertThatThrownBy(() -> Result.getResultByCode(score))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 잘못된점수_enum에_포함되지_않는경우_테스트() {
            int score = 4;
            assertThatThrownBy(() -> Result.getResultByCode(score))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class StatusTest {
        @Test
        void 잘못된옵션_음수_테스트() {
            int option = -1;
            assertThatThrownBy(() -> Status.getStatusByGameOption(option))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 잘못된옵션_2보다_큰수_테스트() {
            int option = 3;
            assertThatThrownBy(() -> Status.getStatusByGameOption(option))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
