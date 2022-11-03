package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class RefereeTest {
    Referee referee = new Referee();

    @Test
    void setAnswer() {
        int zeroIndexNum1 = 4;
        int firstIndexNum1 = 5;
        int secondIndexNum1 = 6;
        int zeroIndexNum2 = 7;
        int firstIndexNum2 = 1;
        int secondIndexNum2 = 4;

        referee.setAnswer(List.of(zeroIndexNum1, firstIndexNum1, secondIndexNum1));
        assertThat(referee.answer).contains(zeroIndexNum1, firstIndexNum1, secondIndexNum1);
        referee.setAnswer(List.of(zeroIndexNum2, firstIndexNum2, secondIndexNum2));
        assertThat(referee.answer).contains(zeroIndexNum2, firstIndexNum2, secondIndexNum2);
    }
}