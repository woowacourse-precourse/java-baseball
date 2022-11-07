package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {
    @Test
    @DisplayName("스트라이크")
    void 스트라이크() {
        Ball computer = new Ball(1, 9);
        Ball user = new Ball(1, 9);
        assertEquals(BallStatus.STRIKE, user.compareTo(computer));
    }

    @Test
    @DisplayName("볼")
    void 볼() {
        Ball computer = new Ball(1, 9);
        Ball user = new Ball(2, 9);
        assertEquals(BallStatus.BALL, user.compareTo(computer));
    }

    @Test
    @DisplayName("낫싱")
    void 낫싱() {
        Ball computer = new Ball(1, 8);
        Ball user = new Ball(2, 9);
        assertEquals(BallStatus.NOTHING, user.compareTo(computer));
    }
}