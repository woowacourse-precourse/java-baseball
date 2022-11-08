package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    @DisplayName(value = "게임 재시작 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,false"})
    void restartTest(String input, boolean isReplay) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Game game = Game.getGame();
        boolean replayGame = game.replayGame();

        assertThat(replayGame).isEqualTo(isReplay);
    }

    @DisplayName(value = "게임 재시작 입력 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = "3")
    void restartExceptionTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Game game = Game.getGame();

        assertThatThrownBy(() -> game.replayGame())
                .isInstanceOf(IllegalArgumentException.class);
    }

}
