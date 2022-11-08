package baseball.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {

    List<String> computerBalls;

    @BeforeEach
    void setUp() {
        computerBalls = List.of("3", "5", "7");
    }

    @Test
    @DisplayName("Score의 Enum Map을 Enum.value : 0 형태로 초기화")
    void Score_초기화_확인() {
        Map<BallCount, Integer> map = Map.of(
                BallCount.OUT, 0,
                BallCount.BALL, 0,
                BallCount.STRIKE, 0
        );
        assertThat(new Score()).isEqualTo(new Score(map));
    }

    @Test
    void 비교결과_도출_3스트라이크() {
        List<String> userBalls = List.of("3", "5", "7");
        Map<BallCount, Integer> result = Map.of(
                BallCount.OUT, 0,
                BallCount.BALL, 0,
                BallCount.STRIKE, 3
        );

        assertThat(new Score(new Computer(computerBalls), new User(userBalls))).isEqualTo(new Score(result));
    }

    @Test
    void 비교결과_도출_2스트라이크() {
        List<String> userBalls = List.of("3", "5", "2");
        Map<BallCount, Integer> result = Map.of(
                BallCount.OUT, 1,
                BallCount.BALL, 0,
                BallCount.STRIKE, 2
        );

        assertThat(new Score(new Computer(computerBalls), new User(userBalls))).isEqualTo(new Score(result));
    }

    @Test
    void 비교결과_도출_1스트라이크() {
        List<String> userBalls = List.of("3", "6", "2");
        Map<BallCount, Integer> result = Map.of(
                BallCount.OUT, 2,
                BallCount.BALL, 0,
                BallCount.STRIKE, 1
        );

        assertThat(new Score(new Computer(computerBalls), new User(userBalls))).isEqualTo(new Score(result));
    }

    @Test
    void 비교결과_도출_2볼_1스트라이크() {
        List<String> userBalls = List.of("5", "3", "7");
        Map<BallCount, Integer> result = Map.of(
                BallCount.OUT, 0,
                BallCount.BALL, 2,
                BallCount.STRIKE, 1
        );

        assertThat(new Score(new Computer(computerBalls), new User(userBalls))).isEqualTo(new Score(result));
    }

    @Test
    void 비교결과_도출_1볼_1스트라이크() {
        List<String> userBalls = List.of("3", "7", "6");
        Map<BallCount, Integer> result = Map.of(
                BallCount.OUT, 1,
                BallCount.BALL, 1,
                BallCount.STRIKE, 1
        );

        assertThat(new Score(new Computer(computerBalls), new User(userBalls))).isEqualTo(new Score(result));
    }

    @Test
    void 비교결과_도출_1볼() {
        List<String> userBalls = List.of("4", "7", "1");
        Map<BallCount, Integer> result = Map.of(
                BallCount.OUT, 2,
                BallCount.BALL, 1,
                BallCount.STRIKE, 0
        );

        assertThat(new Score(new Computer(computerBalls), new User(userBalls))).isEqualTo(new Score(result));
    }

    @Test
    void 비교결과_도출_2볼() {
        List<String> userBalls = List.of("5", "3", "9");
        Map<BallCount, Integer> result = Map.of(
                BallCount.OUT, 1,
                BallCount.BALL, 2,
                BallCount.STRIKE, 0
        );

        assertThat(new Score(new Computer(computerBalls), new User(userBalls))).isEqualTo(new Score(result));
    }

    @Test
    void 비교결과_도출_3볼() {
        List<String> userBalls = List.of("5", "7", "3");
        Map<BallCount, Integer> result = Map.of(
                BallCount.OUT, 0,
                BallCount.BALL, 3,
                BallCount.STRIKE, 0
        );

        assertThat(new Score(new Computer(computerBalls), new User(userBalls))).isEqualTo(new Score(result));
    }

    @Test
    void 비교결과_도출_낫싱() {
        List<String> userBalls = List.of("2", "1", "4");
        Map<BallCount, Integer> result = Map.of(
                BallCount.OUT, 3,
                BallCount.BALL, 0,
                BallCount.STRIKE, 0
        );

        assertThat(new Score(new Computer(computerBalls), new User(userBalls))).isEqualTo(new Score(result));
    }
}