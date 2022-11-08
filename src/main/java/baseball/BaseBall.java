package baseball;

import baseball.game.GameCycle;

public class BaseBall {
    private static final boolean CONTINUE = true;

    public void helloMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }


    public void play() {
        GameCycle gameCycle = new GameCycle();
        AfterGame afterGame = new AfterGame();
        helloMessage();
        while (CONTINUE) {
            gameCycle.play();
            if (!afterGame.play()) break;
        }
    }

}
