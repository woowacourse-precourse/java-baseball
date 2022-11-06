package baseball.controller;

import baseball.model.BallNumber;
import baseball.model.GameManager;
import baseball.view.View;

import java.util.List;

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
    }
}
