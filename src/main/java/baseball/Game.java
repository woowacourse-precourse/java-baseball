package baseball;

import baseball.ball.Ball;
import baseball.ball.Balls;

import java.util.List;

public class Game {
    private List<Ball> settingComputerBall(){
        Computer computer = new Computer();
        Balls computerBalls=computer.createComputerBalls();
        return computerBalls.getBalls();
    }

    private List<Ball>settingPlayerBall(){
        Player player= new Player();
        Balls playerBalls= player.createBalls();
        return playerBalls.getBalls();
    }


    public void playGame(){
        Result result= new Result();
        Judge judge= new Judge(settingComputerBall(),result);
        while(result.getStrike()!=3){
            judge.compareComputerAndPlayer(settingPlayerBall());
        }
    }
}
