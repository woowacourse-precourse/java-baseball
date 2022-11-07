package game.stdiogame.numberbaseball;

import camp.nextstep.edu.missionutils.Console;
import game.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class NumberBaseballStdIOGameTest {

    private static NumberBaseballStdIOGameManager gameManager = NumberBaseballStdIOGameManager.getInstance();
    private final OutputStream os = new ByteArrayOutputStream();
    private final PrintStream ps = System.out;
    private String buf;
    private InputStream is;

    @BeforeEach
    void beforeEach() {
        System.setOut(new PrintStream(os));
    }

    @AfterEach
    void afterEach() {
        System.setOut(ps);
        System.setIn(System.in);
    }

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
        nbGame.writeGameMessage();

        assertThat(os.toString().trim()).isEqualTo("");
    }

    @Test
    void writeGameMessageWhenFinish() {
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();

        nbGame.finish();
        nbGame.writeGameMessage();

        assertThat(os.toString()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    void readInput() throws IOException {
        buf = "123";
        is = new ByteArrayInputStream(buf.getBytes());
        System.setIn(is);
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();
        NumberBaseballStdIOGameStatus nbGameStatus;

        nbGame.readInput();

        assertThat(os.toString()).isEqualTo("숫자를 입력해주세요 : ");
        nbGameStatus = (NumberBaseballStdIOGameStatus) nbGame.getGameStatus();
        assertThat(nbGameStatus.getInputData()).isEqualTo(buf);
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