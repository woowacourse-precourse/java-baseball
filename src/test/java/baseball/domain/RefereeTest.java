package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    @Test
    @DisplayName("3스트라이크")
    void 스트라이크_3() {
        Referee referee = new Referee(List.of(1, 2, 3), List.of(1, 2, 3));
        assertEquals(3, referee.getStrike());
        assertEquals(0, referee.getBall());
    }

    @Test
    @DisplayName("3볼")
    void 볼_3() {
        Referee referee = new Referee(List.of(1, 2, 3), List.of(3, 1, 2));
        assertEquals(0, referee.getStrike());
        assertEquals(3, referee.getBall());
    }

    @Test
    @DisplayName("낫싱")
    void 낫싱() {
        Referee referee = new Referee(List.of(1, 2, 3), List.of(4, 5, 6));
        assertEquals(0, referee.getStrike());
        assertEquals(0, referee.getBall());
    }


}