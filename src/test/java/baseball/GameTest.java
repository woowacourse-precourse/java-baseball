package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest extends NsTest {
    private BaseballScore baseballScore;
    private List<Integer> computerNumber;

    @BeforeEach
    void setUp() {
        baseballScore = new BaseballScore();
        computerNumber = List.of(2, 6, 4);
    }

    @Test
    void 스트라이크3_테스트() {
        String userNumber = "264";

        baseballScore.countStrikesAndBalls(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("3스트라이크");
    }

    @Test
    void 스트라이크2_테스트() {
        String userNumber = "234";

        baseballScore.countStrikesAndBalls(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("2스트라이크");
    }

    @Test
    void 스트라이크1_테스트() {
        String userNumber = "874";

        baseballScore.countStrikesAndBalls(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("1스트라이크");
    }

    @Test
    void 볼3_테스트() {
        String userNumber = "642";

        baseballScore.countStrikesAndBalls(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("3볼");
    }

    @Test
    void 볼2_테스트() {
        String userNumber = "476";

        baseballScore.countStrikesAndBalls(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("2볼");
    }

    @Test
    void 볼1_테스트() {
        String userNumber = "613";

        baseballScore.countStrikesAndBalls(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("1볼");
    }

    @Test
    void 볼1_스트라이크1_테스트() {
        String userNumber = "243";

        baseballScore.countStrikesAndBalls(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 볼2_스트라이크1_테스트() {
        String userNumber = "462";

        baseballScore.countStrikesAndBalls(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 낫싱_테스트() {
        String userNumber = "789";

        baseballScore.countStrikesAndBalls(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("낫싱");
    }

    @Test
    void 출력_테스트() {
        BaseballGame baseballGame = new BaseballGame();
        String output = "출력 테스트 메시지";

        baseballGame.printMessage(output);

        assertThat(output()).isEqualTo(output);
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
