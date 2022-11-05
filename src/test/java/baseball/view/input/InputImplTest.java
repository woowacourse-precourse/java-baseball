package baseball.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputImplTest {

    @Nested
    class BaseballInputValidationTest {

        @Test
        @DisplayName("서로다른 3자리 숫자는 입력 가능하다.")
        void case1() {
            //given
            Input input = new InputImpl();

            String baseballInput = "123";
            InputStream in = new ByteArrayInputStream(baseballInput.getBytes());
            System.setIn(in);

            //when
            String result = input.baseballInput();

            //then
            assertThat(result).isEqualTo(baseballInput);

        }

        @Test
        @DisplayName("각 자리수가 서로다른 숫자가 아니면 안된다.")
        void case2() {
            ///given
            Input input = new InputImpl();

            String baseballInput = "122";
            InputStream in = new ByteArrayInputStream(baseballInput.getBytes());
            System.setIn(in);

            //then
            assertThatThrownBy(input::baseballInput)
                    .isInstanceOf(IllegalArgumentException.class);

        }

        @Test
        @DisplayName("3자리 숫자로 입력해야 한다.")
        void case3() {
            ///given
            Input input = new InputImpl();

            String baseballInput = "1234";
            InputStream in = new ByteArrayInputStream(baseballInput.getBytes());
            System.setIn(in);

            //then
            assertThatThrownBy(input::baseballInput)
                    .isInstanceOf(IllegalArgumentException.class);

        }

        @Test
        @DisplayName("3자리 숫자로 입력해야 한다.")
        void case4() {
            ///given
            Input input = new InputImpl();

            String baseballInput = "12";
            InputStream in = new ByteArrayInputStream(baseballInput.getBytes());
            System.setIn(in);

            //then
            assertThatThrownBy(input::baseballInput)
                    .isInstanceOf(IllegalArgumentException.class);

        }
    }
}
