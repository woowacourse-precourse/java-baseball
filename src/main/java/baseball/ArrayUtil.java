package baseball;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {
    public List<Integer> createCountArray(int ball, int strike) {
        List<Integer> countBallStrike = new ArrayList<>();
        countBallStrike.add(ball);
        countBallStrike.add(strike);
        return countBallStrike;
    }
    public List<Integer> arrayPlayerNumber() {
        InputUtil inputUtil = new InputUtil();
        List<Integer> playerNumber = new ArrayList<>();
        String inputPlayerNumber = inputUtil.inputPlayerNumber();
        for (int i=0;i<inputPlayerNumber.length();++i)
            playerNumber.add((int) inputPlayerNumber.charAt(i) - 48);
        return playerNumber;
    }
}