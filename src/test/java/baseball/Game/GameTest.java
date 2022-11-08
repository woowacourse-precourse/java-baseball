package baseball.Game;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

class GameTest {

    // startGame() 메소드는 "ApplicationTest"에서 Integration Test 로 진행

    @Test
    void resetGameOrQuit_InvalidInput_Fail() {
        String invalidInput = "3";
        InputStream in = new ByteArrayInputStream(invalidInput.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> Game.resetGameOrQuit()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시작하려면 1, 종료하려면 2 둘 중 하나를 입력해주세요");
    }
}