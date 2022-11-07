package baseball;

import java.util.List;
import java.util.Objects;

public class CountUtil {
    public boolean compareNumber(List<Integer> playerNumber, List<Integer> randomNumber) {
        PrintUtil printUtil = new PrintUtil();
        ArrayUtil arrayUtil = new ArrayUtil();
        int ball = 0;
        int strike = 0;
        for (int i=0;i<3;++i) {
            if (Objects.equals(playerNumber.get(i), randomNumber.get(i)))
                strike += 1;
            else
                ball += this.countBall(playerNumber.get(i), randomNumber, i);
        }
        return printUtil.printBallStrike(arrayUtil.createCountArray(ball, strike));
    }
    public int countBall(int playerNumber, List<Integer> randomNumber, int i) {
        int ball = 0;
        for (int j=0;j<3;++j)
            if (i != j && playerNumber == randomNumber.get(j))
                ball += 1;
        return ball;
    }
    public static boolean endGame(List<Integer> countBallStrike) {
        return countBallStrike.get(1) == 3;
    }
}