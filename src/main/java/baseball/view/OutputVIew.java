package baseball.view;

import static baseball.util.BallCode.*;

public class OutputVIew {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_WIN = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private static final String GAME_END = "게임 종료";

    public void startGame(){
        System.out.println(GAME_START);
    }

    public void endGame(){
        System.out.println(GAME_END);
    }
}
