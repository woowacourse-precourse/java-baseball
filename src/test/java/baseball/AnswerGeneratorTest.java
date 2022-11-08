package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Const.NUMBER_LENGTH;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnswerGeneratorTest {

    @Test
    @DisplayName("랜덤 숫자 갯수 테스트")
    void randomNumbersSizeTest() {
        AnswerGenerator answerGenerator = new AnswerGenerator();
        final int listLength= 3;

        final List<Integer> randomNumbers = answerGenerator.generateAnswer();

        assertThat(randomNumbers.size()).isEqualTo(listLength);
    }

    @Test
    @DisplayName("랜덤 숫자 범위 테스트")
    void randomNumbersRangeTest() {
        AnswerGenerator answerGenerator = new AnswerGenerator();
        final List<Integer> randomNumbers = answerGenerator.generateAnswer();

        assertThat(randomNumbers.stream().allMatch(v -> v >= 1 && v <= 9)).isTrue();
    }

    @Test
    @DisplayName("랜덤 숫자 중복 테스트")
    void randomNumbersNotDuplicationTest() {
        AnswerGenerator answerGenerator = new AnswerGenerator();
        Set<Integer> inputSet = new HashSet<>();
        final List<Integer> randomNumbers = answerGenerator.generateAnswer();

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            inputSet.add(randomNumbers.get(i));
        }

        assertThat(randomNumbers.size()).isEqualTo(randomNumbers.size());
    }
}