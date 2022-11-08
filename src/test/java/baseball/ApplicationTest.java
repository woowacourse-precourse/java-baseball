package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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

    @Nested
    class StrikeTest {


        @Test
        void 스트라이크_테스트_한자리_숫자() {
            BaseballGame baseballGame = new BaseballGame(List.of("1", "2", "3"));
            List<String> userInput = List.of("1");
            assertThat(baseballGame.countStrike(userInput)).isEqualTo(1);
        }

        @Test
        void 스트라이크_테스트_인풋_세개일_때() {
            BaseballGame baseballGame = new BaseballGame(List.of("1", "3", "5"));
            List<String> userInput = List.of("1", "3", "2");
            assertThat(baseballGame.countStrike(userInput)).isEqualTo(2);
        }

    }
    @Nested
    class BallTest{


        @Test
        void 볼_테스트_인풋_한자리_숫자() {
            BaseballGame baseballGame = new BaseballGame(List.of("1", "2", "3"));
            List<String> userInput = List.of("3");
            assertThat(baseballGame.countBall(userInput)).isEqualTo(1);
        }
        @Test
        void 볼_테스트_인픗_세자리_숫자() {
            BaseballGame baseballGame = new BaseballGame(List.of("1", "3", "5"));
            List<String> userInput = List.of("5", "1", "3");
            assertThat(baseballGame.countBall(userInput)).isEqualTo(3);
        }

    }
    @Nested
    class 결과_테스트 {


        @Test
        void 스트라이크1() {
            BaseballGame baseballGame = new BaseballGame(List.of("1", "2", "3"));
            List<String> userInput = List.of("1", "4", "5");
            baseballGame.showResult(userInput);
        }
        @Test
        void 스트라이크2볼1() {
            BaseballGame baseballGame = new BaseballGame(List.of("1", "2", "3"));
            List<String> userInput = List.of("1", "2", "2");
            baseballGame.showResult(userInput);
        }
        //
        @Test
        void 스트라이크3() {
            BaseballGame baseballGame = new BaseballGame(List.of("1", "2", "3"));
            List<String> userInput = List.of("1", "2", "3");
            baseballGame.showResult(userInput);
        }
        //

        @Test
        void 볼3() {
            BaseballGame baseballGame = new BaseballGame(List.of("1", "2", "3"));
            List<String> userInput = List.of("2", "3", "1");
            baseballGame.showResult(userInput);
        }
        @Test
        void 낫싱() {
            BaseballGame baseballGame = new BaseballGame(List.of("1", "2", "3"));
            List<String> userInput = List.of("4", "5", "6");
            baseballGame.showResult(userInput);
        }

    }
}
