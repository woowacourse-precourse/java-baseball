package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class JudgeResultTest {

    @Test
    public void nothing(){
        // given
        JudgeResult judgeResult = new JudgeResult(0, 0);

        // when
        judgeResult.compareTwoNumbers(123, 456);

        // then
        assertThat(judgeResult.getBallCount()).isEqualTo(0);
        assertThat(judgeResult.getStrikeCount()).isEqualTo(0);
    }

    @Test
    public void oneBallOneStrike(){
        // given
        JudgeResult judgeResult = new JudgeResult(0, 0);

        // when
        judgeResult.compareTwoNumbers(123, 283);

        // then
        assertThat(judgeResult.getBallCount()).isEqualTo(1);
        assertThat(judgeResult.getStrikeCount()).isEqualTo(1);
    }

    @Test
    public void twoBallOneStrike() {
        // given
        JudgeResult judgeResult = new JudgeResult(0, 0);

        // when
        judgeResult.compareTwoNumbers(123, 321);

        // then
        assertThat(judgeResult.getBallCount()).isEqualTo(2);
        assertThat(judgeResult.getStrikeCount()).isEqualTo(1);
    }

    @Test
    public void threeBalls() {
        // given
        JudgeResult judgeResult = new JudgeResult(0, 0);

        // when
        judgeResult.compareTwoNumbers(123, 312);

        // then
        assertThat(judgeResult.getBallCount()).isEqualTo(3);
        assertThat(judgeResult.getStrikeCount()).isEqualTo(0);
    }

    @Test
    public void threeStrikes() {
        // given
        JudgeResult judgeResult = new JudgeResult(0, 0);

        // when
        judgeResult.compareTwoNumbers(123, 123);

        // then
        assertThat(judgeResult.getBallCount()).isEqualTo(0);
        assertThat(judgeResult.getStrikeCount()).isEqualTo(3);
    }
}