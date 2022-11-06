package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class GameStateTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 스트라이크_볼() {
        GameState strike = new GameState();
        GameState ball = new GameState();
        strike.addStrike();
        ball.addBall();
        assertThat(strike.getStrike()).isEqualTo(1);
        assertThat(ball.getBall()).isEqualTo(1);
    }

    @Test
    void 원스트라이크() {
        GameState gameState = new GameState();
        gameState.addStrike();

        gameState.printGameState();
        String answer = "1스트라이크";

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(answer);
    }

    @Test
    void 투볼() {
        GameState gameState = new GameState();
        gameState.addBall();
        gameState.addBall();

        gameState.printGameState();
        String answer = "2볼";

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(answer);
    }

    @Test
    void 투볼원스트라이크() {
        GameState gameState = new GameState();
        gameState.addBall();
        gameState.addBall();
        gameState.addStrike();

        gameState.printGameState();
        String answer = "2볼 1스트라이크";

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(answer);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}