package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserTest extends NsTest {

    @Test
    @DisplayName("숫자가 아닌경우 테스트")
    void validateEmptyTest() {
        String input = "abc";
        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닙니다. 숫자만 입력해 주세요.");
    }

    @Test
    @DisplayName("입력이 아무것도 없는 경우 테스트")
    void validateCheckEmptyTest() {
        String input = "";
        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("압력을 하지 않았습니다.");
    }

    @Test
    @DisplayName("공백이 입력되었을 경우 테스트")
    void validateCheckVacuumTest() {
        String input = " ";
        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백을 제외하고 입력해 주세요.");
    }

    @Test
    @DisplayName("숫자의 갯수가 3개가 아닌경우 테스트")
    void validateTheNumberTest() {
        String input = "1234";
        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자만 입력해 주세요.");
    }

    @Test
    @DisplayName("중복된 값이 있는경우 테스트")
    void validateCheckOverlappingTest() {
        String input = "112";
        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 값이 있습니다.");
    }

    @Override
    protected void runMain() {

    }
}
