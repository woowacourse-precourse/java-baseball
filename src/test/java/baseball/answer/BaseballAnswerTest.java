package baseball.answer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import baseball.gametype.BaseballType;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.MockedStatic;
import java.time.Duration;
import java.util.stream.Stream;

public class BaseballAnswerTest {

    private MockedStatic<Randoms> mockRandoms;

    @Test
    void constructorTest() {
        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(1, new Integer[]{2,3});

        assertTimeout(Duration.ofMillis(5000), () -> {
            new BaseballAnswer(BaseballType.THREE_DIGITS);
        });
    }

    @ParameterizedTest(name = "isCorrectTest Case : {index}")
    @ArgumentsSource(BaseballAnswerCorrectTestData.class)
    void BaseballAnswerIsCorrectTest(int candidate, boolean expected) {
        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(1, new Integer[]{2,3});
        BaseballAnswer answer = new BaseballAnswer(BaseballType.THREE_DIGITS);

        boolean result = answer.isCorrect(candidate);

        assertThat(result).isEqualTo(expected);
    }

    static class BaseballAnswerCorrectTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(123, true),
                    Arguments.of(321, false),
                    Arguments.of(879, false)
            );
        }
    }

    @BeforeEach
    void mockingClass() {
        mockRandoms = mockStatic(Randoms.class);
    }

    @AfterEach
    void closeMockClass() {
        mockRandoms.close();
    }
}
