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

    @Test
    public void 힌트_정확성_확인_3스트라이크() throws Exception {
        //given
        List<Integer> computerNumber = List.of(1, 3, 5);
        List<Integer> userNumber = List.of(1, 3, 5);
        //when
        hint.giveHint(computerNumber, userNumber);
        //then
        assertThat(hint.getStrikeCount()).isEqualTo(3);
    }

    @Test
    public void 힌트_정확성_확인_3볼() throws Exception {
        //given
        List<Integer> computerNumber = List.of(1, 3, 5);
        List<Integer> userNumber = List.of(3, 5, 1);
        //when
        hint.giveHint(computerNumber, userNumber);
        //then
        assertThat(hint.getBallCount()).isEqualTo(3);
    }

    @Test
    public void 힌트_정확성_확인_1볼_1스트라이크() throws Exception {
        //given
        List<Integer> computerNumber = List.of(1, 3, 5);
        List<Integer> userNumber = List.of(1, 5, 8);
        //when
        hint.giveHint(computerNumber, userNumber);
        //then
        assertThat(hint.getBallCount()).isEqualTo(1);
        assertThat(hint.getStrikeCount()).isEqualTo(1);
    }

    @Test
    public void 힌트_정확성_확인_0볼_0스트라이크() throws Exception {
        //given
        List<Integer> computerNumber = List.of(1, 3, 5);
        List<Integer> userNumber = List.of(2, 4, 8);
        //when
        hint.giveHint(computerNumber, userNumber);
        //then
        assertThat(hint.getBallCount()).isEqualTo(0);
        assertThat(hint.getStrikeCount()).isEqualTo(0);
    }

    @Test
    public void 스트라이크가_3개인지_확인() throws Exception {
        //given
        List<Integer> computerNumber = List.of(1, 3, 5);
        List<Integer> userNumber_true = List.of(1, 3, 5);
        List<Integer> userNumber_false = List.of(1, 3, 5);
        //when
        hint.giveHint(computerNumber, userNumber_true);
        boolean threeStrike_true = hint.isThreeStrike();

        hint.initHint();

        hint.giveHint(computerNumber, userNumber_false);
        boolean threeStrike_false = hint.isThreeStrike();
        //then
        assertThat(threeStrike_true).isTrue();
        assertThat(threeStrike_false).isTrue();

    }

}