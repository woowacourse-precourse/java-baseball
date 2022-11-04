package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserNumberTest {


    private UserNumber user;

    @BeforeEach
    void createUser() {
        user = new UserNumber();
    }

    @Test
    void canSetUserNumberByTest() {
        user.setUserNumber("123");
        System.out.println(user.userNumber);
    }
    @Test
    void isUserNumberLengthEqualsThree() {
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