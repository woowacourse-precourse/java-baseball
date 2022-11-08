package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgementTest {

    @Test
    void 같은수세기테스트() {
        final Judgement judgement = new Judgement();
        int count1 = judgement.correctCount(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        int count2 = judgement.correctCount(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 4));
        int count3 = judgement.correctCount(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 4));
        int count4 = judgement.correctCount(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4));

        assertThat(count1).isEqualTo(3);
        assertThat(count2).isEqualTo(2);
        assertThat(count3).isEqualTo(2);
        assertThat(count4).isEqualTo(2);
    }

    @Test
    void 특정자리_특정숫자_체크테스트() {
        final Judgement judgement = new Judgement();
        List<Integer> computer = Arrays.asList(1, 2, 3);

        assertThat(judgement.hasPlace(computer, 0, 1)).isTrue();
        assertThat(judgement.hasPlace(computer, 0, 2)).isFalse();
        assertThat(judgement.hasPlace(computer, 1, 2)).isTrue();
        assertThat(judgement.hasPlace(computer, 1, 3)).isFalse();
        assertThat(judgement.hasPlace(computer, 2, 3)).isTrue();
        assertThat(judgement.hasPlace(computer, 2, 4)).isFalse();
    }
}