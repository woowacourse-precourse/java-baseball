package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2"); // 값을 하나씩 입력하면서 게임 진행
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료"); // outputStream 값들 테스트
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Nested
    class InputExceptionTest {
        @Test
        void 예외_테스트1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> StrikeZone("1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 예외_테스트2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> StrikeZone("12"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 에외_테스트3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> StrikeZone("123"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    class JudgementTest {
        @Test
        @DisplayName("1스트라이크")
        void strike1() {
            Referee referee = new Referee();
            assertThat(referee.judge(new StrikeZone("234"), new StrikeZone("222"))).isEqualTo("1스트라이크");
        }

        @Test
        @DisplayName("1스트라이크")
        void strike1_2() {
            Referee referee = new Referee();
            assertThat(referee.judge(new StrikeZone("222"), new StrikeZone("234"))).isEqualTo("1스트라이크");
        }

        @Test
        @DisplayName("1볼: 볼값이 Swing에 2개 있는 경우")
        void ball1() {
            Referee referee = new Referee();
            assertThat(referee.judge(new StrikeZone("262"), new StrikeZone("324"))).isEqualTo("1볼");
        }

        @Test
        @DisplayName("1볼 1스트라이크")
        void ball1Strike1() {
            Referee referee = new Referee();
            assertThat(referee.judge(new StrikeZone("252"), new StrikeZone("224"))).isEqualTo("1볼 1스트라이크");
        }

        @Test
        @DisplayName("2스트라이크")
        void strike2() {
            Referee referee = new Referee();
            assertThat(referee.judge(new StrikeZone("262"), new StrikeZone("232"))).isEqualTo("2스트라이크");
        }

        @Test
        @DisplayName("2볼: 볼값 하나가 Pitch에 2개 들어 있는 경우에도 하나만 카운트")
        void ball2() {
            Referee referee = new Referee();
            assertThat(referee.judge(new StrikeZone("123"), new StrikeZone("232"))).isEqualTo("2볼");
        }


        @Test
        @DisplayName("2볼 1스트라이크")
        void ball2Strike1() {
            Referee referee = new Referee();
            assertThat(referee.judge(new StrikeZone("233"), new StrikeZone("332"))).isEqualTo("2볼 1스트라이크");
        }


        @Test
        @DisplayName("3볼")
        void ball3() {
            Referee referee = new Referee();
            assertThat(referee.judge(new StrikeZone("561"), new StrikeZone("156"))).isEqualTo("3볼");
        }


        @Test
        @DisplayName("3스트라이크")
        void 결과_판별_테스트5() {
            Referee referee = new Referee();
            assertThat(referee.judge(new StrikeZone("232"), new StrikeZone("232"))).isEqualTo("3스트라이크");
        }

        @Test
        @DisplayName("낫싱")
        void 결과_판별_테스트5() {
            Referee referee = new Referee();
            assertThat(referee.judge(new StrikeZone("561"), new StrikeZone("232"))).isEqualTo("낫싱");
        }
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
