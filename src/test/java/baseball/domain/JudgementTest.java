package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JudgementTest {
    private final List<Integer> computerNumbers = List.of(1, 2, 3);
    private Judgement judgement;

    @BeforeEach
    void setUp() {
        judgement = new Judgement();
    }

    @Test
    void _1개의_숫자가_동일하다() {
        int count = judgement.countSameNumbers(computerNumbers, List.of(3, 4, 5));
        assertThat(count).isEqualTo(1);
    }

    @Test
    void _2개의_숫자가_동일하다() {
        int count = judgement.countSameNumbers(computerNumbers, List.of(3, 2, 5));
        assertThat(count).isEqualTo(2);
    }

    @Test
    void _3개의_숫자가_동일하다() {
        int count = judgement.countSameNumbers(computerNumbers, List.of(3, 2, 1));
        assertThat(count).isEqualTo(3);
    }

    @Test
    void _0개의_숫자가_동일하다() {
        int count = judgement.countSameNumbers(computerNumbers, List.of(4, 5, 6));
        assertThat(count).isZero();
    }
}