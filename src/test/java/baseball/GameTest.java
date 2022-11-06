package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    Game game = new Game();

    @ParameterizedTest
    @CsvSource(value = {"123: 3스트라이크", "132:2볼 1스트라이크", "456 : 낫싱"}, delimiter = ':')
    public void getHintTest(String input, String output) {
        List<Integer> computerNumber = List.of(1, 2, 3);

        assertThat(game.getHint(input, computerNumber)).isEqualTo(output);
    }
}
