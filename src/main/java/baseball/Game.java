package baseball;

import baseball.ball.Ball;
import baseball.ball.Balls;
import baseball.view.InputView;
import baseball.view.OutputView;

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
        Judge judge= new Judge(settingComputerBall());
        do{
            judge.compareComputerAndPlayer(settingPlayerBall());
        }while(judge.getStrikeCount()!=3);
    }

    public boolean isEnd(){
        OutputView.restartGame();

        Restart restart = new Restart();
        return restart.isEndGame(InputView.inputRestartGame());
    }
}
