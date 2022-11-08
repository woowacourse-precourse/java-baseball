package baseball.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserTest {

    @Nested
    @DisplayName("inputNumber 메서드 : ")
    class InputNumber {

        @Test
        @DisplayName("입력한 숫자를 통해서 User 객체 생성 성공")
        void addNumber_Success() {
            User user = new User();
            String input = "123";
            user.addUserNumbers(input);
            List<Integer> numbers = user.getNumbers();
            assertThat(numbers).contains(1, 2, 3);
        }

        @Test
        @DisplayName("숫자가 아닌 문자열이 입력되는 경우 IllegalArgumentException 발생")
        void validateNumbers_Exception() {
            User user = new User();
            String input = "c34";
            assertThatThrownBy(() -> user.addUserNumbers(input)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("3자리가 아닌 숫자가 오는 경우")
        void validateLength_Exception() {
            User user = new User();
            String input = "1234";
            assertThatThrownBy(() -> user.addUserNumbers(input)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("중복되는 숫자가 오는 경우")
        void validateDifferentNumbers_Exception() {
            User user = new User();
            String input = "223";
            assertThatThrownBy(() -> user.addUserNumbers(input)).isInstanceOf(IllegalArgumentException.class);
        }
    }
}