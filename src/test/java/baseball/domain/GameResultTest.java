package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    void addStrike() {
        GameResult result = new GameResult();
        result.addStrike();
        assertThat(result.getStrike()).isEqualTo(1);
    }

    @Test
    void addBall() {
        GameResult result = new GameResult();
        result.addBall();
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void twoStrikeOneBall() {
        GameResult result = new GameResult();
        result.addStrike();
        result.addBall();
        result.addStrike();
        assertThat(result.getStrike()).isEqualTo(2);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void stateNothing() {
        GameResult result = new GameResult();
        assertThat(result.getState()).isEqualTo(GameState.NOTHING);
    }

    @Test
    void stateGoodStrike() {
        GameResult result = new GameResult();
        result.addStrike();
        assertThat(result.getState()).isEqualTo(GameState.GOOD);
    }

    @Test
    void stateGoodBall() {
        GameResult result = new GameResult();
        result.addBall();
        assertThat(result.getState()).isEqualTo(GameState.GOOD);
    }

    @Test
    void stateGoodStrikeBall() {
        GameResult result = new GameResult();
        result.addBall();
        result.addStrike();
        assertThat(result.getState()).isEqualTo(GameState.GOOD);
    }

    @Test
    void stateCorrect() {
        GameResult result = new GameResult();
        result.addStrike();
        result.addStrike();
        result.addStrike();
        assertThat(result.getState()).isEqualTo(GameState.CORRECT);
    }
}