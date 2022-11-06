package baseball;

import baseball.participants.Pitcher;
import baseball.participants.Referee;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mockStatic;

import baseball.participants.StrikeZone;
import org.mockito.MockedStatic;

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
                    assertThatThrownBy(() -> new StrikeZone("1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 예외_테스트2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> new StrikeZone("12"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 에외_테스트3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> new StrikeZone("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 예외_테스트4() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> new StrikeZone(List.of(1)))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 예외_테스트5() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> new StrikeZone(List.of(1, 2)))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 에외_테스트6() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> new StrikeZone(List.of(1, 2, 3, 4)))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }


    @Test
    void testPitch() {
        final byte[] buf = String.join("\n", "245").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Referee referee = new Referee();
        Pitcher pitcher = new Pitcher();
        referee.startPitch();
        pitcher.pitch();

        assertThat(pitcher.pitchZone.toString()).isEqualTo("245");
    }

    @Test
    void testPlayAgain() {
        final byte[] buf = String.join("\n", "4","1").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Referee referee = new Referee();
        referee.playAgainOrTerminate();

        assertThat(output()).contains("1 혹은 2만 입력해주세요.", "게임을 다시 시작합니다.");
    }

    @Test
    void testTerminateGame() {
        final byte[] buf = String.join("\n", "4","2").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Referee referee = new Referee();
        referee.playAgainOrTerminate();

        assertThat(output()).contains("1 혹은 2만 입력해주세요.", "게임을 완전히 종료합니다.");
    }

    @Nested
    class JudgementTest {
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
