package baseball.input;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

class NumberScannerTest {

    private static final int DIGITS_FOR_THIS_GAME = 3;

    private InputStream getInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private final NumberScanner numberScanner = new NumberScanner();
    private final NumberGenerator numberGenerator = new NumberGenerator();

    @Nested
    class 게임을_하기위해_숫자를_입력한다 {
        @Nested
        class 게임에서_요구된_자리수의_숫자를_입력한다 {
            @RepeatedTest(5)
            void case1() {
                String inputValue = numberGenerator.createCorrectInputValue();

                InputStream inputStream = getInputStream(inputValue);
                System.setIn(inputStream);

                assertThat(numberScanner.inputNumber()).isEqualTo(inputValue);
            }
        }

        @Nested
        class 게임에서_요구된_자리수_이상의_숫자를_입력한다 {
            @RepeatedTest(5)
            void case2() {
                String inputValue = numberGenerator.createInputValueMoreThanDigits();
                InputStream inputStream = getInputStream(inputValue);
                System.setIn(inputStream);

                assertThatThrownBy(numberScanner::inputNumber)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DIGITS_FOR_THIS_GAME + "자리의 숫자를 입력해 주세요.");
            }
        }

        @Nested
        class 게임에서_요구된_자리수_미만의_숫자를_입력한다 {
            @RepeatedTest(5)
            void case3() {
                String inputValue = numberGenerator.createInputValueLessThanDigits();
                InputStream inputStream = getInputStream(inputValue);
                System.setIn(inputStream);

                assertThatThrownBy(numberScanner::inputNumber)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DIGITS_FOR_THIS_GAME + "자리의 숫자를 입력해 주세요.");
            }
        }

        @Nested
        class 숫자_0이_포함된_값을_입력한다 {  // repeat test로 변경하고
            @RepeatedTest(5)
            void case4() {
                String inputValue = numberGenerator.createInputValueContainsZero();
                InputStream inputStream = getInputStream(inputValue);
                System.setIn(inputStream);

                assertThatThrownBy(numberScanner::inputNumber)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("0은 포함될 수 없습니다. 다시 입력해 주세요.");
            }
        }

        @Nested
        class 중복_숫자를_입력한다 {
            @RepeatedTest(5)
            void case5() {
                String inputValue = numberGenerator.createDuplicatedNumber();
                InputStream inputStream = getInputStream(inputValue);
                System.setIn(inputStream);

                System.out.println(inputValue);

                assertThatThrownBy(numberScanner::inputNumber)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("중복 숫자는 입력할 수 없습니다.");
            }
        }

        @Nested
        class 숫자가_아닌_값을_입력한다 {
            @ParameterizedTest
            @ValueSource(strings = {"", "안녕ㅎ", "hi", "^^"})
            void test(String inputValue) {
                InputStream inputStream = getInputStream(inputValue);
                System.setIn(inputStream);

                assertThatThrownBy(numberScanner::inputNumber)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자만 입력해 주세요.");
            }
        }

        @Nested
        class 음수_값을_입력한다 {
            @RepeatedTest(10)
            void 음수_값을_입력한다() {
                String inputValue = numberGenerator.createNegativeNumber();
                InputStream inputStream = getInputStream(inputValue);
                System.setIn(inputStream);

                assertThatThrownBy(numberScanner::inputNumber)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("양수만 입력해 주세요.");
            }
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