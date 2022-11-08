package baseball.answer;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.answer.BaseballResponse;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.List;
import java.util.stream.Stream;

public class BaseballResponseTest {

    private final List<Integer> answer = List.of(5, 1, 3);

    @ParameterizedTest(name = "responseTest : Case {1}")
    @ArgumentsSource(BaseballResponseData.class)
    void responseTest(int candidate, String expected) {
        BaseballResponse baseballResponse = new BaseballResponse(answer, candidate);

        assertThat(baseballResponse.response()).isEqualTo(expected);
    }

    static class BaseballResponseData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(413, "2스트라이크"),
                    Arguments.of(135, "3볼"),
                    Arguments.of(789, "낫싱"),
                    Arguments.of(531, "2볼 1스트라이크")
            );
        }
    }
}
