package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    GameService gameService;

    @BeforeEach
    void before() {
        gameService = new GameService(new InputBallNumber(), new RandomBallNumber());
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
}