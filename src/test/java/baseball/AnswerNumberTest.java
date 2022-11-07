package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerNumberTest {
    AnswerNumber answerNumber;
    @BeforeEach
    void beforeEach() {
        answerNumber = new AnswerNumber();
    }

    @Test
    void getAnswerNumber() {
        assertThat(answerNumber.getAnswerNumber()).size().isEqualTo(3);

    }

    @Test
    void checkOneToNine() {
        for(int i = 0; i < 3; i++) {
            assertThat(answerNumber.getAnswerNumber().get(i)).isBetween(1, 9);
        }
    }
}
