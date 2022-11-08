package baseball.utils;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    @Test
    void 사용자_입력값이_숫자인지_여부_판단(){
        String userInput = "abc";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            UserInput.setUserInput();
        });

        assertEquals("숫자만 입력해주세요.", exception.getMessage());
    }
}