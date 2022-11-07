package baseball.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    @Test
    void countTheNumberOfBall() {

        String targetNumber = "123";
        BaseballGame baseballGame = new BaseballGame(targetNumber, GameStatus.START);
        String inputNumber = "357";

        Integer numberOfBall = baseballGame.countTheNumberOfBall(targetNumber, inputNumber);
        Assertions.assertThat(numberOfBall).isEqualTo(1);
    }

    @Test
    void countTheNumberOfStrike() {

        String targetNumber = "482";
        BaseballGame baseballGame = new BaseballGame(targetNumber, GameStatus.START);
        String inputNumber = "462";

        Integer numberOfStrike = baseballGame.countTheNumberOfStrike(targetNumber, inputNumber);
        Assertions.assertThat(numberOfStrike).isEqualTo(2);
    }

}