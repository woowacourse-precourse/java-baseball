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

    static int countSameValueInSameIndex(List<Integer> targetNumberList, List<Integer> compareNumberList) {
        int count = 0;
        for (int indexOfList = 0; indexOfList < compareNumberList.size(); indexOfList++) {
            int targetNumber = targetNumberList.get(indexOfList);
            int compareNumber = compareNumberList.get(indexOfList);
            count += returnOneIfSameOrZero(targetNumber, compareNumber);
        }
        return count;
    }

    static int returnOneIfSameOrZero(int targetNumber, int compareNumber) {
        if (targetNumber == compareNumber) {
            return 1;
        }
        return 0;
    }

    static int countValueContainTogether(List<Integer> targetNumberList, List<Integer> compareNumberList) {
        int count = 0;
        for (int indexOfList = 0; indexOfList < compareNumberList.size(); indexOfList++) {
            int compareNumber = compareNumberList.get(indexOfList);
            count += returnOneIfListContainNumber(targetNumberList, compareNumber);
        }
        return count;
    }

    static int returnOneIfListContainNumber(List<Integer> targetNumberList, int compareNumber) {
        if (targetNumberList.contains(compareNumber)) {
            return 1;
        }
        return 0;
    }
}
