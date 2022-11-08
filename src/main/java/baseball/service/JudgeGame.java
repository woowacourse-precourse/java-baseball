package baseball.service;

import baseball.controller.GameController;
import baseball.util.ValidationUtil;
import baseball.view.OutputView;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class JudgeGame {

    public static List<String> getInputNumberList(String input){
        String[] inputNumberArray = input.split("");
        List<String> inputNumberList = new ArrayList<>();
        inputNumberList = Arrays.asList(inputNumberArray);
        return inputNumberList;
    }

    public static int verifyStrike(List<Integer> inputNumberList, List<Integer>  computerNumberList){
        int strikeCounter = 0;

        for (int i=0; i < inputNumberList.size(); i++){
            Integer inputNumber = inputNumberList.get(i);
            Integer computerNumber = computerNumberList.get(i);
            if (inputNumber.equals(computerNumber)){
                strikeCounter += 1;
            }
        }
        return strikeCounter;
    }

    public static int verifyBall(List<Integer> inputNumberList, List<Integer> computerNumberList){
        int ballCount = 0;
        for (int i=0; i<inputNumberList.size(); i++){
            Integer inputNumber = inputNumberList.get(i);
            Integer computerNumber = computerNumberList.get(i);
            if (!inputNumber.equals(computerNumber)
                    && computerNumberList.contains(inputNumber)){
                ballCount += 1;
            }
        }
        return ballCount;
    }

    public static boolean verifyRestart(int strikeCounter){
        if (strikeCounter != 3){
            return true;
        }

        OutputView.printGameClear();
        String input = OutputView.printAskingRestart();

        ValidationUtil.validateInputRestart(input);
        return false;
        }
    }

}
