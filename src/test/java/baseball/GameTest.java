package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    void game의_이전_내역을_초기화한다() {
        // Given
        Game game = new Game();
        game.setNumberOfStrike(2);
        game.setNumberOfBall(1);
        game.setBallCount("1볼 2스트라이크");

        // When
        game.initializeBallCount();

        // Then
        int numberOfStrike = game.getNumberOfStrike();
        int resultOfStrike = 0;

        int numberOfBall = game.getNumberOfBall();
        int resultOfBall = 0;

        String ballCount = game.getBallCount();
        String resultOfBallCount = null;

        assertThat(numberOfStrike).isEqualTo(resultOfStrike);
        assertThat(numberOfBall).isEqualTo(resultOfBall);
        assertThat(ballCount).isEqualTo(resultOfBallCount);
    }
}
