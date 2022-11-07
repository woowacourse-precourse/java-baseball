package game.stdiogame.numberbaseball;

import game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberBaseballStdIOGameTest {

    private static NumberBaseballStdIOGameManager gameManager = NumberBaseballStdIOGameManager.getInstance();

    @Test
    void start() {
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();
        nbGame.start();
        assertThat(nbGame.getGameStatus().isStart()).isEqualTo(true);
    }

    @Test
    void writeGameMessage() {
    }

    @Test
    void readInput() {
    }

    @Test
    void checkInput() {
    }

    @Test
    void operateRule() {
    }

    @Test
    void writeOutput() {
    }
}