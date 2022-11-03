package baseball.baseballgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberToListChanger {

    public static List<Integer> change(int userInputNumbers) {
        List<Integer> userBallList = new ArrayList<>();
        while (userInputNumbers > 0) {
            userBallList.add(userInputNumbers % 10);
            userInputNumbers /= 10;
        }
        Collections.reverse(userBallList);
        return userBallList;
    }

}
