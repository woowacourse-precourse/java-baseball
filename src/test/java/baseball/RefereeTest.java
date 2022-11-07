package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {
    @DisplayName("정답 저장 기능 테스트")
    @Test
    void setAnswer() {
        //given
        Referee referee = new Referee();
        int zeroIndexNum1 = 4;
        int firstIndexNum1 = 5;
        int secondIndexNum1 = 6;
        //when
        List<Integer> answer = List.of(zeroIndexNum1, firstIndexNum1, secondIndexNum1);
        referee.setAnswer(answer);
        //then
        assertThat(referee.answer.size()).isEqualTo(3);
        assertThat(referee.answer).contains(zeroIndexNum1, firstIndexNum1, secondIndexNum1);
        assertThat(referee.answer).isEqualTo(answer);
    }

    @DisplayName("볼 판단 기능 테스트")
    @Test
    void judgeBall() {
        //given
        Referee referee = new Referee();
        int zeroIndexNum = 4;
        int firstIndexNum = 5;
        int secondIndexNum = 6;
        referee.setAnswer(List.of(zeroIndexNum, firstIndexNum, secondIndexNum));
        //when
        int result = referee.judgeNumber(firstIndexNum, 0);
        //then
        assertThat(result).isEqualTo(referee.BALL);
    }

    @DisplayName("스트라이크 판단 기능 테스트")
    @Test
    void judgeStrike() {
        //given
        Referee referee = new Referee();
        int zeroIndexNum = 4;
        int firstIndexNum = 5;
        int secondIndexNum = 6;
        referee.setAnswer(List.of(zeroIndexNum, firstIndexNum, secondIndexNum));
        //when
        int result = referee.judgeNumber(zeroIndexNum, 0);
        //then
        assertThat(result).isEqualTo(referee.STRIKE);
    }

    @DisplayName("낫싱 판단 기능 테스트")
    @Test
    void judgeNumber() {
        //given
        Referee referee = new Referee();
        int zeroIndexNum = 4;
        int firstIndexNum = 5;
        int secondIndexNum = 6;
        int notExist = 8;
        referee.setAnswer(List.of(zeroIndexNum, firstIndexNum, secondIndexNum));
        //when
        int result = referee.judgeNumber(notExist, 0);
        //then
        assertThat(result).isEqualTo(referee.NOTHING);
    }

    @DisplayName("입력받은 숫자리스트 전체 판단 기능 테스트")
    @Test
    void judgeList() {
        //given
        Referee referee = new Referee();
        int zeroIndexNum = 4;
        int firstIndexNum = 5;
        int secondIndexNum = 6;
        referee.setAnswer(List.of(zeroIndexNum, firstIndexNum, secondIndexNum));
        //when
        List<Integer> result = referee.judgeList(List.of(zeroIndexNum, firstIndexNum, secondIndexNum));
        List<Integer> result2 = referee.judgeList(List.of(firstIndexNum, secondIndexNum, zeroIndexNum));
        List<Integer> result3 = referee.judgeList(List.of(secondIndexNum, firstIndexNum, zeroIndexNum));
        //then
        assertThat(result).isEqualTo(List.of(0, 3));
        assertThat(result2).isEqualTo(List.of(3, 0));
        assertThat(result3).isEqualTo(List.of(2, 1));
    }
}