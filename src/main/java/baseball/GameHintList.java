package baseball;

import java.util.ArrayList;

public class GameHintList {
    static ArrayList<String> computerSelectedNumbers;
    static ArrayList<String> userSelectedNumbers;

    public int countOfBall() {
        int count = 0;
        for (int digit = 0; digit < 3; digit++) {
            String computerNumbersDigit = computerSelectedNumbers.get(digit);
            String userNumberDigit = userSelectedNumbers.get(digit);
            if (!computerNumbersDigit.contains(userNumberDigit)) {
                if (computerSelectedNumbers.contains(userNumberDigit)) count++;
            }
        }
        return count;
    }

}
