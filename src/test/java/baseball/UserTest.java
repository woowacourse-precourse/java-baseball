package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import model.User;
import org.junit.jupiter.api.Test;

public class UserTest {

    // computer Test
    @Test
    void 문자열을_숫자로_변환_case_1() {
        User user = new User();
        int result = user.parseIntFromStr("123");
        assertThat(result).isEqualTo(123);
    }


}
