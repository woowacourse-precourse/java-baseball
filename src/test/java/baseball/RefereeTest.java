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

    @Test
    void judgeNumber() {
        int zeroIndexNum = 4;
        int firstIndexNum = 5;
        int secondIndexNum = 6;
        int notExist = 8;
        referee.setAnswer(List.of(zeroIndexNum, firstIndexNum, secondIndexNum));

        int result1 = referee.judgeNumber(zeroIndexNum, 0);
        int result2 = referee.judgeNumber(firstIndexNum, 0);
        int result3 = referee.judgeNumber(notExist, 0);

        assertThat(result1).isEqualTo(referee.STRIKE);
        assertThat(result2).isEqualTo(referee.BALL);
        assertThat(result3).isEqualTo(referee.NOTHING);
    }

    @Test
    void judgeList() {
        int zeroIndexNum = 4;
        int firstIndexNum = 5;
        int secondIndexNum = 6;
        referee.setAnswer(List.of(zeroIndexNum, firstIndexNum, secondIndexNum));

        List<Integer> result = referee.judgeList(List.of(zeroIndexNum, firstIndexNum, secondIndexNum));
        List<Integer> result2 = referee.judgeList(List.of(firstIndexNum, secondIndexNum, zeroIndexNum));
        List<Integer> result3 = referee.judgeList(List.of(secondIndexNum, firstIndexNum, zeroIndexNum));

        assertThat(result).isEqualTo(List.of(0, 3));
        assertThat(result2).isEqualTo(List.of(3, 0));
        assertThat(result3).isEqualTo(List.of(2, 1));
    }
}