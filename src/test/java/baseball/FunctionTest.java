package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class FunctionTest {
    Game game = new Game();
    List<Integer> guess1 = new ArrayList<>(Arrays.asList(3, 1, 2));
    List<Integer> guess2 = new ArrayList<>(Arrays.asList(9, 3, 7));

    @Test
    void checkAnswerTest() {
        game.setAnswer(guess1);
        BallCount result = game.checkAnswer(guess1);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);

        result = game.checkAnswer(guess2);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void isOverTest() {
        game.setAnswer(guess1);
        game.checkAnswer(guess1);
        assertThat(game.isOver()).isEqualTo(true);
        game.checkAnswer(guess2);
        assertThat(game.isOver()).isEqualTo(false);
    }

    @Test
    void testArgumentException() {
        String overedString = "1234";

        assertThatThrownBy(() -> game.checkInputFormat(overedString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
