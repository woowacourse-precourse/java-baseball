package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class UserTest {
    private User user = new User();

    @Test
    public void 사용자_숫자_입력_예외_테스트() {
        InputStream input = generateUserInput("12345");     // 3자리가 넘는 숫자입력
        System.setIn(input);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.inputNumber();
        });

        input = generateUserInput("abcd");  // 영문입력
        System.setIn(input);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.inputNumber();
        });

        input = generateUserInput("1 4");  // 빈칸을 포함한 3자리 입력
        System.setIn(input);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.inputNumber();
        });
    }

    @Test
    public void 사용자_재시작_입력_예외_테스트() {
        InputStream input = generateUserInput("3"); // 1,2가 아닌 숫자 입력
        System.setIn(input);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.inputRestartNumber();
        });

        input = generateUserInput("abc");   //  문자입력시
        System.setIn(input);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.inputRestartNumber();
        });

        input = generateUserInput("1 ");   //  공백포함
        System.setIn(input);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.inputRestartNumber();
        });
    }

    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}