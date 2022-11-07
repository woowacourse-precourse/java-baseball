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

        @ParameterizedTest(name = "isRestart Test When input {0}")
        @ArgumentsSource(InputTestIsRestartData.class)
        void isRestartTest_NormalCase(String inputMessage, boolean excepted) {
            given(Console.readLine()).willReturn(inputMessage);

            assertThat(Input.isRestart()).isEqualTo(excepted);
        }

        @Test
        @DisplayName("isRestart Test When input another Text")
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
}
