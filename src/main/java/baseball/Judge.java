package baseball;

import baseball.Player;
import baseball.Result;
import baseball.ball.Ball;
import baseball.ball.Balls;
import baseball.view.OutputView;

import java.util.List;

public class Judge {
    private List<Ball> computerBalls;
    private Result result;

    public Judge(List<Ball> computerBalls,Result result) {
        this.computerBalls = computerBalls;
        this.result=result;
    }

    public void compareComputerAndPlayer(List<Ball>playerBalls) {
        for (int i = 0; i < 3; i++) {
            computerBalls.contains(playerBalls.get(i));
            calculateStrikeAndBall(computerBalls,playerBalls,i);
        }
        printGameResult();
    }

    private void calculateStrikeAndBall(List<Ball> computerBalls, List<Ball> playBalls, int i){
        if(computerBalls.get(i)==playBalls.get(i)){
            result.plusStrike();
        }
        result.plusBall();
    }

    private void printGameResult(){
        OutputView.gameResult(result);
    }
}


