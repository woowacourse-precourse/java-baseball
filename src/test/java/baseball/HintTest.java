package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import java.util.List;

class HintTest {

    Hint hint = new Hint();
    List<Integer> computerNumber = List.of(1, 3, 5);
    
    @Test
    public void 스트라이크_확인() throws Exception {
        //given
        int userNumber = 1;
        int trueIndex = 0; // correct index
        int falseIndex = 1; // incorrect index
        //when
        boolean strike_true = hint.isStrike(computerNumber, userNumber, trueIndex);
        boolean strike_false = hint.isStrike(computerNumber, userNumber, falseIndex);
        //then
        assertThat(strike_true).isTrue();
        assertThat(strike_false).isFalse();
    }

    @Test
    public void 볼_확인() throws Exception {
        //given
        int trueUserNumber = 3;
        int falseUserNumber = 2;
        //when
        boolean ball_true = hint.isBall(computerNumber, trueUserNumber);
        boolean ball_false = hint.isBall(computerNumber, falseUserNumber);
        //then
        assertThat(ball_true).isTrue();
        assertThat(ball_false).isFalse();
    }

    @Test
    public void 힌트_정확성_확인_3스트라이크() throws Exception {
        //given
        List<Integer> userNumber = List.of(1, 3, 5);
        //when
        hint.score(computerNumber, userNumber);
        //then
        assertThat(hint.getStrikeCount()).isEqualTo(3);
    }

    @Test
    public void 힌트_정확성_확인_3볼() throws Exception {
        //given
        List<Integer> userNumber = List.of(3, 5, 1);
        //when
        hint.score(computerNumber, userNumber);
        //then
        assertThat(hint.getBallCount()).isEqualTo(3);
    }

    @Test
    public void 힌트_정확성_확인_1볼_1스트라이크() throws Exception {
        //given
        List<Integer> userNumber = List.of(1, 5, 8);
        //when
        hint.score(computerNumber, userNumber);
        //then
        assertThat(hint.getBallCount()).isEqualTo(1);
        assertThat(hint.getStrikeCount()).isEqualTo(1);
    }

    @Test
    public void 힌트_정확성_확인_0볼_0스트라이크() throws Exception {
        //given
        List<Integer> userNumber = List.of(2, 4, 8);
        //when
        hint.score(computerNumber, userNumber);
        //then
        assertThat(hint.getBallCount()).isEqualTo(0);
        assertThat(hint.getStrikeCount()).isEqualTo(0);
    }

    @Test
    public void 스트라이크가_3개인지_확인() throws Exception {
        //given
        List<Integer> trueUserNumber = List.of(1, 3, 5);
        List<Integer> falseUserNumber = List.of(1, 3, 5);
        //when
        hint.score(computerNumber, trueUserNumber);
        boolean threeStrike_true = hint.isAllStrike();

        hint.init();

        hint.score(computerNumber, falseUserNumber);
        boolean threeStrike_false = hint.isAllStrike();
        //then
        assertThat(threeStrike_true).isTrue();
        assertThat(threeStrike_false).isTrue();

    }

    @Test
    public void 출력_확인_1볼_1스트라이크_일때() throws Exception {
        //given
        List<Integer> userNumber = List.of(1, 5, 8);
        hint.score(computerNumber, userNumber);
        //when
        String printHint = hint.toString();
        //then
        assertThat(printHint).isEqualTo("1볼 1스트라이크");
    }

    @Test
    public void 출력_확인_낫싱_일때() throws Exception {
        //given
        List<Integer> userNumber = List.of(2, 4, 6);
        hint.score(computerNumber, userNumber);
        //when
        String printHint = hint.toString();
        //then
        assertThat(printHint).isEqualTo("낫싱");
    }

}