package baseball;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

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

    /*
    WARNING: An illegal reflective access operation has occurred
    WARNING: Please consider reporting this to the maintainers of camp.nextstep.edu.missionutils.Console
    WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
    private 필드 입력값 확인 test는 추후 삭제하기
     */
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

    @Test
    void getValidatedInput_WhenRun_getUserInputList_Success() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        user.setUserInput();
        List<Integer> inputArray = user.getValidatedInput();
        assertThat(inputArray).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void getValidatedInput_WhenRun_getUserInputList_Fail() {
        String input = "103";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        user.setUserInput();
        assertThatThrownBy(() -> user.getValidatedInput())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getValidatedQuitOrNotInput_WhenRun_getQuitOrNotInput_Success() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        user.setQuitOrNotInput();
        assertThat(user.getValidatedQuitOrNotInput()).isEqualTo(1);
    }
}