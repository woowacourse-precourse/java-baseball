package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserNumberTest {

    @Test
    void canSetUserNumberByTest() {
        UserNumber user = new UserNumber();
        user.setUserNumber("123");
        System.out.println(user.userNumber);
    }
    @Test
    void isUserNumberLengthEqualsThree() {
        UserNumber user = new UserNumber();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setUserNumber("1234");
        });
    }
    @Test
    void isUserNumberNotString() {
        UserNumber user = new UserNumber();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setUserNumber("aaa");
        });
    }

}