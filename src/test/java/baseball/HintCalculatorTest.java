package baseball;

import static baseball.constant.Rules.END_INCLUSIVE;
import static baseball.constant.Rules.NUMBER_LENGTH;
import static baseball.constant.Rules.START_INCLUSIVE;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.hint.Hint;
import baseball.hint.HintCalculator;
import baseball.hint.HintCalculatorImp;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class HintCalculatorTest {

    HintCalculator hintCalculator;

    @BeforeEach
    public void beforeEach() {
        hintCalculator = new HintCalculatorImp();
    }

    @Test
    void 모두_같은_수가_같은_자리에_있으면_3스트라이크() {
        // given
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 3);

        // when
        Hint hint = hintCalculator.getHint(answer, user);

        // then
        assertStrikeBall(hint, 3, 0);
    }

    @Test
    void n개의_같은_수가_같은_자리에_있으면_n스트라이크() {
        // given
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 0);

        // when
        Hint hint = hintCalculator.getHint(computer, user);

        // then
        assertStrikeBall(hint, 2, 0);
    }

    @Test
    void n개의_같은_수가_다른_자리에_있으면_n볼() {
        // given
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(4, 5, 1);

        // when
        Hint hint = hintCalculator.getHint(computer, user);

        // then
        assertStrikeBall(hint, 0, 1);
    }

    @Test
    void n개의_같은수가_같은자리에있고_m개의_같은수가_다른자리에있으면_n스트라이크_m볼() {
        // given
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(4, 2, 1);

        // when
        Hint hint = hintCalculator.getHint(computer, user);

        // then
        assertStrikeBall(hint, 1, 1);
    }


    @Test
    void 같은_수가_하나도없는경우_0스트라이크_0볼() {
        // given
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(4, 5, 6);

        // when
        Hint hint = hintCalculator.getHint(computer, user);

        // then
        assertStrikeBall(hint, 0, 0);
    }

    private void assertStrikeBall(Hint hint, int expectedStrike, int expectedBall) {
        assertThat(hint.getStrike()).isEqualTo(expectedStrike);
        assertThat(hint.getBall()).isEqualTo(expectedBall);
    }

    @RepeatedTest(10)
    void 스트라이크와_볼_개수의_합이_3을넘지못함() {
        List<Integer> computer = generateRandomNumber();
        List<Integer> user = generateRandomNumber();
        Hint hint = hintCalculator.getHint(computer, user);
        assertThat(hint.getStrike() + hint.getBall()).isLessThanOrEqualTo(NUMBER_LENGTH);
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> number = new ArrayList<>();
        while (number.size() < NUMBER_LENGTH) {
            int randomDigit = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!number.contains(randomDigit)) {
                number.add(randomDigit);
            }
        }
        return number;
    }
}
