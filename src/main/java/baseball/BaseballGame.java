package baseball;

import java.util.List;

public class BaseballGame {

    private List<Integer> userThreeDifferentNumber;
    Computer computer;

    public void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        do{
            computer = new Computer();

        }while(gameResult())
    }


}
