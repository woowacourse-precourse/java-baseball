package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballScoreTest {
    private BaseballScore baseballScore;

    @BeforeEach
    void setUp() {
        baseballScore = new BaseballScore();
    }

    @Test
    void 볼_한_개_증가_시_볼_갯수가_한_개_증가하는지_테스트() {
        baseballScore.increaseBall();
        assertThat(baseballScore.getBall()).isEqualTo(1);
    }

    @Test
    void 스트라이크_한_개_증가_시_스트라이크_갯수가_한_개_증가하는지_테스트() {
        baseballScore.increaseStrike();
        assertThat(baseballScore.getStrike()).isEqualTo(1);
    }
}