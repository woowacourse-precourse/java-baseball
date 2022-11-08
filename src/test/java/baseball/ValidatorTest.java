package baseball;

import static baseball.constant.Finish.EXIT;
import static baseball.constant.Finish.RESTART;
import static baseball.constant.Finish.getFinishByCode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.validator.AnswerValidator;
import baseball.validator.FinishValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    AnswerValidator answerValidator;
    FinishValidator finishValidator;

    @BeforeEach
    public void beforeEach() {
        answerValidator = new AnswerValidator();
        finishValidator = new FinishValidator();
    }

    @Test
    void 답입력은_1부터_9로만_이루어져야함() {
        // given
        String input1 = "123";
        String input2 = "023";
        String input3 = "230";

        // when
        boolean result1 = answerValidator.checkValid(input1);

        // then
        assertThat(result1).isTrue();
        assertAnswerException(input2);
        assertAnswerException(input3);
    }

    @Test
    void 답입력은_세자리수여야함() {
        // given
        String input1 = "123";
        String input2 = "";
        String input3 = "1234";
        String input4 = "12";
        String input5 = "1 3";

        // when
        boolean result1 = answerValidator.checkValid(input1);

        // then
        assertThat(result1).isTrue();
        assertAnswerException(input2);
        assertAnswerException(input3);
        assertAnswerException(input4);
        assertAnswerException(input5);
    }

    @Test
    void 답입력은_서로_다른_수로만_이루어져야함() {
        String input1 = "123";
        String input2 = "111";
        String input3 = "112";
        String input4 = "211";

        // when
        boolean result1 = answerValidator.checkValid(input1);

        // then
        assertThat(result1).isTrue();
        assertAnswerException(input2);
        assertAnswerException(input3);
        assertAnswerException(input4);
    }

    @Test
    void 답입력은_숫자여야함() {
        // given
        String input1 = "123";
        String input2 = "a12";
        String input3 = "abc";
        String input4 = "1 0";

        // when
        boolean result1 = answerValidator.checkValid(input1);

        // then
        assertThat(result1).isTrue();
        assertAnswerException(input2);
        assertAnswerException(input3);
        assertAnswerException(input4);
    }

    @Test
    void 답입력은_양수여야함() {
        // given
        String input1 = "-12";
        String input2 = "0";
        String input3 = "000";
        String input4 = "-1-";

        // then
        assertAnswerException(input1);
        assertAnswerException(input2);
        assertAnswerException(input3);
        assertAnswerException(input4);
    }

    @Test
    void 재시작여부입력은_1혹은_2여야함() {
        // given
        String input1 = "1";
        String input2 = "2";
        String input3 = "3";
        String input4 = "12";
        String input5 = "0";
        String input6 = "01";

        assertThat(getFinishByCode(input1)).isEqualTo(RESTART);
        assertThat(getFinishByCode(input2)).isEqualTo(EXIT);
        assertFinishException(input3);
        assertFinishException(input4);
        assertFinishException(input5);
        assertFinishException(input6);
    }


    private void assertAnswerException(String input) {
        assertThatThrownBy(() -> answerValidator.checkValid(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void assertFinishException(String input) {
        assertThatThrownBy(() -> finishValidator.checkValid(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
