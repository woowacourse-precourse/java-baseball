package baseball.service;

import baseball.domain.User;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.fail;

class UserServiceTest {
    UserService userService = new UserService(new User());

    @Test
    void 잘못된_숫자_입력_예외발생() throws Exception {
        //given
        setSystemIn("012");

        //when

        //then
        try {
            userService.inputBaseballNumber();

            fail("IllegalArgumentException 발생해야 합니다");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void 잘못된_재시작_입력_예외발생() throws Exception {
        //given
        setSystemIn("0");

        //when

        //then
        try {
            userService.inputRestartSelection();

            fail("IllegalArgumentException 발생해야 합니다");
        } catch (IllegalArgumentException e) {
        }
    }

    public static void setSystemIn(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}