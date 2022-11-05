package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AnswerNumberTest {

    @Test
    void split_배열의_요소와_중복된_값인_경우_0값을_반환() {
        AnswerNumber ans = new AnswerNumber();
        int[] input = {2,3,4};

        assertThat(ans.checkDuplication(input,3)).isEqualTo(0);
    }
}