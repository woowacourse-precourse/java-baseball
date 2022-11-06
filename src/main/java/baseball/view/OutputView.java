package baseball.view;

import baseball.model.Computer;
import baseball.model.Player;

public class OutputView {

    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printGameEnd(){
        System.out.println(END_MESSAGE);
    }
    public void printHint(String hint){
        System.out.println(hint);
    }
}
