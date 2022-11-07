package baseball.game;

import baseball.number.PlayerNumber;
import baseball.number.TargetNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class BaseballGameTest {

    BaseballGame baseballGame;
    PlayerNumber playerNumber;
    TargetNumber targetNumber;
    Scanner scanner;

    public static InputStream getPlayerInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeEach
    public void beforeEach() {
        playerNumber = new PlayerNumber();
        targetNumber = new TargetNumber();
        //baseballGame = new BaseballGame(playerNumber, targetNumber);

    }

    @ParameterizedTest
    @DisplayName("숫자가 정상적으로 입력되는지 확인")
    @ValueSource(strings = {"123", "1234", " ", "가나다"})
    void checkInput(String input) {
        InputStream in = getPlayerInput(input);
        System.setIn(in);

        org.assertj.core.api.Assertions.assertThat(playerNumber.enterPlayerNumber())
                .isEqualTo(input);

    }

    @ParameterizedTest
    @DisplayName("입력 받은 수의 유효성 검증")
    @ValueSource(strings = {"1234", " ", "가나다", "121"})
    void checkValidNumber(String input) {
        InputStream in = getPlayerInput(input);
        System.setIn(in);

        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> playerNumber.setPlayerNumber());
    }

    @Test
    @DisplayName("무작위 숫자 생성")
    void generateTestNumber() {
        TargetNumber targetNumber = new TargetNumber();
        targetNumber.generateTargetNumber();
        System.out.println("targetNumber.getNumber() = " + targetNumber.getNumber());

        Assertions.assertThat(targetNumber.getNumber().size()).isEqualTo(3);
    }

}