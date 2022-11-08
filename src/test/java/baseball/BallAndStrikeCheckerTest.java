package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BallAndStrikeCheckerTest {
    private BallAndStrikeChecker ballAndStrikeChecker = new BallAndStrikeChecker();
    @Test
    void 결과_낫싱_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        int strike = 0;
        int ball = 0;
        ballAndStrikeChecker.reply(ball, strike);
        assertThat("낫싱\r\n").isEqualTo(out.toString());
    }

    @Test
    void 결과_정답_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        int strike = 3;
        int ball = 0;
        ballAndStrikeChecker.reply(ball, strike);
        assertThat("3스트라이크\r\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\r\n").isEqualTo(out.toString());
    }

    @Test
    void 결과_스트라이크만출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        int strike = 1;
        int ball = 0;
        ballAndStrikeChecker.reply(ball, strike);
        assertThat("1스트라이크\r\n").isEqualTo(out.toString());
    }

    @Test
    void 결과_볼만_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        int strike = 0;
        int ball = 3;
        ballAndStrikeChecker.reply(ball, strike);
        assertThat("3볼\r\n").isEqualTo(out.toString());
    }

    @Test
    void 결과_볼_스트라이크_출력_1() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        int strike = 1;
        int ball = 1;
        ballAndStrikeChecker.reply(ball, strike);
        assertThat("1볼 1스트라이크\r\n").isEqualTo(out.toString());
    }

    @Test
    void 결과_볼_스트라이크_출력_2() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        int strike = 1;
        int ball = 2;
        ballAndStrikeChecker.reply(ball, strike);
        assertThat("2볼 1스트라이크\r\n").isEqualTo(out.toString());
    }
}
