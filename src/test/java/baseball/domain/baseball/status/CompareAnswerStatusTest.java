package baseball.domain.baseball.status;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.baseball.BaseballContext;
import baseball.domain.baseball.BaseballContextFake;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CompareAnswerStatusTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 비교상태에서_모두_스트라이크인_경우_3스트라이크를_반환합니다() {
        BaseballContext context = new BaseballContextFake(new CompareAnswerStatus(), List.of(1, 2, 3),
                List.of(1, 2, 3));
        var status = new CompareAnswerStatus();
        status.next(context);

        var actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo("3스트라이크");
    }

    @Test
    void 비교상태에서_모두_스트라이크인_경우_다음단계로_넘어가는_상태가_됩니다() {
        BaseballContext context = new BaseballContextFake(new CompareAnswerStatus(), List.of(1, 2, 3),
                List.of(1, 2, 3));
        var status = new CompareAnswerStatus();
        var next = status.next(context);

        assertThat(next).isInstanceOf(RequestContinueStatus.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:124", "123:456", "123:222", "123:167"}, delimiterString = ":")
    void 비교상태에서_모두_스트라이크가_아닌경우_사용자_입력상태가_됩니다(final String original, final String target) {

        BaseballContext context = new BaseballContextFake(
                new CompareAnswerStatus(),
                Arrays.stream(original.split("")).map(Integer::parseInt).collect(Collectors.toList()),
                Arrays.stream(target.split("")).map(Integer::parseInt).collect(Collectors.toList())
        );
        var status = new CompareAnswerStatus();
        var next = status.next(context);

        assertThat(next).isInstanceOf(UserInputStatus.class);
    }

}