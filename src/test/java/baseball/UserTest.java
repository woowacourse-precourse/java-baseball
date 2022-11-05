package baseball;

import java.io.*;
import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private static User user;

    @BeforeAll
    static void initAll() {
        user = new User();
    }

    @Test
    void setUserInput_WhenRun_PrintStartStatement() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        user.setUserInput();
        assertThat(out.toString()).isEqualTo("숫자를 입력해주세요 : ");
    }

    @Test
    void setUserInput_WhenRun_setUserInput_Success() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        user.setUserInput();
        try {
            Field field = user.getClass().getDeclaredField("userInput");
            field.setAccessible(true);

            String value = String.valueOf(field.get(user));
            assertThat(value).isEqualTo("123");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}