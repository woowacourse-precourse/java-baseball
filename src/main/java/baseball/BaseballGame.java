package baseball;

import baseball.logic.Exception;
import baseball.logic.Generatenumber;
import baseball.logic.Inputnumber;

import java.util.List;

public class BaseballGame {
    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        Inputnumber input = new Inputnumber();
        Exception exception = new Exception();
        List<Integer> integers = exception.inputException(input.inputNum());
    }
}
