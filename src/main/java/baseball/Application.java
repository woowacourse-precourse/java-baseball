package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        while(true){
            GameManager gameManager = new GameManager();
            StateEnum GAME_STATE = gameManager.run();
            if(GAME_STATE != StateEnum.REDO)
                return;
        }
    }
}
