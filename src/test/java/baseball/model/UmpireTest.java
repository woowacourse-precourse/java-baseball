package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UmpireTest {
    @DisplayName("숫자가 하나도 맞지 않으면 nothing")
    @Test
    public void nothing() {
        Umpire umpire = new Umpire(GameNumber.from("123"));
        GameResult gameResult = umpire.decision(GameNumber.from("456"));

        assertThat(gameResult.isNothing()).isTrue();
        assertThat(gameResult.getBall()).isEqualTo(0);
        assertThat(gameResult.getStrike()).isEqualTo(0);
    }
    
    @DisplayName("숫자가 전부 일치하는 경우 3스트라이크 정답")
    @Test
    public void allStrike() {
        Umpire umpire = new Umpire(GameNumber.from("123"));
        GameResult gameResult = umpire.decision(GameNumber.from("123"));

        assertThat(gameResult.isAllStrike()).isTrue();
        assertThat(gameResult.getStrike()).isEqualTo(3);
    }
}