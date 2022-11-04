package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserNumberTest {

    @Test
    void isUserNumberSetByTest() {
        UserNumber user = new UserNumber(123);
        System.out.println(user.userNumber);
    }

}