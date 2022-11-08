package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    static List<Integer> NumList(String inputNum) {
        List<Integer> NumList = new ArrayList<>();
        for(int i = 0; i < inputNum.length(); i++)
        {
            char currentChar = inputNum.charAt(i);
            int currentNum = currentChar - '0';
            NumList.add(currentNum);
        }
        return NumList;
    }
    static void CheckNum(String inputNum){
        Exception.CheckNotThreeLength(inputNum);
        Exception.CheckNotRedundant(inputNum);
        Exception.CheckNotNumber(inputNum);
    }
}
