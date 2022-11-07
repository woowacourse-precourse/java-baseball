package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    @Test
    @DisplayName("3스트라이크")
    void 스트라이크_3() {
        Referee referee = new Referee(new Balls(List.of(1, 2, 3)), new Balls(List.of(1, 2, 3)));
        PlayResult playResult = referee.notifyResult();
        assertEquals(3, playResult.getStrike());
        assertEquals(0, playResult.getBall());
    }

    @Test
    @DisplayName("3볼")
    void 볼_3() {
        Referee referee = new Referee(new Balls(List.of(1, 2, 3)), new Balls(List.of(3, 1, 2)));
        PlayResult playResult = referee.notifyResult();
        assertEquals(0, playResult.getStrike());
        assertEquals(3, playResult.getBall());
    }

    @Test
    @DisplayName("낫싱")
    void 낫싱() {
        Referee referee = new Referee(new Balls(List.of(1, 2, 3)), new Balls(List.of(4, 5, 6)));
        PlayResult playResult = referee.notifyResult();
        assertEquals(0, playResult.getStrike());
        assertEquals(0, playResult.getBall());
    }
}