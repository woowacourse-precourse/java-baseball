package baseball.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GameServiceTest {
    @Test()
    public void 스트라이크의_개수를_계산한다() {
        int computerNumber = 234;
        int userNumber = 124;
        int strike = GameService.getStrikeNumber(userNumber, computerNumber);
        assertEquals(1, strike);
    }
}