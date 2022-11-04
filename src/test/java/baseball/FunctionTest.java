package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FunctionTest {
    AnswerNumber answerNumber;

    @BeforeEach
    void beforeEach() {
        answerNumber = new AnswerNumber();
    }

    @Test
    void makeAnsNumberTest() {
        int[] testArr = new int[3];
        testArr = answerNumber.getNumberArr();
        assertThat(testArr.length == 3);

        for(int i = 0; i<3; i++){
            assertThat(testArr[i]).isBetween(1,9);
        }
    }

    @Test
    void isInputTest() {
        String str1 = "243";
        assertThat(CheckInput.isInput(str1)).isFalse();

        String str2 = "223";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CheckInput.isInput(str2);
        });

        String str3 = "25T";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CheckInput.isInput(str3);
        });

        String str4 = "2189";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CheckInput.isInput(str4);
        });
    }

    @Test
    void ballCountTest() {
        int[] testArr = {1, 5 , 8};
        String str1 = "185";

        assertThat(BallCount.ballCount(testArr, str1)).isEqualTo(2);

        assertThat(BallCount.strikeCount(testArr, str1)).isEqualTo(1);
    }
}
