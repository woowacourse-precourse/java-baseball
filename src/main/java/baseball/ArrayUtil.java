package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArrayUtil {

    public List<Integer> createCountArray(int ball, int strike) {
        List<Integer> countBallStrike = new ArrayList<>();
        countBallStrike.add(ball);
        countBallStrike.add(strike);
        return countBallStrike;
    }
    public List<Integer> arrayPlayerNumber(String number) {
        List<Integer> playerNumber = new ArrayList<>();
        for (int i=0;i<number.length();++i)
            playerNumber.add((int)number.charAt(i) - 48);
        return playerNumber;
    }
    public List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        return (computer);
    }
}