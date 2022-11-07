package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    @Test
    @DisplayName("베이스볼 넘버 생성")
    void createBaseballNumber() throws NoSuchFieldException, IllegalAccessException {
        BaseballGame baseballGame = new BaseballGame();

        Field answer = BaseballGame.class.getDeclaredField("computerAnswer");
        answer.setAccessible(true);
        String answerTest = (String) answer.get(baseballGame);
        assertAll(
                () -> assertNotNull(baseballGame),
                () -> assertNotNull(answerTest),
                () -> assertEquals(3, answerTest.length())
        );
    }
}