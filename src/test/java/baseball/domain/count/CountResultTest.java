package baseball.domain.count;

import baseball.domain.CountResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountResultTest {

    @Test
    void strike가_3개면_isThreeStrike는_true를_반환한다() {
        CountResult countResult = new CountResult(0, 3);
        assertThat(countResult.isThreeStrike()).isTrue();
    }

    @Test
    void strike가_3개가_아니면_isThreeStrike는_false를_반환한다() {
        CountResult countResult = new CountResult(0, 2);
        assertThat(countResult.isThreeStrike()).isFalse();
    }

    @Test
    void strike와_ball이_모두_0이면_낫싱을_반환한다() {
        CountResult countResult = new CountResult(0, 0);
        assertThat(countResult.createStringFormatOfCountResult()).isEqualTo("낫싱");
    }

    @Test
    void ball이_모두_3이면_3볼을_반환한다() {
        CountResult countResult = new CountResult(3, 0);
        assertThat(countResult.createStringFormatOfCountResult().trim()).isEqualTo("3볼");
    }

    @Test
    void strike가_모두_3이면_3스트라이크를_반환한다() {
        CountResult countResult = new CountResult(0, 3);
        assertThat(countResult.createStringFormatOfCountResult().trim()).isEqualTo("3스트라이크");
    }

    @Test
    void strike와_ball이_섞여있으면_n볼_m스트라이크를_반환한다() {
        CountResult countResult = new CountResult(1, 2);
        assertThat(countResult.createStringFormatOfCountResult().trim()).isEqualTo("1볼 2스트라이크");
    }
}