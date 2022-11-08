package baseball.service;

import baseball.number.InputNumber;
import baseball.number.RandomNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameServiceTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    GameService gameService;
    InputNumber inputNumber;
    RandomNumber randomNumber;

    @BeforeEach
    void before() {
        inputNumber = new InputNumber();
        randomNumber = new RandomNumber();
        gameService = new GameService(inputNumber, randomNumber);
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void after() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 숫자_클리어_테스트() {
        randomNumber.createRandomNumber();
        assertThat(randomNumber.getRandomNumbers().size()).isSameAs(3);

        gameService.clearRandomBallNumber();
        assertThat(randomNumber.getRandomNumbers().size()).isSameAs(0);
    }

    @Test
    void 예외_테스트() {
        String three = "3";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> gameService.isNotRestartedAndQuitedGame(three));
        String message = exception.getMessage();
        assertEquals("1 또는 2를 입력해주세요", message);
    }
}