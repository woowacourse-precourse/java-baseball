package baseball.utils;

import baseball.model.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StrikeBallUtilTest {

    @Test
    @DisplayName("Computer 와 User 숫자가 주어졌을 때 Strike와 Ball의 개수를 구할 수 있다")
    void testFindStrikeAndBall() throws Exception {
        //given
        String user1 = "123";
        List<Integer> computer1 = List.of(1, 2, 3);

        String user2 = "847";
        List<Integer> computer2 = List.of(8, 7, 4);

        String user3 = "847";
        List<Integer> computer3 = List.of(8, 7, 5);

        String user4 = "847";
        List<Integer> computer4 = List.of(8, 4, 9);

        String user5 = "847";
        List<Integer> computer5 = List.of(1, 2, 3);

        //when
        Ball result1 = StrikeBallUtil.findStrikeAndBall(user1, computer1); //3스트라이크
        Ball result2 = StrikeBallUtil.findStrikeAndBall(user2, computer2); //1스트라이크 2볼
        Ball result3 = StrikeBallUtil.findStrikeAndBall(user3, computer3); //1스트라이크 1볼
        Ball result4 = StrikeBallUtil.findStrikeAndBall(user4, computer4); //2스트라이크
        Ball result5 = StrikeBallUtil.findStrikeAndBall(user5, computer5); //낫싱

        //then
        assertThat(result1.getBall()).isEqualTo(0);
        assertThat(result1.getStrike()).isEqualTo(3);
        assertThat(result2.getBall()).isEqualTo(2);
        assertThat(result2.getStrike()).isEqualTo(1);
        assertThat(result3.getBall()).isEqualTo(1);
        assertThat(result3.getStrike()).isEqualTo(1);
        assertThat(result4.getBall()).isEqualTo(0);
        assertThat(result4.getStrike()).isEqualTo(2);
        assertThat(result5.getBall()).isEqualTo(0);
        assertThat(result5.getStrike()).isEqualTo(0);
    }

}