package baseball.game;

import baseball.number.PlayerNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class BaseballGameTest {

    BaseballGame baseballGame = new BaseballGame();
    PlayerNumber playerNumber;
    Scanner scanner;

    public static InputStream getPlayerInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @DisplayName("숫자가 정상적으로 입력되는지 확인")
    @ValueSource(strings = {"123","1234"," ","가나다"})
    void chkInput(String input) {
        //Given
        InputStream in = getPlayerInput(input);
        System.setIn(in);

        org.assertj.core.api.Assertions.assertThat(baseballGame.setPlayerNumber())
                .isEqualTo(input);

    }

    @ParameterizedTest
    @DisplayName("입력이 숫자가 아니거나 3자리가 아닌지 확인하기")
    @ValueSource(strings = {"1234", " ", "가나다", "121"})
    void chkValidNumber(String input) {
        InputStream in = getPlayerInput(input);
        System.setIn(in);

        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> new PlayerNumber(input));
    }

}