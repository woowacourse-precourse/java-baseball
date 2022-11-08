package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void playGame() {
        assertTrue(Game.playGame(), "게임 시작 설정 Test 성공");
    }

    @Test
    void restartGame() {

        String answer = "1";
        InputStream in = new ByteArrayInputStream(answer.getBytes());

        System.setIn(in);
        boolean result = Game.restartGame();

        assertTrue(result);

    }
    @Test
    void finishGame() {

        String answer = "2";
        InputStream in = new ByteArrayInputStream(answer.getBytes());

        System.setIn(in);
        boolean result = Game.restartGame();

        assertFalse(result);

    }

}