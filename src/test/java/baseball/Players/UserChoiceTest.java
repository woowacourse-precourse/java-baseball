package baseball.Players;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.Players.UserChoice;
import java.io.*;
import org.junit.jupiter.api.Test;

class UserChoiceTest {

    @Test
    void getResetOrQuit_InvalidInput_ExceptionThrown() {
        String invalidInput = "3";
        InputStream in = new ByteArrayInputStream(invalidInput.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> new UserChoice()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시작하려면 1, 종료하려면 2 둘 중 하나를 입력해주세요");
    }

    @Test
    void getResetOrQuit_ValidInput_ReturnString() {
        String validInput = "1";
        InputStream in = new ByteArrayInputStream(validInput.getBytes());
        System.setIn(in);
        UserChoice userChoice = new UserChoice();
        String userNumbers = userChoice.getResetOrQuit();
        assertThat(userNumbers).isEqualTo("1");
    }
}