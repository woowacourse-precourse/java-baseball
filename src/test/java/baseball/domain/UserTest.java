package baseball.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class UserTest {
    @Test
    void 입력후유저값저장() {
        String input = "123";
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        User user = new User();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        user.getUserNumbers();
        Assertions.assertEquals(user.userNumbers, numbers);
    }

    @Test()
    void 숫자이외값을입력시예외처리() {
        User user = new User();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.checkIsDigit('a');
        });
    }
}
