package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    static String RESTART_GAME = "1";
    static String END_GAME = "2";

    @DisplayName("Game: answer 만들 때 중복 값이 없는지 확인")
    @Test
    void answerNoDuplication() {
        List<Character> numList=Game.generateAnswer();
        assertEquals(numList.size(), numList.stream().distinct().count());
    }

    @DisplayName("Game: 사용자 입력값에 따라 재시작인지, 종료인지 확인")
    @Test
    void restartOrEndGame(){
        byte[] bufRestart = RESTART_GAME.getBytes();
        System.setIn(new ByteArrayInputStream(bufRestart));
        assertTrue(Game.restartOrEndGame());

        byte[] bufEnd = END_GAME.getBytes();
        System.setIn(new ByteArrayInputStream(bufEnd));
        assertFalse(Game.restartOrEndGame());
    }
}
