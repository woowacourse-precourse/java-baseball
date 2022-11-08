package baseball.service;

import baseball.util.ValidationUtil;
import baseball.view.OutputView;

import java.util.List;
import java.util.ArrayList;

public class JudgeGame {
    public static boolean verifyAnswer(List<Integer> inputNumberList, List<Integer> computerNumberList) {
        int strikeCounter = verifyStrike(inputNumberList, computerNumberList);
        int ballCounter = verifyBall(inputNumberList, computerNumberList);

        if (!verifyRestart(strikeCounter)) {
            return false;
        }
        OutputView.printGameResult(strikeCounter, ballCounter);
        return true;
    }

    public static List<Integer> getInputNumberList(String input) {
        List<Integer> inputNumberList = new ArrayList<>();
        String[] inputList = input.split("");
        for (String inputNumber : inputList) {
            Integer integerNumber = Integer.parseInt(inputNumber);
            inputNumberList.add(integerNumber);
        }
        return inputNumberList;
    }

    public static int verifyStrike(List<Integer> inputNumberList, List<Integer> computerNumberList) {
        int strikeCounter = 0;
        for (int i = 0; i < inputNumberList.size(); i++) {
            Integer inputNumber = inputNumberList.get(i);
            Integer computerNumber = computerNumberList.get(i);
            if (inputNumber.equals(computerNumber)) {
                strikeCounter += 1;
            }
        }
        return strikeCounter;
    }

    public static int verifyBall(List<Integer> inputNumberList, List<Integer> computerNumberList) {
        int ballCount = 0;
        for (int i = 0; i < inputNumberList.size(); i++) {
            Integer inputNumber = inputNumberList.get(i);
            Integer computerNumber = computerNumberList.get(i);
            if (!inputNumber.equals(computerNumber)
                    && computerNumberList.contains(inputNumber)) {
                ballCount += 1;
            }
        }
        return ballCount;
    }

    public static boolean verifyRestart(int strikeCounter) {
        if (strikeCounter != 3) {
            return true;
        }
        OutputView.printGameClear();
        String input = OutputView.printAskingRestart();

        ValidationUtil.validateInputRestart(input);
        return false;
    }
}
