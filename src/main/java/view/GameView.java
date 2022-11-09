package view;

import controller.GameController;
import utill.ConstantVO;

public class GameView {


    public void run() {
        GameController gameController = GameController.getInstanceGameController();
        gameStartBaseball(gameController);
        explainProceedSituationGame(gameController);
    }

    private void explainProceedSituationGame(GameController gameController) {
        while (true) {
            // User에게 숫자를 입력 받는다.
            getInputGuessNum(gameController);
            // User의 숫자가 맞는지 확인
            giveHintGame(gameController);
            // 게임이 계속되는지 확인
            if (isRightEndGameAndProceedGame(gameController)) {
                break;
            }
            gameController.initCntStrikeBallOfComputer();
        }
    }

    private void gameStartBaseball(GameController gameController) {
        gameController.startGame();
        System.out.println(ConstantVO.MSG_FIRST);
    }

    private boolean isRightEndGameAndProceedGame(GameController gameController) {
        if (gameController.isEndGame()) {
            System.out.println(ConstantVO.MSG_THREE_STRIKE);
            System.out.println(ConstantVO.MSG_CHOICE_PLAY_MORE_GAMES);

            gameController.callInputProceedNum();
            if (gameController.isWantStopGameStopGame()) {
                return true;
            }
        }
        return false;
    }

    private void getInputGuessNum(GameController gameController) {
        System.out.println(ConstantVO.MSG_ENTER_NUMBER);
        gameController.callInputNumOfUser();
    }

    private void giveHintGame(GameController gameController) {
        gameController.isRightNumOfUser2Computer();
        System.out.println(gameController.getHintOfComputer());
    }
}
