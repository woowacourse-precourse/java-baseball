package baseball.controller;

import baseball.model.BallNumber;
import baseball.model.GameManager;
import baseball.view.View;

import java.util.List;

public class BaseballGame {
    private static final View view = new View();
    private static final GameManager gm = new GameManager();
    private static boolean endGame = false;

    public BaseballGame(){
    }

    public void startGame(){
        view.initView();
        BallNumber computer = new BallNumber(gm.createComputerNumber());
        List<Integer> computerNumber = computer.getBallNumbers();

        String initNumber;
        BallNumber player;
        List<Integer> playerNumber;

        while(!endGame){
            initNumber = view.gameView();
            player = new BallNumber(gm.toList(initNumber));
            playerNumber = player.getBallNumbers();

            int[] gameResult = gm.playGame(computerNumber, playerNumber);
            gm.printResult(gameResult);
        }
    }
}
