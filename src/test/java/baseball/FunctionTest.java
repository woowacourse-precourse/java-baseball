package baseball;

import org.junit.jupiter.api.Test;

import java.util.*;

import static baseball.CompareNumber.compare;
import static baseball.Score.*;
import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class FunctionTest {
    @Test
    void 점수비교() {
        //given
        List<String> computerNumber = new ArrayList<>(asList("1", "2", "3"));
        List<String> userInput = new ArrayList<>(asList("3", "2", "5"));
        Map<Score, Integer> score = new HashMap<>();
        for (Score name : values()) {
            score.put(name, 0);
        }

        //when
        compare(computerNumber, userInput, score);

        //then
        assertThat(score).contains(entry(STRIKE, 1), entry(BALL, 1));
    }
}
