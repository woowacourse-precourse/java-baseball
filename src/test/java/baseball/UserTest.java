package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest extends NsTest {

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName("유저 입력값 테스트")
    void 유저_입력값_테스트() {
        User user = new User();

        assertThatThrownBy(() -> runException("2345"))
                        .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> runException("102"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}