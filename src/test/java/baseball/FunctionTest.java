package baseball;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static baseball.CompareNumber.compare;
import static baseball.Score.*;
import static baseball.Validation.hasOnlyNumber;
import static baseball.Validation.isValidLength;
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

    @Nested
    class ListLengthTest {
        @Test
        void 세_자리의_숫자인지_확인() {
            //given
            List<String> userInput = new ArrayList<>(asList("1", "2", "3"));
            int length = 3;

            //when
            boolean validLength = isValidLength(userInput, length);

            //then
            assertThat(validLength).isEqualTo(true);
        }

        @Test
        void 숫자의_길이가_3이_아니면_false_반환() {
            //given
            List<String> userInput = new ArrayList<>(asList("1", "2"));
            int length = 3;

            //when
            boolean validLength = isValidLength(userInput, length);

            //then
            assertThat(validLength).isEqualTo(false);
        }
    }

    @Nested
    class InputContentTest {
        @Test
        void 숫자만_존재하는지_확인() {
            //given
            List<String> userInput = new ArrayList<>(asList("1", "2", "3"));

            //when
            boolean existOnlyNumber = hasOnlyNumber(userInput);

            //then
            assertThat(existOnlyNumber).isEqualTo(true);
        }

        @Test
        void 숫자_이외의_다른_문자가_있으면_false_반환() {
            //given
            List<String> userInput = new ArrayList<>(asList("1", "2", "a"));

            //when
            boolean existOnlyNumber = hasOnlyNumber(userInput);

            //then
            assertThat(existOnlyNumber).isEqualTo(false);
        }
    }
}
