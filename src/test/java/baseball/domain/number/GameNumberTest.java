package baseball.domain.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameNumberTest {

    @Nested
    @DisplayName("int number, int index를 매개변수로 받는 생성자는")
    class IntIntConstructorTest extends ConstructorTestExceptionMessage {

        @ParameterizedTest
        @CsvSource(
                value = {
                    "1:0",
                    "2:0",
                    "3:0",
                    "4:1",
                    "5:1",
                    "6:1",
                    "7:2",
                    "8:2",
                    "9:2"
                },
                delimiter = ':'
        )
        @DisplayName("만약 1 ~ 9까지의 number와 0 ~ 2까지의 index가 주어지면 GameNumber를 생성한다.")
        void success_test(int number, int index) {
            assertThatCode(() -> new GameNumber(number, index)).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("만약 0이 주어지면 IllegalArgumentException 예외가 발생한다.")
        void wrong_number_exception_test() {
            assertThatThrownBy(() -> new GameNumber(0, 1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WRONG_NUMBER);
        }

        @Test
        @DisplayName("만약 3 이상의 index가 주어지면 IllegalArgumentException 예외가 발생한다.")
        void wrong_size_exception_test() {
            assertThatThrownBy(() -> new GameNumber(1, 3))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WRONG_SIZE);
        }
    }

    @Nested
    @DisplayName("char numberChar, int index를 매개변수로 받는 생성자는")
    class CharIntConstructorTest extends ConstructorTestExceptionMessage {
        @ParameterizedTest
        @CsvSource(
                value = {
                    "1:0",
                    "2:0",
                    "3:0",
                    "4:1",
                    "5:1",
                    "6:1",
                    "7:2",
                    "8:2",
                    "9:2"
                },
                delimiter = ':'
        )
        @DisplayName("만약 아스키 코드 상 1 ~ 9까지의 숫자와 0 ~ 2까지의 index가 주어지면 GameNumber를 생성한다.")
        void success_test(char numberChar, int index) {
            assertThatCode(() -> new GameNumber(numberChar, index)).doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(
                chars = {
                    'A',
                    'a',
                    '+',
                    '-',
                    '0'
                }
        )
        @DisplayName("만약 아스키 코드 상 1 ~ 9까지의 숫자가 아니라면 IllegalArgumentException 예외가 발생한다.")
        void wrong_number_exception_test(char numberChar) {
            assertThatThrownBy(() -> new GameNumber(numberChar, 1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WRONG_NUMBER);
        }

        @Test
        @DisplayName("만약 3 이상의 index가 주어지면 IllegalArgumentException 예외가 발생한다.")
        void wrong_size_exception_test() {
            assertThatThrownBy(() -> new GameNumber('1', 3))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WRONG_SIZE);
        }
    }

    @Nested
    @DisplayName("equals 메소드는")
    class EqualsMethodTest extends StandardGameNumber {

        @Test
        @DisplayName("만약 number와 index의 값이 동일한 GameNumber가 주어지면 true를 반환한다.")
        void true_test() {
            GameNumber equalsGameNumber = new GameNumber(number, index);

            assertThat(standardGameNumber).isEqualTo(equalsGameNumber);
        }

        @ParameterizedTest
        @CsvSource(
                value = {
                    "1:0",
                    "2:1"
                },
                delimiter = ':'
        )
        @DisplayName("만약 number나 index의 값이 동일하지 않은 GameNumber가 주어지면 false를 반환한다.")
        void false_test(int number, int index) {
            GameNumber notEqualsGameNumber = new GameNumber(number, index);

            assertThat(standardGameNumber).isNotEqualTo(notEqualsGameNumber);
        }
    }

    @Nested
    @DisplayName("equalsWithoutIndex 메소드는")
    class EqualsWithoutIndexMethodTest extends StandardGameNumber {

        @ParameterizedTest
        @ValueSource(
                ints = {
                    0,
                    2
                }
        )
        @DisplayName("만약 number만 동일한 GameNumber가 주어지면 true를 반환한다.")
        void true_test(int index) {
            GameNumber equalsGameNumber = new GameNumber(number, index);

            assertThat(standardGameNumber.equalsWithoutIndex(equalsGameNumber)).isTrue();
        }

        @Test
        @DisplayName("만약 number가 동일하지 않은 GameNumber가 주어지면 false를 반환한다.")
        void false_test() {
            GameNumber notEqualsGameNumber = new GameNumber(2, index);

            assertThat(standardGameNumber.equalsWithoutIndex(notEqualsGameNumber)).isFalse();
        }
    }
}