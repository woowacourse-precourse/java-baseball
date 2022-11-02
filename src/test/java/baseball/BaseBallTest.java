package baseball;

import org.junit.jupiter.api.Test;

public class BaseBallTest {

    @Test
    void round_확인() {
        BaseBall baseBall = new BaseBall();
        baseBall.roundOfGame();
    }

    @Test
    void 게임_종료_여부_확인() {
        BaseBall baseBall = new BaseBall();
        baseBall.playGame();
    }
}
