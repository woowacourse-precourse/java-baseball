package baseball.view;

import baseball.model.Computer;
import baseball.model.Player;

public class OutputView {


    public void printGameEnd(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public void printHint(String hint){
        System.out.println(hint);
    }
}
