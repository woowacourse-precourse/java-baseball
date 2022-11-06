package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    BaseBallGame testGame = new BaseBallGame();
    String actualOutputWhenStartGame;
    @BeforeEach
    void 게임시작시키기() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        testGame.startGame();
        actualOutputWhenStartGame = out.toString()
                .replace(System.getProperty("line.separator").toString(), "");
    }
    @Test
    void 게임시작하면_출력되는_시작문구_확인() {
        String expectedOutputWhenStartGame = "숫자 야구 게임을 시작합니다.";
        assertThat(actualOutputWhenStartGame).isEqualTo(actualOutputWhenStartGame);
    }
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
}
