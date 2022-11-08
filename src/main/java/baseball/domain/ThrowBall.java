package baseball.domain;

import baseball.view.OutputView;

import java.util.ArrayList;

public class ThrowBall {
    private static final int BALL_LENGTH = 3;
    private static final int INIT_COUNT = 0;
    private int ballCount;
    private int strikeCount;

    public Boolean decideBall(ArrayList<Integer> computerBall, ArrayList<Integer> userBall){
        ballCount = INIT_COUNT;
        strikeCount = INIT_COUNT;

        ballAndStrikeCount(computerBall, userBall);
        return printResult();
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

    private Boolean printResult(){
        if (strikeCount == 3){
            OutputView.printHomeRun(strikeCount);
            return false;
        }
        if (ballCount == 0 && strikeCount == 0) {
            OutputView.printNothingMessage();
            return true;
        }
        if (ballCount > 0 && strikeCount > 0) {
            OutputView.printBallAndStrikeMessage(ballCount, strikeCount);
            return true;
        }
        if (ballCount > 0) {
            OutputView.printOnlyBallMessage(ballCount);
            return true;
        }
        if (strikeCount > 0) {
            OutputView.printOnlyStrikeMessage(strikeCount);
            return true;
        }
        return true;
    }
}
