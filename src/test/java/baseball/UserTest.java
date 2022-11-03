package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import model.User;
import org.junit.jupiter.api.Test;

public class UserTest extends NsTest {

    // computer Test
    @Test
    void 문자열을_숫자로_변환_case_1() {
        User user = new User();
        int result = user.parseIntFromStr("123");
        assertThat(result).isEqualTo(123);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
