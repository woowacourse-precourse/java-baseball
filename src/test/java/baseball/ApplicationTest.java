package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;

class ApplicationTest extends NsTest {

    @DisplayName("게임 시작 문구 출력 테스트")
    @Test
    void printGameStartMessageTest() {
        Application.printGameStartMessage();
        assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @DisplayName("게임 종료 후 재시작 질문 출력 테스트")
    @Test
    void printGameRestartMessageTest() {
        Application.printGameRestartMessage();
        assertThat(output()).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @DisplayName("게임 종료 후 사용자 입력 테스트")
    @Test
    void parseUserInputForRestartTest() {
        setSystemInput("1");
        assertThat(Application.parseUserInputForRestart()).isEqualTo(true);
    }

    @Test
    @DisplayName("게임 실행 종료 후 재시작 테스트")
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(() -> {
            run("246", "135", "1", "597", "589", "2");
            assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
        }, 1, 3, 5, 5, 8, 9);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("1234")).isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }

    private void setSystemInput(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
