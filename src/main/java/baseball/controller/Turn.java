package baseball.controller;

import baseball.model.Target;
import baseball.model.TurnScore;
import baseball.constant.ResultTurn;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Turn {
    private Target target;
    private TurnScore turnScore = new TurnScore();

    Turn(Target target) {
        this.target = target;
    }

    Turn(Target target, TurnScore turnScore) {
        this.turnScore = turnScore;
        this.target = target;
    }

    void repeatToEnd() {
        while (checkCanRepeat()) {
            playOneTurn();
        }
    }

    void playOneTurn() {
        String userNumberOfString = InputView.userNumber();
        ExceptionHandler.validateUserNumberOfString(userNumberOfString);
        List<Integer> userNumberOfList = convertNumberStringToList(userNumberOfString);
        compareWithTarget(userNumberOfList);
        this.turnScore.setResultTurn();
        printResultOfThisTurn();
    }

    boolean checkCanRepeat() {
        ResultTurn resultTurn = this.turnScore.getResultTurn();
        return resultTurn != ResultTurn.OUT;
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

    void printResultOfThisTurn() {
        ResultTurn resultTurn = turnScore.getResultTurn();
        int balls = turnScore.getBalls();
        int strikes = turnScore.getStrikes();

        if (resultTurn == ResultTurn.OUT) {
            OutputView.printResultTurnOfOut();
            return;
        }
        if (resultTurn == ResultTurn.NOTHING) {
            OutputView.printResultTurnOfNothing();
            return;
        }
        if (resultTurn == ResultTurn.ONLY_BALLS) {
            OutputView.printResultTurnOfOnlyBalls(balls);
            return;
        }
        if (resultTurn == ResultTurn.ONLY_STRIKES) {
            OutputView.printResultTurnOfOnlyStrikes(strikes);
            return;
        }
        OutputView.printResultTurnOfStrikesAndBalls(balls, strikes);
    }

}
