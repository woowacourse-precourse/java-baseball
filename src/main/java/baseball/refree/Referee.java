package baseball.refree;

import java.util.List;

public class Referee {
    private static final int GAME_SIZE = 3;

    public Referee() {

    }

    public static int ballCount(List<Integer> userBallList, List<Integer> comBallList) {

        int ball = 0;
        for(int i = 0; i < GAME_SIZE; i++) {
            if(userBallList.get(i) != comBallList.get(i) && comBallList.contains(userBallList.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    public static int strikeCount(List<Integer> userBallList, List<Integer> comBallList) {

        int strike = 0;

        for (int i = 0; i < GAME_SIZE; i++) {
            if(userBallList.get(i) == comBallList.get(i)) strike++;
        }

        return strike;
    }

}
