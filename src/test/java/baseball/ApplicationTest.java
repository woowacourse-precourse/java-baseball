package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.BaseballGuide;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("게임 시작 시 시작과 입력에 관한 메시지를 출력한다.")
    @Test
    void startGameWithMessage() {
        assertRandomNumberInRangeTest(
            () -> {
                run("135", "2");
                assertThat(output()).contains("숫자 야구 게임을 시작합니다.", "숫자를 입력해주세요 : ");
            },
            1, 3, 5
        );
    }

    @DisplayName("게임 종료 시 종료와 재시작에 관한 메시지를 출력한다.")
    @Test
    void endGameWithMessage() {
        assertRandomNumberInRangeTest(
            () -> {
                run("135", "2");
                assertThat(output()).contains(
                    BaseballGuide.NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료",
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            },
            1, 3, 5
        );
    }

    @DisplayName("볼에 대한 메시지를 출력한다.")
    @Test
    void ballMessage() {
        assertRandomNumberInRangeTest(
            () -> {
                run("367", "561", "351", "135", "2");
                assertThat(output()).contains("1볼", "2볼", "3볼");
            },
            1, 3, 5
        );
    }

    @DisplayName("스트라이크에 대한 메시지를 출력한다.")
    @Test
    void strikeMessage() {
        assertRandomNumberInRangeTest(
            () -> {
                run("178", "139", "135", "2");
                assertThat(output()).contains("1스트라이크", "2스트라이크", "3스트라이크");
            },
            1, 3, 5
        );
    }

    @DisplayName("볼과 스트라이크에 대한 메시지를 출력한다.")
    @Test
    void strikeAndBallMessage() {
        assertRandomNumberInRangeTest(
            () -> {
                run("156", "531", "135", "2");
                assertThat(output()).contains("1볼 1스트라이크", "2볼 1스트라이크");
            },
            1, 3, 5
        );
    }

    @DisplayName("하나도 일치하지 않는 것에 대한 메시지를 출력한다.")
    @Test
    void nothingMessage() {
        assertRandomNumberInRangeTest(
            () -> {
                run("246", "135", "2");
                assertThat(output()).contains("낫싱");
            },
            1, 3, 5
        );
    }

    @DisplayName("숫자가 아닌 문자가 입력되면 예외를 발생한다.")
    @Test
    void notDigitException() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1a3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("범위를 벗어난 숫자를 포함하면 예외를 발생한다.")
    @Test
    void outOfRangeException() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("103"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("중복 숫자를 포함하면 예외를 발생한다.")
    @Test
    void duplicationException() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("113"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("재시작 상태에 존재하지 않는 상태가 입력되면 예외가 발생한다.")
    @Test
    void notExistStatusException() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                () -> {
                    run("135", "3");
                },
                1, 3, 5
            ))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
