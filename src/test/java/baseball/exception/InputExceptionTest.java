package baseball.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class InputExceptionTest {
    private static final InputException inputException = new InputException();

    @Nested
    @DisplayName("중복 숫자")
    class isDigitException {
        @Test
        @DisplayName("중복 숫자 O")
        void case1() {
            int number = 1;
            List<Integer> numbers = new ArrayList<>(List.of(1, 2));
            Assertions.assertThatThrownBy(() -> inputException.isDuplicationNumberException(number, numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] " + "입력한 문자에 중복이 있습니다." + " 게임을 종료합니다.");
        }

        @Test
        @DisplayName("중복 숫자 X")
        void case2() {
            int number = 3;
            List<Integer> numbers = new ArrayList<>(List.of(1, 2));
            Assertions.assertThatCode(() -> inputException.isDuplicationNumberException(number, numbers))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("입력한 문자의 크기가 3")
    class inputDataSize3 {
        @DisplayName("예외 발생 O")
        @ParameterizedTest
        @CsvSource({
                "1", "12", "1234", "-1234"
        })
        void case1(String numbers) {
            Assertions.assertThatThrownBy(() -> inputException.isInvalidNumbersSize(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] " + "입력한 문자의 크기가 올바르지 않습니다." + " 게임을 종료합니다.");
        }

        @Test
        @DisplayName("예외 발생 X")
        void case2() {
            String numbers = "123";
            Assertions.assertThatCode(() -> inputException.isInvalidNumbersSize(numbers))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("입력한 재시작/종료 코드의 크기가 1")
    class inputCodeSize1 {
        @Test
        @DisplayName("공백 예외 발생 O")
        void case1() {
            String runCode = "";
            Assertions.assertThatThrownBy(() -> inputException.isInvalidCodeSize(runCode))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] " + "입력한 문자의 크기가 올바르지 않습니다." + " 게임을 종료합니다.");
        }

        @ParameterizedTest
        @CsvSource({
                "12", "123"
        })
        @DisplayName("예외 발생 O")
        void case2(String runCode) {
            Assertions.assertThatThrownBy(() -> inputException.isInvalidCodeSize(runCode))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] " + "입력한 문자의 크기가 올바르지 않습니다." + " 게임을 종료합니다.");
        }

        @Test
        @DisplayName("예외 발생 X")
        void case3() {
            String runCode = "1";
            Assertions.assertThatCode(() -> inputException.isInvalidCodeSize(runCode))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("숫자가 아닌 문자 테스트")
    class digitTest {
        @Test
        @DisplayName("공백 예외 발생 O")
        void case1() {
            String input = " ";
            Assertions.assertThatThrownBy(() -> inputException.isDigitException(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] " + "입력한 문자 중 숫자가 아닌 문자가 포함되어 있습니다."
                            + " 게임을 종료합니다.");
        }

        @ParameterizedTest
        @CsvSource({
                "a", "1a3", "-12", "1-2"
        })
        @DisplayName("예외 발생 O")
        void case3(String input) {
            Assertions.assertThatThrownBy(() -> inputException.isDigitException(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] " + "입력한 문자 중 숫자가 아닌 문자가 포함되어 있습니다."
                            + " 게임을 종료합니다.");
        }

        @ParameterizedTest
        @CsvSource({
                "1", "2", "123", "456", "789"
        })
        @DisplayName("예외 발생 X")
        void case4(String input) {
            Assertions.assertThatCode(() -> inputException.isDigitException(input))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("재시작/종료 코드 테스트")
    class runCodeTest {
        @Test
        @DisplayName("예외 발생 X")
        void case1() {
            int restart = 1;
            int stop = 2;
            Assertions.assertThatCode(() -> inputException.isInvalidCode(restart))
                    .doesNotThrowAnyException();
            Assertions.assertThatCode(() -> inputException.isInvalidCode(stop))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("예외 발생 O")
        void case2() {
            List<Integer> codes = new ArrayList<>(List.of(0, 3, 4, 5, 6, 7, 8, 9));
            for (Integer code : codes) {
                Assertions.assertThatThrownBy(() -> inputException.isInvalidCode(code))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] " + "해당 명령어는 존재하지 않습니다." + " 게임을 종료합니다.");
            }
        }
    }
}
