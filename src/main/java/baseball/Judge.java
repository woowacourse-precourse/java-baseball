package baseball;

import baseball.ball.Ball;
import baseball.view.OutputView;

import java.util.List;

public class Judge {
    private List<Ball> computerBalls;
    private Result result=new Result();

    public Judge(List<Ball> computerBalls) {
        this.computerBalls = computerBalls;
    }

    public void compareComputerAndPlayer(List<Ball> playerBalls) {
        result.initBallAndStrike();
        for (int i = 0; i < playerBalls.size(); i++) {
            if(computerBalls.contains(playerBalls.get(i))) {
                calculateStrikeAndBall(computerBalls, playerBalls, i);
            }
        }
        printGameResult(result);
    }

    private void calculateStrikeAndBall(List<Ball> computerBalls, List<Ball> playBalls, int i) {
        if (computerBalls.get(i).equals(playBalls.get(i))) {
            result.plusStrike();
        }
        result.plusBall();
    }

    private void printGameResult(Result result) {
        OutputView.gameResult(result);
    }

    public int getStrikeCount(){
        return result.getStrike();
    }
}


