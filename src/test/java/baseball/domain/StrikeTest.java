package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StrikeTest {

    @Test
    @DisplayName("0으로 스트라이크 초기화 생성시 카운트는 0")
    void 스트라이크_0으로_생성시_카운트_0() {
        Strike strike = new Strike(0);
        assertThat(strike.getCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("addCount 실행 시 카운트 1 추가")
    void addCount_실행시_카운트_1_추가() {
        Strike strike = new Strike(0);
        strike.addCount();
        assertThat(strike.getCount()).isEqualTo(1);
    }

}
