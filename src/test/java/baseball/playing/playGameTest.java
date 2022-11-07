package baseball.playing;

import baseball.GameController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.*;


class playGameTest {

    PlayGame playGame = new PlayGame();

    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    public void 게임_재시작_예외처리(int replayNum) throws Exception {
        assertThatThrownBy(()->playGame.checkInputErr(replayNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
}