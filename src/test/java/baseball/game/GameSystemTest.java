package baseball.game;

import baseball.domain.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameSystemTest {
    GameSystem game;
    Computer computer;
    Player player;

    @BeforeEach
    void beforeEach() {
        computer = new Computer();
        player = new Player();
        game = new GameSystem(computer, player);
    }

    @Test
    void initialize() {
        game.initialize();
    }

    @Test
    void playGame() {
        // 사용자 입력
    }

    @Test
    void receivedCorrectAnswer_정답아님() {
        GameResult result = new GameResult();
        result.addStrike();
        result.addStrike();

        boolean b = game.receivedCorrectAnswer(result);
        assertFalse(b);
    }

    @Test
    void receivedCorrectAnswer_정답() {
        GameResult result = new GameResult();
        result.addStrike();
        result.addStrike();
        result.addStrike();

        boolean b = game.receivedCorrectAnswer(result);
        assertTrue(b);
    }

    @Test
    void printResult() {
        GameResult result = new GameResult();
        result.addStrike();
        result.addBall();
        String s = game.printResult(result);

        String e = "1볼 1스트라이크";
        assertThat(s).isEqualTo(e);
    }

    @Test
    void printResult2() {
        GameResult result = new GameResult();
        result.addBall();
        result.addBall();
        result.addBall();
        String s = game.printResult(result);

        String e = "3볼";
        assertThat(s).isEqualTo(e);
    }

    @Test
    void printResult3() {
        GameResult result = new GameResult();
        result.addStrike();
        result.addStrike();
        String s = game.printResult(result);

        String e = "2스트라이크";
        assertThat(s).isEqualTo(e);
    }

    @Test
    void printResult4() {
        GameResult result = new GameResult();
        result.addStrike();
        result.addStrike();
        result.addBall();
        String s = game.printResult(result);

        String e = "1볼 2스트라이크";
        assertThat(s).isEqualTo(e);
    }

    @Test
    void printResult5_정답맞춤() {
        GameResult result = new GameResult();
        result.addStrike();
        result.addStrike();
        result.addStrike();
        String s = game.printResult(result);

        String e = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        assertThat(s).isEqualTo(e);
    }

    @Test
    void printResult6_한개도_못맞춤() {
        GameResult result = new GameResult();
        String s = game.printResult(result);

        String e = "낫싱";
        assertThat(s).isEqualTo(e);
    }

    @Test
    void continueGame() {
        // 사용자 입력
    }
}