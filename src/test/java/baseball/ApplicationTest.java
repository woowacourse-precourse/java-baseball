package baseball;

import baseball.domain.Game;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void ballJudgeTest() {
        Game game = new Game();
        List<String> computerAnswerList = List.of("1", "2", "3");
        List<String> userAnswerList = List.of("3", "2", "1");
        int ballCount = game.countBall(computerAnswerList, userAnswerList);
        assertThat(ballCount).isEqualTo(2);


    }

    @Test
    void strikeJudgeTest() {
        Game game = new Game();
        List<String> computerAnswerList = List.of("1", "2", "3");
        List<String> userAnswerList = List.of("1", "2", "4");
        int strikeCount = game.countStrike(computerAnswerList, userAnswerList);
        assertThat(strikeCount).isEqualTo(2);

    }

}
