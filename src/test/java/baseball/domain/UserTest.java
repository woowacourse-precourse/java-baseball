package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사용자의 입력에 대한 테스트")
class UserTest {

    private User user;

    @BeforeEach
    @DisplayName("테스트에 사용할 User 인스턴스 생성")
    public void makeGameInstance() {
        this.user = new User();
        assertThat(user).isInstanceOf(User.class);
    }

    @Test
    @DisplayName("입력에 대해서 자릿수별로 각기 다른 숫자가 입력되었는지 확인")
    public void isInputElementsUnique() {
        String input = "111";

        assertThatThrownBy(() -> {
            user.isValidInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자릿수별로 각기 다른 숫자를 입력해야 합니다.");
    }

    @Test
    @DisplayName("입력에 대해서 자릿수별로 입력의 크기가 3자리보다 작은지 확인")
    public void isInputElementsLessThenThree() {
        String input = "1";

        assertThatThrownBy(() -> {
            user.isValidInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 3글자보다 작습니다. 3글자를 입력해주세요.");
    }

    @Test
    @DisplayName("입력에 대해서 자릿수별로 입력의 크기가 3자리보다 큰지 확인")
    public void isInputElementsMoreThenThree() {
        String input = "154849";

        assertThatThrownBy(() -> {
            user.isValidInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 3글자보다 큽니다. 3글자를 입력해주세요.");
    }

}