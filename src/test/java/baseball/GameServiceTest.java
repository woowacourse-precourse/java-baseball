package baseball;

import baseball.GameService;
import baseball.InputBallNumber;
import baseball.RandomBallNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    GameService gameService;
    InputBallNumber inputBallNumber;
    RandomBallNumber randomBallNumber;

    @BeforeEach
    void before() {
        inputBallNumber = new InputBallNumber();
        randomBallNumber = new RandomBallNumber();
        gameService = new GameService(inputBallNumber, randomBallNumber);
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void after() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 숫자_클리어_테스트() {
        randomBallNumber.createRandomNumber();
        gameService.clearRandomBallNumber();
        assertThat(randomBallNumber.randomNumbers.size()).isSameAs(0);
    }
}