package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import java.util.List;

class HintTest {

    Hint hint = new Hint();

    @Test
    public void 스트라이크_확인() throws Exception {
        //given
        List<Integer> computerNumber = List.of(1, 3, 5);
        int userNumber = 1;
        int index_true = 0; // correct index
        int index_false = 1; // incorrect index
        //when
        boolean strike_true = hint.isStrike(computerNumber, userNumber, index_true);
        boolean strike_false = hint.isStrike(computerNumber, userNumber, index_false);
        //then
        assertThat(strike_true).isTrue();
        assertThat(strike_false).isFalse();
    }

    @Test
    public void 볼_확인() throws Exception {
        //given
        List<Integer> computerNumber = List.of(1, 3, 5);
        int userNumber_true = 3;
        int userNumber_false = 2;
        //when
        boolean ball_true = hint.isBall(computerNumber, userNumber_true);
        boolean ball_false = hint.isBall(computerNumber, userNumber_false);
        //then
        assertThat(ball_true).isTrue();
        assertThat(ball_false).isFalse();
    }

}