import baseball.Player;
import baseball.Result;
import baseball.ball.Ball;
import baseball.ball.Balls;
import baseball.view.OutputView;

import java.util.List;

public class Judge {
    private List<Ball> computerBalls;
    private Result result;

    public Judge(List<Ball> computerBalls) {
        this.computerBalls = computerBalls;
        result=new Result();
    }

    private List<Ball> settingPlayerBalls(Player player){
        Balls playerBalls = player.createBalls();
        return playerBalls.getBalls();
    }

    public void compareComputerAndPlayer(Player player) {
        List<Ball>playBalls=settingPlayerBalls(player);
        for (int i = 0; i < 3; i++) {
            computerBalls.contains(playBalls.get(i));
            calculateStrikeAndBall(computerBalls,playBalls,i);
        }
    }

    private void calculateStrikeAndBall(List<Ball> computerBalls, List<Ball> playBalls, int i){
        if(computerBalls.get(i)==playBalls.get(i)){
            result.plusStrike();
        }
        result.plusBall();
    }
}


