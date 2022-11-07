package baseball.controller;

import baseball.type.ResultTurn;
import baseball.view.InputView;
import java.util.List;

public class Turn {
    static ResultTurn resultTurn;

    static void repeatToEnd() {
        while(checkCanRepeat()) {
            playOneTurn();
        }
    }

    static void playOneTurn() {
        String userNumberOfString = InputView.userNumber();
        List<Integer> userNumberOfList = convertNumberStringToList(userNumberOfString);
        compareWithTarget(userNumberOfList);
    }

    static boolean checkCanRepeat() {
        return resultTurn != ResultTurn.Out;
    }

    static void compareWithTarget(List<Integer> numberOfList) {
        countBalls(numberOfList);
        countStrikes(numberOfList);
    }
}
