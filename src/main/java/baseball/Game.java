package baseball;

import java.util.List;
import java.util.Map;

public class Game {
    protected Game(){
        this.GameProcess();
    }

    protected void GameProcess(){
        while(true){
            System.out.println("숫자 야구 게임을 시작합니다.\n");
            List<Integer> answer = new Answer().getAnswer();
            new InGame(answer, false);
            Integer input = new UserTerminateInput().getUserTerminate();
            if(input.equals(2)){
                break;
            }
        }

    }
}