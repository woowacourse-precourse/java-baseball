package baseball.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    @Test
    void countTheNumberOfBall() {

        BaseballGame baseballGame = new BaseballGame();
        String targetNumber = "123";
        String inputNumber = "357";

        Integer numberOfBall = baseballGame.countTheNumberOfBall(targetNumber, inputNumber);
        Assertions.assertThat(numberOfBall).isEqualTo(1);
    }

    @Test
    void countTheNumberOfStrike() {

        BaseballGame baseballGame = new BaseballGame();
        String targetNumber = "482";
        String inputNumber = "462";

        Integer numberOfStrike = baseballGame.countTheNumberOfStrike(targetNumber, inputNumber);
        Assertions.assertThat(numberOfStrike).isEqualTo(2);
    }

}