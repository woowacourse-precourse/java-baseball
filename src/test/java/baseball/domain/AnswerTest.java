package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.utils.AnswerGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AnswerTest {
    @Test
    void 올바른_인덱스를_반환() {
        //given
        List<Integer> tempNums = AnswerGenerator.generateAnswer();
        Answer testAnswer = new Answer(tempNums);

        //when
        int tempNum = tempNums.get(0);
        int result = testAnswer.getIndex(tempNum);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 올바른_포함여부를_반환() {
        //given
        List<Integer> tempNums = AnswerGenerator.generateAnswer();
        Answer testAnswer = new Answer(tempNums);

        //when
        int tempNum = tempNums.get(0);
        boolean result = testAnswer.isContain(tempNum);

        //then
        assertThat(result).isEqualTo(true);
    }
}
