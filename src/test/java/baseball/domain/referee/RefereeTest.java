package baseball.domain.referee;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.number.BaseballNumber;
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
class RefereeTest {
    private final GenerateAnswers generateAnswers = new GenerateAnswers();
    private Referee referee;

    @BeforeEach
    void setUp() {
        this.referee = new Referee();
    }

    @AfterEach
    void tearDown() {
        this.referee = null;
    }

    @Test
    void 심판은_참가자와_컴퓨터_두_값을_비교해서_결과를_반환합니다() {
        var answers = generateAnswers.generate(List.of(1, 2, 3), List.of(1, 2, 3));
        var score = referee.ruled(answers.get(0), answers.get(1));

        var actual = score.result();

        assertThat(actual).isEqualTo("3스트라이크");
    }

    @Test
    void _1스트라이크_1볼_경우() {
        var answers = generateAnswers.generate(List.of(1, 2, 3), List.of(1, 3, 4));
        var actual = referee.ruled(answers.get(0), answers.get(1)).result();

        assertThat(actual).isEqualTo("1볼 1스트라이크");
    }

    // 애초에 2스트라이크 1볼상황은 존재할 수 없네
    // 3개 중에서 2개 맞고 나머지는 스트라이크거나 낫싱이네

    // 1s23b
    // 12b3s
    // 13b2s
    @ParameterizedTest
    @CsvSource(value = {"123:132", "123:213", "123:321"}, delimiterString = ":")
    void _1스트라이크_2볼인경우(final String original, final String target) {
        var answers = this.generateAnswers.generate(original, target);
        var actual = this.referee.ruled(answers.get(0), answers.get(1)).result();
        assertThat(actual).isEqualTo("2볼 1스트라이크");

    }

    // 12s 23s 13s
    @ParameterizedTest
    @CsvSource(value = {"123:124", "367:167", "192:152"}, delimiterString = ":")
    void _2스트라이크_인경우(final String original, final String target) {
        var answers = this.generateAnswers.generate(original, target);
        var actual = this.referee.ruled(answers.get(0), answers.get(1)).result();
        assertThat(actual).isEqualTo("2스트라이크");
    }

    @ParameterizedTest
    @CsvSource(value = {"123:123", "234:234", "345:345", "456:456", "567:567", "678:678",
            "789:789"}, delimiterString = ":")
    void _3스트라이크_인경우(final String original, final String target) {
        var answers = this.generateAnswers.generate(original, target);
        var actual = this.referee.ruled(answers.get(0), answers.get(1)).result();
        assertThat(actual).isEqualTo("3스트라이크");
    }

    @ParameterizedTest
    @CsvSource(value = {"123:312", "124:412"}, delimiterString = ":")
    void _3볼(final String original, final String target) {
        var answers = this.generateAnswers.generate(original, target);
        var actual = this.referee.ruled(answers.get(0), answers.get(1)).result();
        assertThat(actual).isEqualTo("3볼");
    }

    @ParameterizedTest
    @CsvSource(value = {"123:111", "123:222", "123:333"}, delimiterString = ":")
    void 사용자가_한가지_번호로_밀_경우_얻어걸리는_값이_있을때_1스트라이크_2볼입니다(final String original, final String target) {
        var answers = this.generateAnswers.generate(original, target);
        var actual = this.referee.ruled(answers.get(0), answers.get(1)).result();
        assertThat(actual).isEqualTo("2볼 1스트라이크");
    }

    class GenerateAnswers {
        public List<List<BaseballNumber>> generate(List<Integer> numbers, List<Integer> numbers1) {
            return List.of(
                    this.convertNumberListToBaseballNumberList(numbers),
                    this.convertNumberListToBaseballNumberList(numbers1)
            );
        }

        public List<List<BaseballNumber>> generate(String numbers1, String numbers2) {
            return this.generate(
                    this.convertStringToNumberList(numbers1),
                    this.convertStringToNumberList(numbers2)
            );
        }

        private List<BaseballNumber> convertNumberListToBaseballNumberList(List<Integer> numbers) {
            return numbers.stream().map(BaseballNumber::new).collect(Collectors.toList());
        }

        private List<Integer> convertStringToNumberList(String input) {
            return Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
        }
    }
}