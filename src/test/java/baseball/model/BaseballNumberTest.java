package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberTest {

    @Test
    @DisplayName("베이스볼 넘버 생성")
    void createBaseballNumber() throws NoSuchFieldException, IllegalAccessException {
        BaseballNumber baseballNumber = new BaseballNumber();

        Field answer = BaseballNumber.class.getDeclaredField("answer");
        answer.setAccessible(true);
        String answerTest = (String) answer.get(baseballNumber);
        assertAll(
                () -> assertNotNull(baseballNumber),
                () -> assertEquals(3, answerTest.length())
        );
    }
}