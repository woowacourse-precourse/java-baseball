package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgementTest {
    private static final OffenseNumberGenerator offenseNumberGenerator = OffenseNumberGenerator.getInstance();
    private List<Integer> defenseNumbers;
    private Judgement judgement;

    @BeforeEach
    void init() {
        defenseNumbers = List.of(1,2,3);
        judgement = Judgement.from(defenseNumbers);
    }

    @Test
    void 공격_성공의_경우를_확인() {
        List<Integer> offenseNumbers = offenseNumberGenerator.generateOffenseNumbers("123");

        boolean isFailureOffense = judgement.isFailureOffense(offenseNumbers);

        assertThat(isFailureOffense).isFalse();
    }

    @Test
    void 공격_실패의_경우를_확인() {
        List<Integer> offenseNumbers = offenseNumberGenerator.generateOffenseNumbers("124");
        boolean isFailureOffense = judgement.isFailureOffense(offenseNumbers);

        assertThat(isFailureOffense).isTrue();
    }

    @Test
    void 스트라이크0개_볼0개_경우_테스트() {
        List<Integer> offenseNumbers = offenseNumberGenerator.generateOffenseNumbers("456");
        int ballCount = judgement.countBall(offenseNumbers);
        int strikeCount = judgement.countStrike(offenseNumbers);

        assertThat(ballCount).isEqualTo(0);
        assertThat(strikeCount).isEqualTo(0);
    }

    @Test
    void 볼의_개수가_0개_스트라이크개수가_1개인_경우_테스트() {
        List<Integer> offenseNumbers = offenseNumberGenerator.generateOffenseNumbers("563");
        int ballCount = judgement.countBall(offenseNumbers);
        int strikeCount = judgement.countStrike(offenseNumbers);

        assertThat(ballCount).isEqualTo(0);
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void 볼의_개수가_0개_스트라이크개수가_2개인_경우_테스트() {
        List<Integer> offenseNumbers = offenseNumberGenerator.generateOffenseNumbers("163");
        int ballCount = judgement.countBall(offenseNumbers);
        int strikeCount = judgement.countStrike(offenseNumbers);

        assertThat(ballCount).isEqualTo(0);
        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    void 볼의_개수가_0개_스트라이크개수가_3개인_경우_테스트() {
        List<Integer> offenseNumbers = offenseNumberGenerator.generateOffenseNumbers("123");
        int ballCount = judgement.countBall(offenseNumbers);
        int strikeCount = judgement.countStrike(offenseNumbers);

        assertThat(ballCount).isEqualTo(0);
        assertThat(strikeCount).isEqualTo(3);
    }

    @Test
    void 볼의_개수가_1개_스트라이크개수가_0개인_경우_테스트() {
        List<Integer> offenseNumbers = offenseNumberGenerator.generateOffenseNumbers("561");
        int ballCount = judgement.countBall(offenseNumbers);
        int strikeCount = judgement.countStrike(offenseNumbers);

        assertThat(ballCount).isEqualTo(1);
        assertThat(strikeCount).isEqualTo(0);
    }

    @Test
    void 볼의_개수가_1개_스트라이크개수가_1개인_경우_테스트() {
        List<Integer> offenseNumbers = offenseNumberGenerator.generateOffenseNumbers("134");
        int ballCount = judgement.countBall(offenseNumbers);
        int strikeCount = judgement.countStrike(offenseNumbers);

        assertThat(ballCount).isEqualTo(1);
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void 볼의_개수가_2개_스트라이크개수가_0개인_경우_테스트() {
        List<Integer> offenseNumbers = offenseNumberGenerator.generateOffenseNumbers("214");
        int ballCount = judgement.countBall(offenseNumbers);
        int strikeCount = judgement.countStrike(offenseNumbers);

        assertThat(ballCount).isEqualTo(2);
        assertThat(strikeCount).isEqualTo(0);
    }

    @Test
    void 볼의_개수가_2개_스트라이크개수가_1개인_경우_테스트() {
        List<Integer> offenseNumbers = offenseNumberGenerator.generateOffenseNumbers("213");
        int ballCount = judgement.countBall(offenseNumbers);
        int strikeCount = judgement.countStrike(offenseNumbers);

        assertThat(ballCount).isEqualTo(2);
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void 볼의_개수가_3개_스트라이크개수가_0개인_경우_테스트() {
        List<Integer> offenseNumbers = offenseNumberGenerator.generateOffenseNumbers("312");
        int ballCount = judgement.countBall(offenseNumbers);
        int strikeCount = judgement.countStrike(offenseNumbers);

        assertThat(ballCount).isEqualTo(3);
        assertThat(strikeCount).isEqualTo(0);
    }
}