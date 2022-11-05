package baseball;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
        // 입력을 담는다.
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when

        // then
    }

    void 게임_다시_시작_인풋_테스트_2() throws Exception {
        //given
        GameView view = new GameView();
        // 입력을 담는다.
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when

        // then
    }
}