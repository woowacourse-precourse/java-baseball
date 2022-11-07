package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallCountTest {

    BallCount ballCount = new BallCount();
    BaseballNumbers randomNumbers = new BaseballNumbers();
    BaseballNumbers inputNumbers = new BaseballNumbers();

    @Test
    void case1_랜덤값과_인풋값_비교_후_볼_개수_확인() {
        randomNumbers.createBaseballNumbers("123");
        inputNumbers.createBaseballNumbers("234");
        String input = "2볼";
        ballCount.validateBallCount(randomNumbers, inputNumbers);
        assertThat(ballCount.toString())
                .isEqualTo(input);

    }
}
