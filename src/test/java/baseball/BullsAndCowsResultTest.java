package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BullsAndCowsResultTest {

    BullsAndCowsResult bullsAndCowsResult = new BullsAndCowsResult();

    @Test
    void 게임_결과_객체_초기화() {
        bullsAndCowsResult.init();

        assertThat(bullsAndCowsResult.getBallCount()).isEqualTo(0);
        assertThat(bullsAndCowsResult.getStrikeCount()).isEqualTo(0);
    }

    @Test
    void 볼_스트라이크_갯수_추가_테스트() {
        bullsAndCowsResult.init();
        bullsAndCowsResult.addCount(-1, 1);
        assertThat(bullsAndCowsResult.getBallCount()).isEqualTo(0);
        assertThat(bullsAndCowsResult.getStrikeCount()).isEqualTo(0);

        bullsAndCowsResult.init();
        bullsAndCowsResult.addCount(1, 1);
        assertThat(bullsAndCowsResult.getBallCount()).isEqualTo(0);
        assertThat(bullsAndCowsResult.getStrikeCount()).isEqualTo(1);

        bullsAndCowsResult.init();
        bullsAndCowsResult.addCount(1, 21);
        assertThat(bullsAndCowsResult.getBallCount()).isEqualTo(1);
        assertThat(bullsAndCowsResult.getStrikeCount()).isEqualTo(0);
    }
}