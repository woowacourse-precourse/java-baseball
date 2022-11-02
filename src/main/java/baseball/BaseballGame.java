package baseball;

import java.util.List;
import java.util.ArrayList;

public class BaseballGame {

    private Computer computer;
    private User user;

    private BaseballGame(){
        computer = new Computer();
        user = new User();
    }

    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다 ");
        computer.pickRandomNumbersFrom1To9();

        user.pickNumbers();
    }
}
