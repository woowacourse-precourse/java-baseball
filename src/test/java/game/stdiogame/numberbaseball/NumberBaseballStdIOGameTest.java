package game.stdiogame.numberbaseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class NumberBaseballStdIOGameTest {

    private static NumberBaseballStdIOGameManager gameManager = NumberBaseballStdIOGameManager.getInstance();
    private final OutputStream os = new ByteArrayOutputStream();
    private final PrintStream ps = System.out;
    private String buf;
    private InputStream is;

    @BeforeEach
    void beforeEach() {
        System.setOut(new PrintStream(os));
        resetCount();
    }

    private void resetCount() {
        NumberBaseballStdIOGame game = (NumberBaseballStdIOGame) gameManager.getGame();
        NumberBaseballStdIOGameStatus gameStatus = (NumberBaseballStdIOGameStatus) game.getGameStatus();
        gameStatus.setStrikeCount(0);
        gameStatus.setBallCount(0);
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

        assertThat(os.toString()).isEqualTo("");
    }

    @Test
    void writeGameMessageWhenFinish() {
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();

        nbGame.finish();
        nbGame.writeGameMessage();

        assertThat(os.toString().trim()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
    void checkInputThrowError() {
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();
        NumberBaseballStdIOGameStatus nbGameStatus = (NumberBaseballStdIOGameStatus) nbGame.getGameStatus();

        buf = "A23";
        nbGameStatus.setInputData(buf);

        assertThatIllegalArgumentException().isThrownBy(nbGame::checkInput);
    }
    @Test
    void checkInput_정상처리() {
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();
        NumberBaseballStdIOGameStatus nbGameStatus = (NumberBaseballStdIOGameStatus) nbGame.getGameStatus();

        buf = "123";
        nbGameStatus.setInputData(buf);
        nbGame.checkInput();

        assertThat(nbGameStatus.getInputData()).isEqualTo(buf);
    }

    @Test
    void operateRule_낫싱() {
        buf = "123";
        is = new ByteArrayInputStream(buf.getBytes());
        System.setIn(is);
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();
        NumberBaseballStdIOGameStatus nbGameStatus = (NumberBaseballStdIOGameStatus) nbGame.getGameStatus();
        Map<Character, Integer> targetNumber = nbGameStatus.getTargetNumber();

        targetNumber.clear();
        targetNumber.put('4', 0);
        targetNumber.put('5', 1);
        targetNumber.put('6', 2);
        nbGame.readInput();
        nbGame.operateRule();

        int strikeCount = nbGameStatus.getStrikeCount();
        int ballCount = nbGameStatus.getBallCount();
        assertThat(strikeCount).isEqualTo(0);
        assertThat(ballCount).isEqualTo(0);
    }

    @Test
    void operateRule_1스트라이크() {
        buf = "123";
        is = new ByteArrayInputStream(buf.getBytes());
        System.setIn(is);
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();
        NumberBaseballStdIOGameStatus nbGameStatus = (NumberBaseballStdIOGameStatus) nbGame.getGameStatus();
        Map<Character, Integer> targetNumber = nbGameStatus.getTargetNumber();

        targetNumber.clear();
        targetNumber.put('1', 0);
        targetNumber.put('5', 1);
        targetNumber.put('6', 2);
        nbGame.readInput();
        nbGame.operateRule();

        int strikeCount = nbGameStatus.getStrikeCount();
        int ballCount = nbGameStatus.getBallCount();
        assertThat(strikeCount).isEqualTo(1);
        assertThat(ballCount).isEqualTo(0);
    }

    @Test
    void operateRule_2스트라이크() {
        buf = "123";
        is = new ByteArrayInputStream(buf.getBytes());
        System.setIn(is);
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();
        NumberBaseballStdIOGameStatus nbGameStatus = (NumberBaseballStdIOGameStatus) nbGame.getGameStatus();
        Map<Character, Integer> targetNumber = nbGameStatus.getTargetNumber();

        targetNumber.clear();
        targetNumber.put('1', 0);
        targetNumber.put('5', 1);
        targetNumber.put('3', 2);
        nbGame.readInput();
        nbGame.operateRule();

        int strikeCount = nbGameStatus.getStrikeCount();
        int ballCount = nbGameStatus.getBallCount();
        assertThat(strikeCount).isEqualTo(2);
        assertThat(ballCount).isEqualTo(0);
    }

    @Test
    void operateRule_3스트라이크() {
        buf = "123";
        is = new ByteArrayInputStream(buf.getBytes());
        System.setIn(is);
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();
        NumberBaseballStdIOGameStatus nbGameStatus = (NumberBaseballStdIOGameStatus) nbGame.getGameStatus();
        Map<Character, Integer> targetNumber = nbGameStatus.getTargetNumber();

        targetNumber.clear();
        targetNumber.put('1', 0);
        targetNumber.put('2', 1);
        targetNumber.put('3', 2);
        nbGame.readInput();
        nbGame.operateRule();

        int strikeCount = nbGameStatus.getStrikeCount();
        int ballCount = nbGameStatus.getBallCount();
        assertThat(strikeCount).isEqualTo(3);
        assertThat(ballCount).isEqualTo(0);
    }

    @Test
    void operateRule_1볼() {
        buf = "123";
        is = new ByteArrayInputStream(buf.getBytes());
        System.setIn(is);
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();
        NumberBaseballStdIOGameStatus nbGameStatus = (NumberBaseballStdIOGameStatus) nbGame.getGameStatus();
        Map<Character, Integer> targetNumber = nbGameStatus.getTargetNumber();

        targetNumber.clear();
        targetNumber.put('4', 0);
        targetNumber.put('1', 1);
        targetNumber.put('6', 2);
        nbGame.readInput();
        nbGame.operateRule();

        int strikeCount = nbGameStatus.getStrikeCount();
        int ballCount = nbGameStatus.getBallCount();
        assertThat(strikeCount).isEqualTo(0);
        assertThat(ballCount).isEqualTo(1);
    }

    @Test
    void operateRule_2볼() {
        buf = "123";
        is = new ByteArrayInputStream(buf.getBytes());
        System.setIn(is);
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();
        NumberBaseballStdIOGameStatus nbGameStatus = (NumberBaseballStdIOGameStatus) nbGame.getGameStatus();
        Map<Character, Integer> targetNumber = nbGameStatus.getTargetNumber();

        targetNumber.clear();
        targetNumber.put('2', 0);
        targetNumber.put('1', 1);
        targetNumber.put('6', 2);
        nbGame.readInput();
        nbGame.operateRule();

        int strikeCount = nbGameStatus.getStrikeCount();
        int ballCount = nbGameStatus.getBallCount();
        assertThat(strikeCount).isEqualTo(0);
        assertThat(ballCount).isEqualTo(2);
    }

    @Test
    void operateRule_3볼() {
        buf = "123";
        is = new ByteArrayInputStream(buf.getBytes());
        System.setIn(is);
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();
        NumberBaseballStdIOGameStatus nbGameStatus = (NumberBaseballStdIOGameStatus) nbGame.getGameStatus();
        Map<Character, Integer> targetNumber = nbGameStatus.getTargetNumber();

        targetNumber.clear();
        targetNumber.put('2', 0);
        targetNumber.put('3', 1);
        targetNumber.put('1', 2);
        nbGame.readInput();
        nbGame.operateRule();

        int strikeCount = nbGameStatus.getStrikeCount();
        int ballCount = nbGameStatus.getBallCount();
        assertThat(strikeCount).isEqualTo(0);
        assertThat(ballCount).isEqualTo(3);
    }

    @Test
    void operateRule_1볼_1스트라이크() {
        buf = "123";
        is = new ByteArrayInputStream(buf.getBytes());
        System.setIn(is);
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();
        NumberBaseballStdIOGameStatus nbGameStatus = (NumberBaseballStdIOGameStatus) nbGame.getGameStatus();
        Map<Character, Integer> targetNumber = nbGameStatus.getTargetNumber();

        targetNumber.clear();
        targetNumber.put('4', 0);
        targetNumber.put('2', 1);
        targetNumber.put('1', 2);
        nbGame.readInput();
        nbGame.operateRule();

        int strikeCount = nbGameStatus.getStrikeCount();
        int ballCount = nbGameStatus.getBallCount();
        assertThat(strikeCount).isEqualTo(1);
        assertThat(ballCount).isEqualTo(1);
    }

    @Test
    void operateRule_2볼_1스트라이크() {
        buf = "123";
        is = new ByteArrayInputStream(buf.getBytes());
        System.setIn(is);
        NumberBaseballStdIOGame nbGame = (NumberBaseballStdIOGame) gameManager.getGame();
        NumberBaseballStdIOGameStatus nbGameStatus = (NumberBaseballStdIOGameStatus) nbGame.getGameStatus();
        Map<Character, Integer> targetNumber = nbGameStatus.getTargetNumber();

        targetNumber.clear();
        targetNumber.put('3', 0);
        targetNumber.put('2', 1);
        targetNumber.put('1', 2);
        nbGame.readInput();
        nbGame.operateRule();

        int strikeCount = nbGameStatus.getStrikeCount();
        int ballCount = nbGameStatus.getBallCount();
        assertThat(strikeCount).isEqualTo(1);
        assertThat(ballCount).isEqualTo(2);
    }

    @Test
    void writeOutput() {
    }
}