package baseball.domain.score;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ScoreTest {
    /**
     * - [ ]  스코어는 스트라이크와 볼에 대한 정보를 가집니다. - [ ]  볼 카운트를 추가할 수 있고 스트라이크 카운트를 추가할 수 있습니다. - [ ]  스코어는 결과를 요구할 경우 자신의 상태에
     * 따른 정보를 요구 받을 수 있습니다.
     */

    @Test
    void 스코어는_스트라이크와_볼에_대한_정보를_가지며_초기화를_통해_낫싱을_반환합니다() {
        var score = Score.generateZero();

        assertThat(score.result()).isEqualTo("낫싱");
    }

    @Test
    void 스코어는_스트라이크_하나를_추가할_수_있습니다() {
        var score = Score.generateZero()
                .strike();
        var actual = score.result();

        assertThat(actual).isEqualTo("1스트라이크");
    }

    @Test
    void 스코어는_볼_하나를_추가할_수_있습니다() {
        var score = Score.generateZero()
                .ball();

        var actual = score.result();
        assertThat(actual).isEqualTo("1볼");
    }

    @Test
    void 스코어는_볼_하나와_스트라이크_하나를_추가할_수_있습니다() {
        var score = Score.generateZero()
                .ball()
                .strike();

        var actual = score.result();
        assertThat(actual).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 스코어는_볼2개와_스트라이크_한개를_추가할_수_있습니다() {
        var score = Score.generateZero()
                .ball()
                .strike()
                .ball();

        var actual = score.result();
        assertThat(actual).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 스코어는_볼1개와_스트라이크_2개를_추가할_수_있습니다() {
        var score = Score.generateZero()
                .ball()
                .strike()
                .strike();

        var actual = score.result();
        assertThat(actual).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void 스코어는_볼3개_를_추가할_수있습니다() {
        var score = Score.generateZero()
                .ball()
                .ball()
                .ball();

        var actual = score.result();

        assertThat(actual).isEqualTo("3볼");
    }

    @Test
    void 스코어는_스트라이크_3개를_추가할_수_있습니다() {
        var score = Score.generateZero()
                .strike()
                .strike()
                .strike();

        var actual = score.result();
        assertThat(actual).isEqualTo("3스트라이크");
    }
}