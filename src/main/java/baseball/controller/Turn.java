package baseball.controller;

import baseball.model.Target;
import baseball.model.TurnScore;
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

    static void countBalls(List<Integer> numberOfList) {
        List<Integer> targetNumberList = Target.get();
        int countSameValueInSameIndex = countSameValueInSameIndex(targetNumberList, numberOfList);
        int countValueContainTogether = countValueContainTogether(targetNumberList, numberOfList);
        int balls = countValueContainTogether - countSameValueInSameIndex;
        TurnScore.setBalls(balls);
    }

    static void countStrikes(List<Integer> numberOfList) {
        List<Integer> targetNumberList = Target.get();
        int strikes = countSameValueInSameIndex(targetNumberList, numberOfList);
        TurnScore.setStrikes(strikes);
    }
}
