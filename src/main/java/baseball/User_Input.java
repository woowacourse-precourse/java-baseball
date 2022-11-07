package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class User_Input {
    public List<Integer> getUserInput() {
        List<Integer> inputToList = new ArrayList<>();
        String getNum =  Console.readLine();

        for (int i=0; i<getNum.length(); i++) {
            inputToList.add(getNum.charAt(i) - '0');
        }
        if (!Checker(inputToList)) {
            throw new IllegalArgumentException();
        }
        return inputToList;
    }

    public static boolean Checker(List<Integer> inputNum) { // not valid => false
        List<Integer> compareList = new ArrayList<>();
        compareList.add(0);
        if (inputNum.size() == 3) {
            for (int i=0; i<3; i++) {
                int item = inputNum.get(i);
                if (compareList.contains(item)) { return false; }
                if (item > 9) { return false; }
                compareList.add(item);
            }
        } else  { return false; }
        return true;
    }
}
