package baseball.domain.ingame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountResultTest {

    @DisplayName("strike가 3개면 isThreeStrike는 true를 반환한다")
    @Test
    void strikeTest1() {
        CountResult countResult = new CountResult(0, 3);
        assertThat(countResult.withThreeStrike()).isTrue();
    }
    
    @DisplayName("strike가 3개가 아니면 isThreeStrike는 false를 반환한다")
    @Test
    void strikeTest2() {
        CountResult countResult = new CountResult(0, 2);
        assertThat(countResult.withThreeStrike()).isFalse();
    }
    
    @DisplayName("strike와 ball이 모두 0이면 낫싱을 반환한다")
    @Test
    void nothingTest() {
        CountResult countResult = new CountResult(0, 0);
        assertThat(countResult.stringFormatOfCountResult())
                .isEqualTo("낫싱");
    }
    
    @DisplayName("ball이 모두 3이면 3볼을 반환한다")
    @Test
    void ThreeBallTest() {
        CountResult countResult = new CountResult(3, 0);
        assertThat(countResult.stringFormatOfCountResult().trim())
                .isEqualTo("3볼");
    }

    @DisplayName("strike가 모두 3이면 3스트라이크를 반환한다")
    @Test
    void ThreeStrikeTest() {
        CountResult countResult = new CountResult(0, 3);
        assertThat(countResult.stringFormatOfCountResult().trim())
                .isEqualTo("3스트라이크");
    }

    @DisplayName("strike가 2개 있고 ball이 1개 있으면 1볼 2스트라이크를 반환한다")
    @Test
    void oneBallTwoStrikeTest() {
        CountResult countResult = new CountResult(1, 2);
        assertThat(countResult.stringFormatOfCountResult().trim())
                .isEqualTo("1볼 2스트라이크");
    }
}