package baseball.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputImplTest {

    private static final Input input = new InputImpl();

    @Nested
    class BaseballInputValidationTest {

        @Test
        @DisplayName("서로다른 3자리 숫자는 입력 가능하다.")
        void case1() {
            //given
            String baseballInput = "123";
            InputStream in = new ByteArrayInputStream(baseballInput.getBytes());
            System.setIn(in);

            //when
            String result = input.baseballInput();

            //then
            assertThat(result).isEqualTo(baseballInput);

        }

        @ParameterizedTest
        @ValueSource(strings = {"122", "1234", "12"})
        @DisplayName("서로 다른 3자리 숫자가 아닐 경우 예외가 발생한다.")
        void case2(String baseballInput) {
            //given
            InputStream in = new ByteArrayInputStream(baseballInput.getBytes());
            System.setIn(in);

            //when //then
            assertThatThrownBy(input::baseballInput)
                    .isInstanceOf(IllegalArgumentException.class);

        }
    }

    @Nested
    class EndInputValidationTest {
        @Test
        @DisplayName("게임 종료 후 입력은 1 또는 2가 가능하다.")
        void case1() {
            //given
            String endInput = "1";
            InputStream in = new ByteArrayInputStream(endInput.getBytes());
            System.setIn(in);

            //when
            String result = input.endInput();

            //then
            assertThat(result).isEqualTo(endInput);
        }

        @ParameterizedTest
        @ValueSource(strings = {"0", "3", "12"})
        @DisplayName("게임 종료 후 입력은 1 또는 2만 가능하다.")
        void case2(String endInput) {
            //given
            InputStream in = new ByteArrayInputStream(endInput.getBytes());
            System.setIn(in);

            //then
            assertThatThrownBy(input::endInput)
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
