package baseball.playing;

import baseball.GameController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.*;


class playGameTest {

    PlayGame playGame = new PlayGame();

    @ParameterizedTest
    @ValueSource(strings = {"3","Y"})
    public void 게임_재시작_예외처리(String replaying) throws Exception {
        assertThatThrownBy(()->playGame.checkInputErr(replaying))
                .isInstanceOf(IllegalArgumentException.class);
    }
}