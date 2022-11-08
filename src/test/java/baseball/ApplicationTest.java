package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Nested
    class UserNumberTest {
        @ParameterizedTest
        @ValueSource(strings = {"4a3", "abc", "9l1", "32k", "kk1", "76p"})
        @DisplayName("입력에 문자가 포함된 경우 정상적으로 예외처리 되는지 테스트")
        void isValidNumber_IncludingCharacter_ExceptionThrown(String input) {
            assertThatThrownBy(() -> Application.isValidNumber(input)).isInstanceOf(IllegalArgumentException.class);

        }

        @DisplayName("세자리수가 아닌 경우 정상적으로 예외처리 되는지 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"9325", "12", "31", "1", "34718", "56"})
        void isValidNumber_NotThreeDigitNumber_ExceptionThrown(String input) {
            assertThatThrownBy(() -> Application.isValidNumber(input)).isInstanceOf(IllegalArgumentException.class);

        }

        @ParameterizedTest
        @ValueSource(strings = {"112", "363", "633", "122", "989", "23156"})
        @DisplayName("각 자릿수가 같은 경우 정상적으로 예외처리 되는지에 대한 테스트")
        void isValidNumber_SameDigits_ExceptionThrown(String input) {
            assertThatThrownBy(() -> Application.isValidNumber(input)).isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"102", "380", "013", "106", "120", "320"})
        @DisplayName("0을 포함하는 숫자를 입력받았을 경우 정상적으로 예외처리 되는지에 대한 테스트")
        void isValidNumber_IncludingZero_ExceptionThrown(String input) {
            assertThatThrownBy(() -> Application.isValidNumber(input)).isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Nested
    class NumberToListTest {
        @Test
        @DisplayName("입력받은 서로다른 숫자를 리스트로 정상 변환해주는지 테스트")
        void NumberToIntegerList_NormalNumber_Passed() {
            List<Integer> result = List.of(1, 2, 3);
            assertThat(Application.NumberToIntegerList(123)).isEqualTo(result);
        }

        @Test
        @DisplayName("같은 값이 포함된 숫자를 리스트로 정상 변환해주는지 테스트")
        void NumberToIntegerList_IncludingSameNumber_Passed() {
            List<Integer> result = List.of(9, 4, 9);
            assertThat(Application.NumberToIntegerList(949)).isEqualTo(result);
        }

        @Test
        @DisplayName("0이 포함된 숫자를 리스트로 정상 변환해주는지 테스트")
        void NumberToIntegerList_IncludingZero_Passed() {
            List<Integer> result = List.of(1, 0, 2);
            assertThat(Application.NumberToIntegerList(102)).isEqualTo(result);
        }
    }

    @Nested
    class PrintJudgeResultTest {
        private final PrintStream standardOut = System.out;
        private final OutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        void setup() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @AfterEach
        void tearDown() {
            System.setOut(standardOut);
        }

        String output(int ball, int strike) {
            Application.printJudgeResult(ball, strike);
            return outputStreamCaptor.toString().trim();
        }

        @ParameterizedTest
        @DisplayName("카운트에 따라 메시지가 맞게 출력되는지 테스트")
        @CsvSource({
                "3, 2, 3볼 2스트라이크",
                "0, 0, 낫싱",
                "0, 3, 3스트라이크"
        })
        void printJudgeResult_ThreeBallTwoStrike_Passed(int ball, int strike, String result) {
            assertThat(output(ball, strike)).isEqualTo(result);
        }
    }
}
