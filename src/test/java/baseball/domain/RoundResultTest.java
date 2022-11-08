package baseball.domain;

import domain.BaseballNumbers;
import domain.RoundResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RoundResultTest {
    @Test
    void WinIfStrikeCountIsSizeOfBaseballNumbers(){
        assertThat(RoundResult.of(0, BaseballNumbers.SIZE).isWin()).isEqualTo(true);
    }

    @Test
    void FailToWinIfStrikeCountIsNotSizeOfBaseballNumbers(){
        assertThat(RoundResult.of(1,2).isWin()).isEqualTo(false);
    }

    @Test
    void TestToStringIfBallAndStrike(){
        assertThat(RoundResult.of(1,2).toString()).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void TestToStringIfOnlyBall(){
        assertThat(RoundResult.of(1,0).toString()).isEqualTo("1볼");
    }

    @Test
    void TestToStringIfOnlyStrike(){
        assertThat(RoundResult.of(0,2).toString()).isEqualTo("2스트라이크");
    }

    @Test
    void TestToStringIfNothing(){
        assertThat(RoundResult.of(0,0).toString()).isEqualTo("낫싱");
    }
}
