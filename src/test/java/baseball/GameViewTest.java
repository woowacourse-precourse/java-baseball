package baseball;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import view.GameView;

class GameViewTest {

    private static GameView gameView;

    @BeforeAll // (테스트 콜한때 한번 출력)
    static void initAll() {
        gameView = new GameView();
    }

    @Test
    void 게임_다시_시작_인풋_테스트_1() throws Exception {
        //given
        GameView view = new GameView();

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> gameView.isValidUser(0));
    }

    void 게임_다시_시작_인풋_테스트_2() throws Exception {
        //given
        GameView view = new GameView();

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> gameView.isValidUser(3));
    }
}