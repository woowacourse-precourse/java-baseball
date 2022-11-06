package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserTest {

    User user;

    private User setInput(String input) {
        user = new User();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        user.inputNumber();
        return user;
    }

    @Nested
    @DisplayName("inputNumber 메서드 : ")
    class InputNumber {

        @Test
        @DisplayName("입력한 숫자를 통해서 User 객체 생성 성공")
        void addNumber_Success() {
            String input = "123";
            setInput(input);
            List<Integer> numbers = user.getNumbers();
            assertThat(numbers).contains(1,2,3);
        }

        @Test
        @DisplayName("숫자가 아닌 문자열이 입력되는 경우 IllegalArgumentException 발생")
        void validateNumbers_Exception() {
            String input = "c34";
            assertThatThrownBy(() -> setInput(input)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("3자리가 아닌 숫자가 오는 경우")
        void validateLength_Exception() {
            String input = "1234";
            assertThatThrownBy(() -> setInput(input)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("중복되는 숫자가 오는 경우")
        void validateDifferentNumbers_Exception() {
            String input = "223";
            assertThatThrownBy(() -> setInput(input)).isInstanceOf(IllegalArgumentException.class);
        }
    }

}