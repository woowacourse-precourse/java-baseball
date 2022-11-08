package baseball.controller;

import baseball.entity.Result;
import baseball.util.GameLogic;
import baseball.util.RandomUtil;
import baseball.view.GameView;

public class GameController {

    private final GameView view;
    private final GameLogic logic;

    private boolean gameEnd = false;
    private boolean threeStrike = false;

    public GameController(GameView view, GameLogic logic) {
        this.view = view;
        this.logic = logic;
    }

    public void startGame() {
        while (!gameEnd) {
            threeStrike = false;
            view.announceStart();
            String target = RandomUtil.generateNumber();
            startPitch(target);
        }
    }

    private void startPitch(String target) {
        while (!threeStrike) {
            String input = view.getInput();
            Result judgement = logic.judge(target, input);
            view.ballsAndStrikes(judgement.getBall(), judgement.getStrike());
            checkThreeStrike(judgement);
        }
    }

    private void checkThreeStrike(Result judge) {
        if (logic.isGameSet(judge)) {
            view.announceGameSet();
            threeStrike = true;
            gameEnd = !view.isRestart(view.readLine());
        }
    }
}
