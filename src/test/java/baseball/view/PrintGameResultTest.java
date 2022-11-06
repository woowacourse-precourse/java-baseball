package baseball.view;

import baseball.dto.Result;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class PrintGameResultTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintGameResult printGameResult;

    @BeforeEach
    void before() {
        printGameResult = new PrintGameResult();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void after() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void result_스트라이크_볼_테스트() {
        int strike = 2;
        int ball = 1;
        Result result = new Result(strike, ball);
        int checkStrike = result.getStrike();
        int checkBall = result.getBall();
        assertThat(checkStrike).isSameAs(2);
        assertThat(checkBall).isSameAs(1);
    }

    @Test
    void 낫싱_테스트() {
        int strike = 0;
        int ball = 0;
        Result result = new Result(strike, ball);
        printGameResult.result(result);
        String expectation = "낫싱\n";
        assertThat(output.toString()).isEqualTo(expectation);
    }

    @Test
    void 원스트라이크_테스트() {
        int strike = 1;
        int ball = 0;
        Result result = new Result(strike, ball);
        printGameResult.result(result);
        String expectation = "1스트라이크\n";
        assertThat(output.toString()).isEqualTo(expectation);
    }

    @Test
    void 투스트라이크_테스트() {
        int strike = 2;
        int ball = 0;
        Result result = new Result(strike, ball);
        printGameResult.result(result);
        String expectation = "2스트라이크\n";
        assertThat(output.toString()).isEqualTo(expectation);
    }

    @Test
    void 쓰리스트라이크_테스트() {
        int strike = 3;
        int ball = 0;
        Result result = new Result(strike, ball);
        printGameResult.result(result);
        String expectation = "3스트라이크\n" +
                "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
        assertThat(output.toString()).isEqualTo(expectation);
    }

    @Test
    void 원볼_테스트() {
        int strike = 0;
        int ball = 1;
        Result result = new Result(strike, ball);
        printGameResult.result(result);
        String expectation = "1볼\n";
        assertThat(output.toString()).isEqualTo(expectation);
    }

    @Test
    void 투볼_테스트() {
        int strike = 0;
        int ball = 2;
        Result result = new Result(strike, ball);
        printGameResult.result(result);
        String expectation = "2볼\n";
        assertThat(output.toString()).isEqualTo(expectation);
    }

    @Test
    void 쓰리볼_테스트() {
        int strike = 0;
        int ball = 3;
        Result result = new Result(strike, ball);
        printGameResult.result(result);
        String expectation = "3볼\n";
        assertThat(output.toString()).isEqualTo(expectation);
    }

    @Test
    void 원볼_원스트라이크_테스트() {
        int strike = 1;
        int ball = 1;
        Result result = new Result(strike, ball);
        printGameResult.result(result);
        String expectation = "1볼 1스트라이크\n";
        assertThat(output.toString()).isEqualTo(expectation);
    }

    @Test
    void 원볼_투스트라이크_테스트() {
        int strike = 1;
        int ball = 1;
        Result result = new Result(strike, ball);
        printGameResult.result(result);
        String expectation = "1볼 1스트라이크\n";
        assertThat(output.toString()).isEqualTo(expectation);
    }

    @Test
    void 투볼_원스트라이크_테스트() {
        int strike = 1;
        int ball = 2;
        Result result = new Result(strike, ball);
        printGameResult.result(result);
        String expectation = "2볼 1스트라이크\n";
        assertThat(output.toString()).isEqualTo(expectation);
    }

    @Test
    void 투볼_투스트라이크_테스트() {
        int strike = 2;
        int ball = 2;
        Result result = new Result(strike, ball);
        printGameResult.result(result);
        String expectation = "2볼 2스트라이크\n";
        assertThat(output.toString()).isEqualTo(expectation);
    }

    @Test
    void 시작_출력문() {
        printGameResult.startGame();
        String expectation = "숫자를 입력해주세요 :" +
                " ";
        assertThat(output.toString()).isEqualTo(expectation);
    }
}