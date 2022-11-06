package baseball;

import baseball.game.utils.ScoreBoard;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreBoardTest {

    @Test
    void 스코어보드_addBall_addStrike_테스트(){
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.addBall();
        scoreBoard.addBall();
        scoreBoard.addStrike();

        Assertions.assertThat(scoreBoard.getBallAndStrike()).isEqualTo(Arrays.asList(2,1));
    }

    @Test
    void 스코어보드_printBallAndStrike_테스트(){
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.addBall();
        scoreBoard.addBall();
        scoreBoard.addStrike();

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        scoreBoard.printBallAndStrike();

        String output = "2볼 1스트라이크";

        Assertions.assertThat(out.toString()).isEqualTo(output);
    }

    @Test
    void 스코어보드_printBallAndStrike_낫싱_테스트(){
        ScoreBoard scoreBoard = new ScoreBoard();

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        scoreBoard.printBallAndStrike();

        String output = "낫싱";

        Assertions.assertThat(out.toString()).isEqualTo(output);
    }
}
