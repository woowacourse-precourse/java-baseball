package baseball;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import view.GameView;

class GameViewTest {

    @Test
    void 게임_다시_시작_인풋_테스트_1() throws Exception {
        //given
        GameView view = new GameView();

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> view.isValidUser(0));
    }

    @Test
    void 게임_다시_시작_인풋_테스트_2() throws Exception {
        //given
        GameView view = new GameView();

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> view.isValidUser(3));
    }
}