package baseball;

import baseball.Util.InputHandler;

public class GameManager {
    private static final String gameStartIndicator = "숫자 야구 게임을 시작합니다.";
    private static final String gameEndIndicator = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public GameManager(){
    }

    public GameState run(){ // initialize game state and run the game.
        GameState state = GameState.GAME_STATE;
        Player player = new Player();
        while(state == GameState.GAME_STATE){
            System.out.println(gameStartIndicator);
            state = player.game();
            if(state == GameState.END){
                System.out.println(gameEndIndicator);
                state = InputHandler.getRedoNumber();
            }
        }
        return state;
    }

}
