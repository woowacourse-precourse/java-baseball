package baseball.input;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberScannerTest {

    private InputStream getInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private final NumberScanner numberScanner = new NumberScanner();

    @Nested
    class 게임을_하기위해_숫자를_입력한다 {
        @Nested
        class 세_자리의_숫자를_입력한다 {
            @ParameterizedTest
            @ValueSource(strings = {"123", "456", "789"})
            void case1(String inputValue) {
                InputStream inputStream = getInputStream(inputValue);
                System.setIn(inputStream);

                assertThat(numberScanner.inputNumber()).isEqualTo(inputValue);
            }
        }

        @Nested
        class 세_자리_이상의_숫자를_입력한다 {
            @ParameterizedTest
            @ValueSource(strings = {"1233", "4567", "78988923"})
            void case2(String inputValue) {
                InputStream inputStream = getInputStream(inputValue);
                System.setIn(inputStream);

                assertThatThrownBy(numberScanner::inputNumber)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("세 자리의 숫자를 입력해 주세요.");
            }
        }

        @Nested
        class 세_자리_미만의_숫자를_입력한다 {
            @ParameterizedTest
            @ValueSource(strings = {"12", "4", "1"})
            void case3(String inputValue) {
                InputStream inputStream = getInputStream(inputValue);
                System.setIn(inputStream);

                assertThatThrownBy(numberScanner::inputNumber)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("세 자리의 숫자를 입력해 주세요.");
            }
        }

        @Nested
        class 숫자_0이_포함된_값을_입력한다 {
            @ParameterizedTest
            @ValueSource(strings = {"012", "102", "120"})
            void case4(String inputValue) {
                InputStream inputStream = getInputStream(inputValue);
                System.setIn(inputStream);

                assertThatThrownBy(numberScanner::inputNumber)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("0은 포함될 수 없습니다. 다시 입력해 주세요.");
            }
        }

        @Nested
        class 중복_숫자를_입력한다 {
            @ParameterizedTest
            @ValueSource(strings = {"112", "334", "999"})
            void case5(String inputValue) {
                InputStream inputStream = getInputStream(inputValue);
                System.setIn(inputStream);

                assertThatThrownBy(numberScanner::inputNumber)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("중복 숫자는 입력할 수 없습니다.");
            }
        }

        @Test
        void 숫자를_입력하지_않는다() {
            InputStream inputStream = getInputStream("");
            System.setIn(inputStream);

            assertThatThrownBy(numberScanner::inputNumber)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("세 자리의 숫자를 입력해 주세요.");
        }

    }

    @Nested
    class 재시작_또는_종료를_위해_1_또는_2를_입력한다 {
        @Test
        void 숫자_1을_입력한다() {
            InputStream inputStream = getInputStream("1");
            System.setIn(inputStream);

            assertThat(numberScanner.inputOneOrTwo()).isEqualTo(1);
        }

        @Test
        void 숫자_2를_입력한다() {
            InputStream inputStream = getInputStream("2");
            System.setIn(inputStream);

            assertThat(numberScanner.inputOneOrTwo()).isEqualTo(2);
        }

        @Test
        void 숫자_1_또는_2가_아닌_값을_입력한다() {
            InputStream inputStream = getInputStream("4");
            System.setIn(inputStream);

            assertThatThrownBy(numberScanner::inputOneOrTwo)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1 또는 2를 입력해주세요. (게임 재시작 : 1 / 게임 종료 : 2)");
        }

        @Test
        void 숫자를_입력하지_않는다() {
            InputStream inputStream = getInputStream("");
            System.setIn(inputStream);

            assertThatThrownBy(numberScanner::inputOneOrTwo)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1 또는 2를 입력해주세요. (게임 재시작 : 1 / 게임 종료 : 2)");
        }

    }


}