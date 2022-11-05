package baseball.engine;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BaseballEngineTest {

    private final BaseballEngine engine = new BaseballEngine();

    @Test
    void generateAnswer_함수로_3개의_값을_반환() {
        List<Integer> answer = engine.generateAnswer();

        assertThat(answer).hasSize(3);
    }

    @Test
    void generateAnswer_함수로_1과_9사이의_값을_반환() {
        List<Integer> answer = engine.generateAnswer();

        for (int i : answer) {
            assertThat(i)
                    .isPositive()
                    .isLessThan(10);
        }

    }

    @Test
    void generateAnswer_함수로_중복되지_않는_값을_반환() {
        List<Integer> answer = engine.generateAnswer();

        for (int i : answer) {
            long count = answer.stream()
                    .filter(j -> j == i)
                    .count();

            assertThat(count).isEqualTo(1);
        }

    }

    @Test
    void parseInput_함수로_유저_입력값_리스트로_변환() {
        List<Integer> result = engine.parseInput("123");

        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void isValidAnswerInput_함수로_서로_다른_숫자_3개_입력시_true_반환() {
        boolean result = engine.isValidAnswerInput("123");

        assertThat(result).isTrue();
    }


    @Test
    void isValidAnswerInput_함수_사용시_중복되는_값이_있다면_false_반환() {
        boolean threeDuplicated = engine.isValidAnswerInput("111");
        boolean twoDuplicated = engine.isValidAnswerInput("112");

        assertThat(threeDuplicated).isFalse();
        assertThat(twoDuplicated).isFalse();
    }

    @Test
    void isValidAnswerInput_함수_사용시_입력값_갯수가_3개가_아니면_false_반환() {
        boolean shortResult = engine.isValidAnswerInput("1");
        boolean longResult = engine.isValidAnswerInput("12345");

        assertThat(shortResult).isFalse();
        assertThat(longResult).isFalse();
    }

    @Test
    void isValidAnswerInput_함수_사용시_숫자가_아닌_입력값은_false_반환() {
        boolean spaceResult = engine.isValidAnswerInput(" 12");
        boolean mixedResult = engine.isValidAnswerInput("d14");
        boolean stringResult = engine.isValidAnswerInput("asd");

        assertThat(spaceResult).isFalse();
        assertThat(mixedResult).isFalse();
        assertThat(stringResult).isFalse();
    }

    @Test
    void isValidRetryInput_함수에_시작_입력시_true_반환() {
        String input = Integer.toString(PlayState.RUN.getState());
        boolean result = engine.isValidRetryInput(input);

        assertThat(result).isTrue();
    }

    @Test
    void isValidRetryInput_함수에_시작_종료_이외의_값_입력시_false_반환() {
        String input = Integer.toString(3);
        boolean result = engine.isValidRetryInput(input);

        assertThat(result).isFalse();
    }

    @Test
    void isValidRetryInput_함수에_길이_1_초과의_입력시_false_반환() {
        String input = Integer.toString(12);
        boolean result = engine.isValidRetryInput(input);

        assertThat(result).isFalse();
    }

    @Test
    void getBallCountIfPresentOrZero_함수로_볼_카운트_세기() {
        List<Integer> answerList = List.of(1, 2, 3);
        List<Integer> userInputList = List.of(3, 1, 2);
        int ballCount = engine.getBallCountIfPresentOrZero(answerList, userInputList);

        assertThat(ballCount).isEqualTo(3);
    }

    @Test
    void getStrikeCountIfPresentOrZero_함수로_스트라이크_카운트_세기() {
        List<Integer> answerList = List.of(1, 5, 3);
        List<Integer> userInputList = List.of(1, 2, 3);
        int strikeCount = engine.getStrikeCountIfPresentOrZero(answerList, userInputList);

        assertThat(strikeCount).isEqualTo(2);
    }
}