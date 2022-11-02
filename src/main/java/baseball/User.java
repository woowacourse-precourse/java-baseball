package baseball;

import static baseball.BaseballGame.*;

import java.util.ArrayList;
import java.util.List;

public class User {

    public List<Integer> toIntUserInput(String userInput) {
        List<Integer> userNum = new ArrayList<>();
        int[] userInputArr =  new int[] {Integer.valueOf(userInput)};
        for (int i = 0; i < userInput.length(); i++) {
            userNum.add(userInputArr[i]);
        }
        return userNum;
    }
}
