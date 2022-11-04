package baseball;

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
    void makeAnsNumber() {
        int[] testArr = new int[3];
        testArr = answerNumber.getNumberArr();
        assertThat(testArr.length == 3);

        for(int i = 0; i<3; i++){
            assertThat(testArr[i]).isBetween(1,9);
        }
    }
}
