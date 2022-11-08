package baseball;

import java.util.List;

public class BaseballGame {

    private List<Integer> userThreeDifferentNumber;
    Computer computer = new Computer();
    User user = new User();
    Hint hint = new Hint();
    boolean result = false;

    public void gameStart(){
        do {
            computer.threeDifferntNumber = computer.getThreeDifferntNumber();
            user.ThreeDifferentNumber = user.getThreeDifferentNumber();
            result = hint.gameEnd(computer.threeDifferntNumber, user.ThreeDifferentNumber);
        } while (result);
    }
}
