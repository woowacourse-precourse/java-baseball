package game.stdiogame.numberbaseball;

import game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

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
    void writeGameMessageWhenStart() {
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();
        nbGame.start();
        OutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        nbGame.writeGameMessage();
        assertThat(captor.toString().trim()).isEqualTo("");
    }

    @Test
    void writeGameMessageWhenFinish() {
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();
        nbGame.finish();
        OutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        nbGame.writeGameMessage();
        assertThat(captor.toString().trim()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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