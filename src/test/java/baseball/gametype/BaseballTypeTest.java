package baseball.gametype;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;

public class BaseballTypeTest {

    @ParameterizedTest(name = "Normal Case : {0}")
    @ArgumentsSource(BaseballTypeNormalTestData.class)
    void isFormatCorrectTest_NormalCase(int candidate) {
        boolean expected = true;

        boolean result = BaseballType.THREE_DIGITS.isFormatCorrect(candidate);

        assertThat(result).isEqualTo(expected);
    }


    static class BaseballTypeNormalTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(459),
                    Arguments.of(571)
            );
        }
    }

    @ParameterizedTest(name = "Abnormal Case : {0}")
    @ArgumentsSource(BaseballTypeAbnormalTestData.class)
    void isFormatCorrectTest_AbnormalCase(int candidate) {
        boolean expected = false;

        boolean result = BaseballType.THREE_DIGITS.isFormatCorrect(candidate);

        assertThat(result).isEqualTo(expected);
    }

    static class BaseballTypeAbnormalTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(455),
                    Arguments.of(5769),
                    Arguments.of(601)
            );
        }
    }
}
