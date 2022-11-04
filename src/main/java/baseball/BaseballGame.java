package baseball;

import baseball.logic.Inputnumber;

public class BaseballGame {
    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        Inputnumber input = new Inputnumber();
        input.inputNum();
    }

}
