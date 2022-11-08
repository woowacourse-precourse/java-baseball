package baseball;

import java.util.List;

public class BaseballGame {

    private List<Integer> userThreeDifferentNumber;
    Computer computer = new Computer();
    User user = new User();

    public void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        do{
            computer.threeDifferntNumber = computer.getThreeDifferntNumber();
            user.ThreeDifferentNumber = user.getThreeDifferentNumber();

        }while(gameResult())
    }


}
