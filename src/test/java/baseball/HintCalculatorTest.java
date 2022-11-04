package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HintCalculatorTest {

    HintCalculator hintCalculator;

    @BeforeEach
    public void beforeEach() {
        hintCalculator = new HintCalculatorImp();
    }

    @Test
    public void 모두_같은_수가_같은_자리에_있으면_3스트라이크() {
        // given
        int answer = 123;
        int userInput = 123;

        // when
        Hint hint = hintCalculator.getHint(answer, userInput);

        // then
        assertThat(hint.getStrike()).isEqualTo(3);
        assertThat(hint.getBall()).isEqualTo(0);
    }

    @Test
    public void n개의_같은_수가_같은_자리에_있으면_n스트라이크() {
        // given
        int answer = 123;
        int userInput = 120;

        // when
        Hint hint = hintCalculator.getHint(answer, userInput);

        // then
        assertThat(hint.getStrike()).isEqualTo(2);
        assertThat(hint.getBall()).isEqualTo(0);
    }

    @Test
    public void n개의_같은_수가_다른_자리에_있으면_n볼() {
        // given
        int answer = 123;
        int userInput = 451;

        // when
        Hint hint = hintCalculator.getHint(answer, userInput);

        // then
        assertThat(hint.getStrike()).isEqualTo(0);
        assertThat(hint.getBall()).isEqualTo(1);
    }

    @Test
    public void n개의_같은수가_같은자리에있고_m개의_같은수가_다른자리에있으면_n스트라이크_m볼() {
        // given
        int answer = 123;
        int userInput = 421;

        // when
        Hint hint = hintCalculator.getHint(answer, userInput);

        // then
        assertThat(hint.getStrike()).isEqualTo(1);
        assertThat(hint.getBall()).isEqualTo(1);
    }


    @Test
    public void 같은_수가_하나도없는경우_0스트라이크_0볼() {
        // given
        int answer = 123;
        int userInput = 456;

        // when
        Hint hint = hintCalculator.getHint(answer, userInput);

        // then
        assertThat(hint.getStrike()).isEqualTo(0);
        assertThat(hint.getBall()).isEqualTo(0);
    }
}
