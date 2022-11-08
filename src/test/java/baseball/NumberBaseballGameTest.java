package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumberBaseballGameTest {

    private final NumberBaseballGame numberBaseballGame = new NumberBaseballGame();

    @Test
    void playGame_결과_확인() {
        List<Integer> computerNumber = Arrays.asList(1, 2, 3);
        List<Integer> inputNumber = Arrays.asList(1, 3, 4);

        Score score = new Score();
        numberBaseballGame.playGame(score, computerNumber, inputNumber);

        assertThat(score.getBall()).isEqualTo(1);
        assertThat(score.getStrike()).isEqualTo(1);
    }

    @Test
    void getResult_결과_문자열_확인_1() {
        Score score = new Score();
        score.setBall(1);
        score.setStrike(2);

        assertThat(numberBaseballGame.getResult(score)).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void getResult_결과_문자열_확인_2() {
        Score score = new Score();
        score.setBall(2);

        assertThat(numberBaseballGame.getResult(score)).isEqualTo("2볼");
    }

    @Test
    void getResult_결과_문자열_확인_3() {
        Score score = new Score();

        assertThat(numberBaseballGame.getResult(score)).isEqualTo("낫싱");
    }

    @Test
    void restartGame_재시작_확인() {
        String restartFlag = "1";

        assertThat(numberBaseballGame.restartGame(restartFlag)).isTrue();
    }

    @Test
    void restartGame_종료_확인() {
        String restartFlag = "2";

        assertThat(numberBaseballGame.restartGame(restartFlag)).isFalse();
    }
}
