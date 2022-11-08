package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest extends NsTest {

    @Test
    void 스트라이크3_테스트() {
        BaseballScore baseballScore = new BaseballScore();
        String userNumber = "264";
        List<Integer> computerNumber = List.of(2, 6, 4);

        baseballScore.compareComputerAndUser(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("3스트라이크");
    }

    @Test
    void 스트라이크2_테스트() {
        BaseballScore baseballScore = new BaseballScore();
        String userNumber = "234";
        List<Integer> computerNumber = List.of(2, 6, 4);

        baseballScore.compareComputerAndUser(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("2스트라이크");
    }

    @Test
    void 스트라이크1_테스트() {
        BaseballScore baseballScore = new BaseballScore();
        String userNumber = "874";
        List<Integer> computerNumber = List.of(2, 6, 4);

        baseballScore.compareComputerAndUser(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("1스트라이크");
    }

    @Test
    void 볼3_테스트() {
        BaseballScore baseballScore = new BaseballScore();
        String userNumber = "642";
        List<Integer> computerNumber = List.of(2, 6, 4);

        baseballScore.compareComputerAndUser(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("3볼");
    }

    @Test
    void 볼2_테스트() {
        BaseballScore baseballScore = new BaseballScore();
        String userNumber = "476";
        List<Integer> computerNumber = List.of(2, 6, 4);

        baseballScore.compareComputerAndUser(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("2볼");
    }

    @Test
    void 볼1_테스트() {
        BaseballScore baseballScore = new BaseballScore();
        String userNumber = "613";
        List<Integer> computerNumber = List.of(2, 6, 4);

        baseballScore.compareComputerAndUser(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("1볼");
    }

    @Test
    void 볼1_스트라이크1_테스트() {
        BaseballScore baseballScore = new BaseballScore();
        String userNumber = "243";
        List<Integer> computerNumber = List.of(2, 6, 4);

        baseballScore.compareComputerAndUser(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 볼2_스트라이크1_테스트() {
        BaseballScore baseballScore = new BaseballScore();
        String userNumber = "462";
        List<Integer> computerNumber = List.of(2, 6, 4);

        baseballScore.compareComputerAndUser(computerNumber, userNumber);

        assertThat(baseballScore.getResult()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 낫싱_테스트() {
        BaseballScore baseballScore = new BaseballScore();
        String userNumber = "789";
        List<Integer> computerNumber = List.of(2, 6, 4);

        baseballScore.compareComputerAndUser(computerNumber, userNumber);

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
