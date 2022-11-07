package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameTest {

    @Test
    void start() {
    }

    @Test
    void printMessage() {
    }

    @Test
    void isStartStatus_시작상태인경우() {
        Game game = new Game();
        boolean result = true;
        assertThat(result).isEqualTo(game.isStartStatus());
    }

    @Test
    void isStartStatus_종료상태인경우() {
        Game game = new Game();
        game.setStatus(Settings.TERMINATE_STATUS);
        boolean result = false;
        assertThat(result).isEqualTo(game.isStartStatus());
    }

    @Test
    void requestAnswer() {
    }

    @Test
    void checkAnswer() {
    }

    @Test
    void countResult() {
    }

    @Test
    void setStatusByProblemSolver() {
    }
}