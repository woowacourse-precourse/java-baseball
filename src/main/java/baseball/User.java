package baseball;

import static baseball.BaseballGame.*;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static List<Integer> toIntUserInput(String userInput) {
        List<Integer> userNum = new ArrayList<>();
        String[] userInputArr = userInput.split("");
        for (int i = 0; i < userInput.length(); i++) {
            userNum.add(Integer.valueOf(userInputArr[i]));
        }
        return userNum;
    }
}
