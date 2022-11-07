package baseball.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    User user = new User();

    @Test
    void 문자_to_숫자() {
        char input = '1';
        int result = 1;
        Assertions.assertThat(user.parseCharToDigit(input)).isEqualTo(result);
    }

}