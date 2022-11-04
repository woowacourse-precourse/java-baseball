package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class MyBalls {
    public List<Integer> inputBalls(String myInputNumbers) {
        List<Integer> myBallNumbers = new ArrayList<>();
        for (int ballIndex = 0; ballIndex < myInputNumbers.length(); ballIndex++) {
            myBallNumbers.add(myInputNumbers.charAt(ballIndex) - '0');
        }
        return myBallNumbers;
    }
}
