package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.hint.Hint;
import baseball.input.InputController;
import baseball.input.InputControllerImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputControllerTest {

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
    void 답입력은_세자리수여야함() {
        // given
        String userInput1 = "123";
        String userInput2 = "";
        String userInput3 = "1234";
        String userInput4 = "12";
        String userInput5 = "1 3";

        // when
        boolean result1 = inputController.checkValidAnswer(userInput1);
        boolean result2 = inputController.checkValidAnswer(userInput2);
        boolean result3 = inputController.checkValidAnswer(userInput3);
        boolean result4 = inputController.checkValidAnswer(userInput4);
        boolean result5 = inputController.checkValidAnswer(userInput5);

        // then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
        assertThat(result5).isFalse();
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

    @Test
    void 힌트가_0볼_0스트라이크인경우_낫싱() {
        Hint hint = Hint.builder().strike(0).ball(0).build();
        assertHint(hint, "낫싱");
    }

    @Test
    void 힌트가_0볼_n스트라이크인경우_n스트라이크() {
        Hint hint1 = Hint.builder().strike(2).build();
        Hint hint2 = Hint.builder().strike(2).build();

        assertHint(hint1, "2스트라이크");
        assertHint(hint2, "2스트라이크");
    }

    @Test
    void 힌트가_n볼_0스트라이크인경우_n볼() {
        Hint hint1 = Hint.builder().ball(2).build();
        Hint hint2 = Hint.builder().ball(3).build();

        assertHint(hint1, "2볼");
        assertHint(hint2, "3볼");
    }

    @Test
    void 힌트가_n볼_m스트라이크인경우_n볼_m스트라이크() {
        Hint hint1 = Hint.builder().strike(1).ball(1).build();
        Hint hint2 = Hint.builder().strike(1).ball(2).build();

        assertHint(hint1, "1볼 1스트라이크");
        assertHint(hint2, "2볼 1스트라이크");
    }

    private void assertHint(Hint hint, String expectedMessage) {
        assertThat(inputController.convertHintToString(hint)).isEqualTo(expectedMessage);
    }
}
