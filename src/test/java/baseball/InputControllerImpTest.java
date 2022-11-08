package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputControllerImpTest {

    InputController inputController;

    @BeforeEach
    public void beforeEach() {
        inputController = new InputControllerImp();
    }

    @Test
    void 답입력은_1부터_9로만_이루어져야함() {
        // given
        String userInput1 = "123";
        String userInput2 = "023";
        String userInput3 = "230";

        // when
        boolean result1 = inputController.checkValidAnswer(userInput1);
        boolean result2 = inputController.checkValidAnswer(userInput2);
        boolean result3 = inputController.checkValidAnswer(userInput3);

        // then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
    }

    @Test
    void 답입력은_세자리여야함() {
        // given
        String userInput1 = "123";
        String userInput2 = "";
        String userInput3 = "1234";
        String userInput4 = "12";

        // when
        boolean result1 = inputController.checkValidAnswer(userInput1);
        boolean result2 = inputController.checkValidAnswer(userInput2);
        boolean result3 = inputController.checkValidAnswer(userInput3);
        boolean result4 = inputController.checkValidAnswer(userInput4);

        // then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
    }

    @Test
    void 답입력은_서로_다른_수로만_이루어져야함() {
        String userInput1 = "123";
        String userInput2 = "111";
        String userInput3 = "112";
        String userInput4 = "211";

        // when
        boolean result1 = inputController.checkValidAnswer(userInput1);
        boolean result2 = inputController.checkValidAnswer(userInput2);
        boolean result3 = inputController.checkValidAnswer(userInput3);
        boolean result4 = inputController.checkValidAnswer(userInput4);

        // then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
    }

    @Test
    void 답입력은_숫자여야함() {
        // given
        String userInput1 = "123";
        String userInput2 = "a12";
        String userInput3 = "abc";
        String userInput4 = "1 0";

        // when
        boolean result1 = inputController.checkValidAnswer(userInput1);
        boolean result2 = inputController.checkValidAnswer(userInput2);
        boolean result3 = inputController.checkValidAnswer(userInput3);
        boolean result4 = inputController.checkValidAnswer(userInput4);

        // then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
    }

    @Test
    void 답입력은_양수여야함() {
        // given
        String userInput1 = "-12";
        String userInput2 = "0";
        String userInput3 = "000";
        String userInput4 = "-1-";

        // when
        boolean result1 = inputController.checkValidAnswer(userInput1);
        boolean result2 = inputController.checkValidAnswer(userInput2);
        boolean result3 = inputController.checkValidAnswer(userInput3);
        boolean result4 = inputController.checkValidAnswer(userInput4);

        // then
        assertThat(result1).isFalse();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
    }
}
