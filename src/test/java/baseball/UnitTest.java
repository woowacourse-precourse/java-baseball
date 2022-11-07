package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UnitTest {
    @Nested
    class GenerateRandomNumberStringTest {
        @Test
        @DisplayName("컴퓨터가 생성한 수 테스트")
        @RepeatedTest(100)
        void generateRandomNumberString_Success() {
            String randomNumberString = Application.generateRandomNumberString();
            List<Character> usedNumber = new ArrayList<>();

            // 컴퓨터가 생성한 수는 3자리 수여야 한다
            assertThat(randomNumberString.length()).isEqualTo(3);

            for (int i = 0; i < randomNumberString.length(); i++) {
                char ch = randomNumberString.charAt(i);

                // 각 자리는 1~9까지의 수이고 중복되어서는 안된다.
                assertThat(ch).isGreaterThanOrEqualTo('1')
                        .isLessThanOrEqualTo('9');
                assertThat(usedNumber).doesNotContain(ch);

                usedNumber.add(ch);
            }
        }
    }

    @Nested
    class GetGuessNumberInputTest {
        @Test
        @DisplayName("기본흐름: 플레이어가 중복되지 않는 1~9 세자리 수 입력하는 경우 입력값 그대로 반환")
        void getGuessNumberInput_ValidInput_Success() {
            String guessNumberInput = "123";
            InputStream is = new ByteArrayInputStream(guessNumberInput.getBytes());

            System.setIn(is);
            assertThat(Application.getGuessNumberInput()).isEqualTo(guessNumberInput);
        }

        @Test
        @DisplayName("예외흐름: 플레이어가 2자리를 입력하는 경우")
        void getGuessNumberInput_InvalidLength2_IllegalArgumentExceptionThrown() {
            String guessNumberInput = "12";
            InputStream is = new ByteArrayInputStream(guessNumberInput.getBytes());

            System.setIn(is);
            assertThatThrownBy(() -> Application.getGuessNumberInput())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("예외흐름: 플레이어가 4자리를 입력하는 경우")
        void getGuessNumberInput_InvalidLength4_IllegalArgumentExceptionThrown() {
            String guessNumberInput = "1234";
            InputStream is = new ByteArrayInputStream(guessNumberInput.getBytes());

            System.setIn(is);
            assertThatThrownBy(() -> Application.getGuessNumberInput())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("예외흐름: 플레이어가 1~9 숫자가 아닌 값을 입력하는 경우")
        void getGuessNumberInput_InvalidCharacter_IllegalArgumentExceptionThrown() {
            String guessNumberInput = "12a";
            InputStream is = new ByteArrayInputStream(guessNumberInput.getBytes());

            System.setIn(is);
            assertThatThrownBy(() -> Application.getGuessNumberInput())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("예외흐름: 플레이어가 0이 들어간 값 입력하는 경우")
        void getGuessNumberInput_InvalidNumber_IllegalArgumentExceptionThrown() {
            String guessNumberInput = "104";
            InputStream is = new ByteArrayInputStream(guessNumberInput.getBytes());

            System.setIn(is);
            assertThatThrownBy(() -> Application.getGuessNumberInput())
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("예외흐름: 플레이어가 중복된 값을 입력하는 경우")
        void getGuessNumberInput_DuplicatedNumber_IllegalArgumentExceptionThrown() {
            String guessNumberInput = "141";
            InputStream is = new ByteArrayInputStream(guessNumberInput.getBytes());

            System.setIn(is);
            assertThatThrownBy(() -> Application.getGuessNumberInput())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
