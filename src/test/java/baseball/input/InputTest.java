package baseball.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.MockedStatic;
import java.util.stream.Stream;

public class InputTest {

    @Nested
    public class InputRestartTest {

        private MockedStatic<Console> mockConsole;

        @ParameterizedTest(name = "When input {0}")
        @ArgumentsSource(InputTestIsRestartData.class)
        void isRestartTest_NormalCase(String inputMessage, boolean expected) {
            given(Console.readLine()).willReturn(inputMessage);

            assertThat(Input.isRestart()).isEqualTo(expected);
        }

        @Test
        @DisplayName("When input another Text")
        void isRestartTest_throwExceptionCase() {
            given(Console.readLine()).willReturn("213");

            assertThrows(IllegalArgumentException.class, () -> {
                Input.isRestart();
            });
        }

        @BeforeEach
        void mockClass() {
            mockConsole = mockStatic(Console.class);
        }

        @AfterEach
        void closMockClass() {
            mockConsole.close();
        }
    }

    static class InputTestIsRestartData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("1", true),
                    Arguments.of("2", false)
            );
        }
    }

    @Nested
    public class InputIntegerTest {

        private MockedStatic<Console> mockConsole;

        @ParameterizedTest(name = "When input {0}")
        @ArgumentsSource(InputIntegerNormalTestData.class)
        void inputIntegerTest_NormalCase(String inputMessage, int expected) {
            given(Console.readLine()).willReturn(inputMessage);

            int result = Input.getInputInteger();

            assertThat(result).isEqualTo(expected);
        }

        @ParameterizedTest(name = "When input {0}")
        @ArgumentsSource(InputIntegerAbnormalTestData.class)
        void inputIntegerTest_AbnormalCase(String inputMessage) {
            given(Console.readLine()).willReturn(inputMessage);

            assertThrows(IllegalArgumentException.class, () -> {
                Input.getInputInteger();
            });
        }


        @BeforeEach
        void mockClass() {
            mockConsole = mockStatic(Console.class);
        }

        @AfterEach
        void closMockClass() {
            mockConsole.close();
        }
    }

    static class InputIntegerNormalTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("1516", 1516),
                    Arguments.of("211", 211),
                    Arguments.of("8", 8)
            );
        }
    }

    static class InputIntegerAbnormalTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("15T"),
                    Arguments.of("pobi"),
                    Arguments.of("1564*")
            );
        }
    }
}
