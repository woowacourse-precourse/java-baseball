package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    @DisplayName("유저는 세 자리 숫자를 입력받을 수 있다.")
    void setUserNumbersTest() {
        // Given
        String input = "123";

        // When
        user.setUserNumbers(input);

        // Then
        assertAll("유저 숫자 검증",
                () -> assertThat(user.numbers.size()).isEqualTo(3),
                () -> assertThat(user.numbers.get(0)).isEqualTo(1),
                () -> assertThat(user.numbers.get(1)).isEqualTo(2),
                () -> assertThat(user.numbers.get(2)).isEqualTo(3)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "12", "9"})
    @DisplayName("숫자 3개가 입력되지 않으면 예외가 발생한다.")
    void setUserNumbersTest_NotThreeNumbers(String input) {
        // When Then
        assertThatThrownBy(() -> user.setUserNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 3개가 입력되지 않았습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"string", "숫자", "."})
    @DisplayName("숫자가 아닌 input이 들어오면 예외가 발생한다.")
    void setUserNumbersTest_NotNumber(String input) {
        // When Then
        assertThatThrownBy(() -> user.setUserNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 잘못 입력되었습니다.");
    }
}