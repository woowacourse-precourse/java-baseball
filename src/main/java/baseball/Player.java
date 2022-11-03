package baseball;

import static baseball.Computer.NUM_LIMIT_LENGTH;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public static List<Integer> toIntegerUserInput(String userInput) {
        List<Integer> userInputNumber = new ArrayList<>(NUM_LIMIT_LENGTH);
        String[] userInputArr = userInput.split("");
        for (String str : userInputArr) {
            userInputNumber.add(Integer.parseInt(str));
        }
        return userInputNumber;
    }
}
