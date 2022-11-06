package view;

import controller.GameController;

public class GameView {

    final String MSG_FIRST = "숫자 야구 게임을 시작합니다.";
    final String MSG_THREE_STRIKE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final String MSG_CHOICE_PLAY_MORE_GAMES = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final String MSG_ENTER_NUMBER = "숫자를 입력해주세요 : ";

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
        System.out.println(MSG_FIRST);
    }

    private boolean isRightEndGameAndProceedGame(GameController gameController) {
        if (gameController.isEndGame()) {
            System.out.println(MSG_THREE_STRIKE);
            System.out.println(MSG_CHOICE_PLAY_MORE_GAMES);

            gameController.callInputProceedNum();
            if (gameController.isEndgameInputOfUser()) {
                return true;
            }
        }
        return false;
    }

    private void getInputGuessNum(GameController gameController) {
        System.out.println(MSG_ENTER_NUMBER);
        gameController.callInputNumOfUser();
    }

    private void giveHintGame(GameController gameController) {
        if (gameController.isRightNumOfUser2Computer()) {
            System.out.println(gameController.getHintOfComputer());
        } else {
            System.out.println(gameController.getHintOfComputer());
        }
    }
}
