package baseball.domain.player;

import baseball.service.GameService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {
    @Test()
    public void 게임이_시작되면_1부터9까지_서로_다른_수로_이루어진_3자리_수를_생성한다() {
        Player computerPlayer = new ComputerPlayer();
        computerPlayer.getNumber();
        int number = computerPlayer.number;
        int lengthOfNumber = String.valueOf(number).length();
        assertEquals(3, lengthOfNumber);
    }
}