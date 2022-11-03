package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BallsTest {

    @Test
    @DisplayName("잘못된 입력")
    void 잘못된_입력() {
        assertThrows(IllegalArgumentException.class, () -> new Balls(Arrays.asList(1, 2, 3, 4)));
        assertThrows(IllegalArgumentException.class, () -> new Balls(Arrays.asList(1, 2)));
    }

    @Test
    @DisplayName("중복된 입력")
    void 중복된_입력() {
        assertThrows(IllegalArgumentException.class, () -> new Balls(Arrays.asList(1, 3, 3)));
    }

    @Test
    @DisplayName("3스트라이크")
    void threeStrike() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult playResult = computer.compareTo(new Balls(Arrays.asList(1, 2, 3)));
        assertEquals(3, playResult.getStrike());
        assertEquals(0, playResult.getBall());
    }

    @Test
    @DisplayName("1스트라이크 1볼")
    void oneStrike_oneBall() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult playResult = computer.compareTo(new Balls(Arrays.asList(1, 3, 4)));
        assertEquals(1, playResult.getStrike());
        assertEquals(1, playResult.getBall());
    }

    @Test
    @DisplayName("3볼")
    void threeBall() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult playResult = computer.compareTo(new Balls(Arrays.asList(3, 1, 2)));
        assertEquals(0, playResult.getStrike());
        assertEquals(3, playResult.getBall());
    }

    @Test
    @DisplayName("낫싱")
    void nothing() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult playResult = computer.compareTo(new Balls(Arrays.asList(4, 5, 6)));
        assertEquals(0, playResult.getStrike());
        assertEquals(0, playResult.getBall());
    }
}