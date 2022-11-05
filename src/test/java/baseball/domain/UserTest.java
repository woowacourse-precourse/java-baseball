package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class UserTest {
    User user;

    UserTest() {
        this.user = new User();
    }
//
//    @Test
//    void 입력후유저값저장() {
//        String input = "123";
//        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        user.inputUserNumbers();
//        Assertions.assertEquals(user.userNumbers, numbers);
//    }
//
//    @Test()
//    void 숫자이외값을입력시예외처리() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.checkIsDigit('a');
//        });
//    }
//
//    @Test()
//    void 중복된숫자입력예외처리() {
//        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 1));
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.checkDuplicationNumber(numbers, 1);
//        });
//    }
//
//    @Test()
//    void 불가능한숫자입력예외처리() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.checkValidNumber(0);
//        });
//    }
//
//    @Test()
//    void 글자수길이초과예외처리() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            user.checkLength("1234");
//        });
//    }
}
