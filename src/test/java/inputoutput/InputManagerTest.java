package inputoutput;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputManagerTest {
    InputManager inputManager = new InputManager();
    static InputStream input;

    void setPlayerNumber() {
        String playerNumber = "122 ";
        input = new ByteArrayInputStream(playerNumber.getBytes());
        System.setIn(input);
    }

    @Test
    void 플레이어_입력_숫자_예외_발생() {
        setPlayerNumber();

        assertThatThrownBy(() -> inputManager.getPlayerNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    void setPlayerChoice() {
        String playerChoice = "y";
        input = new ByteArrayInputStream(playerChoice.getBytes());
        System.setIn(input);
    }

    @Test
    void 플레이어_입력_선택_예외_발생() {
        setPlayerChoice();

        assertThatThrownBy(() -> inputManager.getPlayerChoice())
                .isInstanceOf(IllegalArgumentException.class);
    }

}
