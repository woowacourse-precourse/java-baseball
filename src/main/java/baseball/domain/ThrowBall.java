package baseball.domain;

import baseball.view.OutputView;

import java.util.ArrayList;

public class ThrowBall {
    private static final int BALL_LENGTH = 3;
    private static final int INIT_COUNT = 0;
    private int ballCount;
    private int strikeCount;

    public void decideBall(ArrayList<Integer> computerBall, ArrayList<Integer> userBall){
        ballCount = INIT_COUNT;
        strikeCount = INIT_COUNT;

        ballAndStrikeCount(computerBall, userBall);
    }

    private void ballAndStrikeCount(ArrayList<Integer> computerBall, ArrayList<Integer> userBall){
        for (int i = 0; i < BALL_LENGTH; i++){
            if (userBall.get(i).equals(computerBall.get(i))){
                strikeCount++;
                continue;
            }

            if (computerBall.contains(userBall.get(i))){
                ballCount++;
                continue;
            }
        }
    }
}
