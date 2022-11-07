package baseball.service;

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

    private static int verifyStrike(List<Integer> inputNumberList, List<Integer> ComputerNumberList){
        int strikeCounter = 0;

        for (int i=0; i < inputNumberList.size(); i++){
            if (inputNumberList.get(i).equals(ComputerNumberList.get(i))){
                strikeCounter += 1;
            }
        }
        return strikeCounter;
    }

}
