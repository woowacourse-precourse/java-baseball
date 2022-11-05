package baseball;

import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void 유저_입력값_테스트() {
        User user = new User();
        String input = "1234";
        user.validate(input);
        String input2 = "012";
        user.validate(input2);
        String input3 = "abc";
        user.validate(input3);
        String input4 = "12";
        user.validate(input4);
        String input5 = "123";
        user.validate(input5);
    }
}