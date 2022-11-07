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
}
