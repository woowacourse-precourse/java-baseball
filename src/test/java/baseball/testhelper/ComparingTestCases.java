package baseball.testhelper;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.constants.ComparingResults;
import baseball.domain.QuestionNumberSetter;
import java.util.HashMap;
import java.util.Map;

public class ComparingTestCases {

    private QuestionNumberSetter questionNumberSetter;

    public ComparingTestCases(QuestionNumberSetter questionNumberSetter) {
        this.questionNumberSetter = questionNumberSetter;
    }

    public void oneBallTest() {
        Map<ComparingResults, Integer> comparingResult =
                questionNumberSetter.compareWithRandomNumbers(
                        ComparingResultExample.ONE_BALL.getNumbers());

        Map<ComparingResults, Integer> expected = new HashMap<>(Map.of(ComparingResults.BALL, 1));

        assertThat(comparingResult).isEqualTo(expected);
    }

    public void twoBallTest() {
        Map<ComparingResults, Integer> comparingResult =
                questionNumberSetter.compareWithRandomNumbers(
                        ComparingResultExample.TWO_BALL.getNumbers());

        Map<ComparingResults, Integer> expected = new HashMap<>(Map.of(ComparingResults.BALL, 2));

        assertThat(comparingResult).isEqualTo(expected);
    }

    public void threeBallTest() {
        Map<ComparingResults, Integer> comparingResult =
                questionNumberSetter.compareWithRandomNumbers(
                        ComparingResultExample.THREE_BALL.getNumbers());

        Map<ComparingResults, Integer> expected = new HashMap<>(Map.of(ComparingResults.BALL, 3));

        assertThat(comparingResult).isEqualTo(expected);
    }

    public void oneStrikeTest() {
        Map<ComparingResults, Integer> comparingResult =
                questionNumberSetter.compareWithRandomNumbers(
                        ComparingResultExample.ONE_STRIKE.getNumbers());

        Map<ComparingResults, Integer> expected = new HashMap<>(Map.of(ComparingResults.STRIKE, 1));

        assertThat(comparingResult).isEqualTo(expected);
    }

    public void twoStrikeTest() {
        Map<ComparingResults, Integer> comparingResult =
                questionNumberSetter.compareWithRandomNumbers(
                        ComparingResultExample.TWO_STRIKE.getNumbers());

        Map<ComparingResults, Integer> expected = new HashMap<>(Map.of(ComparingResults.STRIKE, 2));

        assertThat(comparingResult).isEqualTo(expected);
    }

    public void threeStrikeTest() {
        Map<ComparingResults, Integer> comparingResult =
                questionNumberSetter.compareWithRandomNumbers(
                        ComparingResultExample.THREE_STRIKE.getNumbers());

        Map<ComparingResults, Integer> expected = new HashMap<>(Map.of(ComparingResults.STRIKE, 3));

        assertThat(comparingResult).isEqualTo(expected);
    }

    public void oneBallOneStrikeTest() {
        Map<ComparingResults, Integer> comparingResult =
                questionNumberSetter.compareWithRandomNumbers(
                        ComparingResultExample.ONE_BALL_ONE_STRIKE.getNumbers());

        Map<ComparingResults, Integer> expected = new HashMap<>();
        expected.put(ComparingResults.BALL, 1);
        expected.put(ComparingResults.STRIKE, 1);

        assertThat(comparingResult).isEqualTo(expected);
    }

    public void twoBallOneStrikeTest() {
        Map<ComparingResults, Integer> comparingResult =
                questionNumberSetter.compareWithRandomNumbers(
                        ComparingResultExample.TWO_BALL_ONE_STRIKE.getNumbers());

        Map<ComparingResults, Integer> expected = new HashMap<>();
        expected.put(ComparingResults.BALL, 2);
        expected.put(ComparingResults.STRIKE, 1);

        assertThat(comparingResult).isEqualTo(expected);
    }

    public void nothingTest() {
        Map<ComparingResults, Integer> comparingResult =
                questionNumberSetter.compareWithRandomNumbers(
                        ComparingResultExample.NOTHING.getNumbers());

        Map<ComparingResults, Integer> expected = Map.of(ComparingResults.NOTHING, 1);

        assertThat(comparingResult).isEqualTo(expected);
    }
}
