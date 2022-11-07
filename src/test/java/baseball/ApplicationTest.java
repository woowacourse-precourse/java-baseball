package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "456", "789", "798", "987", "1","246", "135", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "2볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "낫싱", "3스트라이크");
                },
                9,8,7, 1, 3, 5
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
    void 컴퓨터랜덤값_테스트() {
        Baseball baseball = new Baseball();
        baseball.getGameNumber().stream()
                .map(number -> assertThat(number).isBetween(1,9));
    }

    @Test
    void 힌트코드_테스트() {
        Baseball baseball = new Baseball();
        List<Integer> baseballCount = new ArrayList<>(Arrays.asList(1,2));

        assertThat(baseball.getHintCode(baseballCount)).isEqualTo("1볼 2스트라이크");
        assertThat(baseball.getHintCode(Arrays.asList(0,0))).isEqualTo("낫싱");
        assertThat(baseball.getHintCode(Arrays.asList(0,3))).isEqualTo("3스트라이크");
        assertThat(baseball.getHintCode(Arrays.asList(3,0))).isEqualTo("3볼");
    }

    @Test
    void 최종볼갯수_테스트() {
        Baseball baseball = new Baseball();
        baseball.gameNumber = Arrays.asList(1,2,3);
        assertThat(baseball.getTotalBallCount("123")).isEqualTo(Arrays.asList(0,3));
        assertThat(baseball.getTotalBallCount("456")).isEqualTo(Arrays.asList(0,0));
        assertThat(baseball.getTotalBallCount("126")).isEqualTo(Arrays.asList(0,2));
        assertThat(baseball.getTotalBallCount("132")).isEqualTo(Arrays.asList(2,1));
    }

    @Test
    void 게임매적넘버_테스트() {
        Baseball.GameStatus exitStatus = Baseball.GameStatus.EXIT;
        assertThat(exitStatus.getGameStatus()).isEqualTo("2");
        assertThat(Baseball.GameStatus.RESTART.getGameStatus()).isEqualTo("1");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
