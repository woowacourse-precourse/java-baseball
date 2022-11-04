package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class JudgementTest {
    @Test
    void _1개의_숫자가_동일하다() {
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(3, 4, 5);

        Judgement judgement = new Judgement();
        int count = judgement.countSameNumbers(computerNumbers, playerNumbers);

        assertThat(count).isEqualTo(1);
    }

    @Test
    void _2개의_숫자가_동일하다() {
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(3, 2, 5);

        Judgement judgement = new Judgement();
        int count = judgement.countSameNumbers(computerNumbers, playerNumbers);

        assertThat(count).isEqualTo(2);
    }

    @Test
    void _3개의_숫자가_동일하다() {
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(3, 2, 1);

        Judgement judgement = new Judgement();
        int count = judgement.countSameNumbers(computerNumbers, playerNumbers);

        assertThat(count).isEqualTo(3);
    }

    @Test
    void _0개의_숫자가_동일하다() {
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(4, 5, 6);

        Judgement judgement = new Judgement();
        int count = judgement.countSameNumbers(computerNumbers, playerNumbers);

        assertThat(count).isZero();
    }
}