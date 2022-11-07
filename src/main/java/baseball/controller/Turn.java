package baseball.controller;

import baseball.model.Target;
import baseball.model.TurnScore;
import baseball.type.ResultTurn;
import baseball.view.InputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Turn {
    private ResultTurn resultTurn;
    private Target target;
    private TurnScore turnScore = new TurnScore();

    Turn (Target target) {
        this.resultTurn = ResultTurn.Nothing;
        this.target = target;
    }

    Turn (ResultTurn resultTurn, Target target) {
        this.resultTurn = resultTurn;
        this.target = target;
    }

    void repeatToEnd() {
        while(checkCanRepeat()) {
            playOneTurn();
        }
    }

    void playOneTurn() {
        String userNumberOfString = InputView.userNumber();
        List<Integer> userNumberOfList = convertNumberStringToList(userNumberOfString);
        compareWithTarget(userNumberOfList);
        setTurnResult();
        printResultOfThisTurn();
    }

    boolean checkCanRepeat() {
        return this.resultTurn != ResultTurn.Out;
    }

    void compareWithTarget(List<Integer> numberOfList) {
        countBalls(numberOfList);
        countStrikes(numberOfList);
    }

    void countBalls(List<Integer> numberOfList) {
        List<Integer> targetNumberList = target.get();
        int countSameValueInSameIndex = countSameValueInSameIndex(targetNumberList, numberOfList);
        int countValueContainTogether = countValueContainTogether(targetNumberList, numberOfList);
        int balls = countValueContainTogether - countSameValueInSameIndex;
        this.turnScore.setBalls(balls);
    }

    void countStrikes(List<Integer> numberOfList) {
        List<Integer> targetNumberList = target.get();
        int strikes = countSameValueInSameIndex(targetNumberList, numberOfList);
        this.turnScore.setStrikes(strikes);
    }

    int countSameValueInSameIndex(List<Integer> targetNumberList, List<Integer> compareNumberList) {
        int count = 0;
        for (int indexOfList = 0; indexOfList < compareNumberList.size(); indexOfList++) {
            int targetNumber = targetNumberList.get(indexOfList);
            int compareNumber = compareNumberList.get(indexOfList);
            count += returnOneIfSameOrZero(targetNumber, compareNumber);
        }
        return count;
    }

    int returnOneIfSameOrZero(int targetNumber, int compareNumber) {
        if (targetNumber == compareNumber) {
            return 1;
        }
        return 0;
    }

    int countValueContainTogether(List<Integer> targetNumberList, List<Integer> compareNumberList) {
        int count = 0;
        for (int indexOfList = 0; indexOfList < compareNumberList.size(); indexOfList++) {
            int compareNumber = compareNumberList.get(indexOfList);
            count += returnOneIfListContainNumber(targetNumberList, compareNumber);
        }
        return count;
    }

    int returnOneIfListContainNumber(List<Integer> targetNumberList, int compareNumber) {
        if (targetNumberList.contains(compareNumber)) {
            return 1;
        }
        return 0;
    }

    List<Integer> convertNumberStringToList(String numberOfString) {
        List<String> numberOfStringList = new ArrayList<>(Arrays.asList(numberOfString.split("")));
        List<Integer> numberOfList = numberOfStringList.stream()
                .map(Integer::new)
                .collect(Collectors.toList());
        return numberOfList;
    }
}
