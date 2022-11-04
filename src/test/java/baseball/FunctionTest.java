package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FunctionTest {
    Application.AnswerNumber answerNumber;

    @BeforeEach
    void beforeEach() {
        answerNumber = new Application.AnswerNumber();
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
        assertThat(Application.isInput(str1)).isFalse();

        String str2 = "223";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.isInput(str2);
        });

        String str3 = "25T";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.isInput(str3);
        });

        String str4 = "2189";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Application.isInput(str4);
        });
    }
}
