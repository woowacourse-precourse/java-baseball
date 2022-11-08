package baseball.controller;

import baseball.model.BallNumber;
import baseball.model.GameManager;
import baseball.view.View;

import java.util.List;

import static baseball.constant.ConstantValue.STRIKE;

public class BaseballGame {
    private static final View view = new View();
    private static final GameManager gm = new GameManager();
    public BaseballGame(){
    }
    public void startGame(){
        view.initView();
        BallNumber computer = new BallNumber(gm.createComputerNumber());
        List<Integer> computerNumber = computer.getBallNumbers();

        String initNumber;
        BallNumber player;
        List<Integer> playerNumber;
        boolean endGame = false;
        while(!endGame){
            initNumber = view.gameView();
            player = new BallNumber(gm.toList(initNumber));
            playerNumber = player.getBallNumbers();

            int[] gameResult = gm.playGame(computerNumber, playerNumber);
            gm.printResult(gameResult);
            endGame = gm.isEnd(gameResult[STRIKE]);
        }

        String userChoice = gm.isRestart(view.endView());
        if(userChoice.equals("restart")){
            startGame();
        }

    }
}
