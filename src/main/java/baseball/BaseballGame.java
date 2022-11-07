package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    int ball = 0;
    int strike = 0;
    int nothing = 0;


    public List<Integer> StringToIntList(String input) {
        int inputNumber = Integer.parseInt(input);
        List<Integer> inputNumberList = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++){
            inputNumberList.add(inputNumber % 10);
            inputNumber /= 10;
        }
//        System.out.println(inputNumberList);
        return inputNumberList;
    }
    

}
