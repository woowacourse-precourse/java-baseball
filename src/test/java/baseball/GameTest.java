package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class GameTest {

    @Test
    void resetGameOrQuit_InvalidInput_Fail() {
        String invalidInput = "3";
        InputStream in = new ByteArrayInputStream(invalidInput.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> Game.ResetGameOrQuit())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시작하려면 1, 종료하려면 2 둘 중 하나를 입력해주세요");
    }
}