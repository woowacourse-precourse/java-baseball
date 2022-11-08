package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    Game game = new Game();

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 사용자_입력_에러_테스트() {
        assertThatThrownBy(() -> game.checkGameUserInput("1456", new ArrayList<Integer>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값의 길이가 조건에 일치하지 않습니다.");

        assertThatThrownBy(() -> game.checkGameUserInput("14!", new ArrayList<Integer>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값의 범위가 조건에 일치하지 않습니다.");

        assertThatThrownBy(() -> game.checkGameUserInput("454", new ArrayList<Integer>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값들 중 중복된 값이 있습니다.");

        assertThat(game.checkGameUserInput("456", new ArrayList<Integer>())).containsExactly(4, 5, 6);
    }
}