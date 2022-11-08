package baseball.service;

import baseball.domain.User;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.fail;
import static org.assertj.core.api.InstanceOfAssertFactories.PATH;

public class UserServiceTest {
    UserService userService = new UserService(new User());

    @Test
    public void 숫자_입력오류_예외() throws Exception {
        //given
        setSystemIn("012");

        //when

        //then
        try {
            userService.inputBaseballNumber();
            fail("IllegalArgumentException 발생");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void 재시작_입력오류_예외() throws Exception {
        //given
        setSystemIn("0");

        //when

        //then
        try {
            userService.inputRestartSelection();
            fail("IllegalArgumentException 발생");
        } catch (IllegalArgumentException e) {

        }
    }

    private void setSystemIn(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
