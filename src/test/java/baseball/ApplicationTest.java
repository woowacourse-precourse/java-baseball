package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
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

    @Test
    void 문자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12T"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 스트라이크_개수_반환() {
        String computer = "123";
        String user = "123";
        int result = Game.countSameLetterInSameIndexWithoutDuplicate(user, computer);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 볼_개수_반환() {
        String computer = "12345";
        String user = "54321";
        int result = Game.countSameLetterInDifferentIndexWithoutDuplicate(user, computer);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void 게임_재시작_길이_예외_테스트() {
        String answer = "123";
        final byte[] buf = answer.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        Game game = new NumberBaseball();

        assertThatThrownBy(() -> game.choiceRestartOrExit())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_재시작_문자_예외_테스트() {
        String answer = "a";
        final byte[] buf = answer.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        Game game = new NumberBaseball();

        assertThatThrownBy(() -> game.choiceRestartOrExit())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
