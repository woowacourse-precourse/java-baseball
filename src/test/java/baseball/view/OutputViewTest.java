package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Ball;
import baseball.domain.Result;
import baseball.domain.Strike;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    void roundOutput_매서드로_라운드_결과_문구를_반환() {
        // given
        Result result1 = new Result(new Ball(0), new Strike(0));
        Result result2 = new Result(new Ball(0), new Strike(1));
        Result result3 = new Result(new Ball(1), new Strike(0));
        Result result4 = new Result(new Ball(1), new Strike(1));
        Result result5 = new Result(new Ball(0), new Strike(3));

        // when
        String roundOutput1 = OutputView.roundOutput(result1);
        String roundOutput2 = OutputView.roundOutput(result2);
        String roundOutput3 = OutputView.roundOutput(result3);
        String roundOutput4 = OutputView.roundOutput(result4);
        String roundOutput5 = OutputView.roundOutput(result5);

        // then
        assertThat(roundOutput1).isEqualTo("낫싱");
        assertThat(roundOutput2).isEqualTo("1스트라이크");
        assertThat(roundOutput3).isEqualTo("1볼");
        assertThat(roundOutput4).isEqualTo("1볼 1스트라이크");
        assertThat(roundOutput5).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}