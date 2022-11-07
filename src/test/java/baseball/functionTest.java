package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class functionTest {
    @Test
    void 올바른_형식의_답을_만들었는지_확인() {
        List<Integer> allowedInteger = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> answer = Application.createAnswer();
        Set<Integer> answerSet = new HashSet<>(answer);

        for (Integer eachAnswerNumber : answerSet) {
            if (!allowedInteger.contains(eachAnswerNumber)) {
                throw new IllegalArgumentException("0~9 안의 숫자가 아님");
            }
        }

        assertThat(answer.size()).isEqualTo(answerSet.size());
        assertThat(answer.size()).isEqualTo(3);

    }

    @Test
    void 인풋_발리데이션_로직_체크() {
        //given
        List<Integer> correctInput = List.of(1, 2, 3);
        List<Integer> duplciateinput = List.of(1, 2, 2);
        List<Integer> outOfRangeInput = List.of(1, 2, 10);
        List<Integer> negativeInput = List.of(1, 2, -5);

        //then
        assertThat(Application.validateInput(correctInput)).isEqualTo(true);
        assertThatThrownBy(() -> Application.validateInput(duplciateinput)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.validateInput(outOfRangeInput)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.validateInput(negativeInput)).isInstanceOf(IllegalArgumentException.class);


    }
}
