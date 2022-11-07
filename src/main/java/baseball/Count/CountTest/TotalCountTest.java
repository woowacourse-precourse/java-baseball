package baseball.Count.CountTest;

import baseball.Count.TotalCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TotalCountTest {


    TotalCount totalCount = new TotalCount();


    @Test
    @DisplayName("3볼 확인")
    void BallCount() {
        assertThat(0).isEqualTo(totalCount.printResult(3, 0));

    }

    @Test
    @DisplayName("3스트라이크 확인")
    void ThreeStrike() {
        assertThat(1).isEqualTo(totalCount.printResult(0, 3));
    }

    @Test
    @DisplayName("낫싱확인")
    void Nothing() {
        assertThat(0).isEqualTo(totalCount.printResult(0, 0));
    }

    @Test
    @DisplayName("스트라이크 수확인")
    void Strike() {
        assertThat(0).isEqualTo(totalCount.printResult(0, 1));
    }

}
