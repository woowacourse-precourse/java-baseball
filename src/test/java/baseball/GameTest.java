package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    Game game = new Game();

    @ParameterizedTest
    @CsvSource(value = {"123: 3스트라이크", "132:2볼 1스트라이크", "456 : 낫싱"}, delimiter = ':')
    void getHintTest(String input, String output) {
        List<Integer> computerNumber = List.of(1, 2, 3);

        assertThat(game.getHint(input, computerNumber)).isEqualTo(output);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "", " "})
    void 게임_재시작_종료_예외_검증(String input) {
        assertThat(game.isRightAnswer(input)).isEqualTo(false);
    }
}
