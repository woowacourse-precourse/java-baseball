package view;

import controller.GameController;

public class GameView {

    final String WORD_FIRST = "숫자 야구 게임을 시작합니다.";
    final String WORD_ENTER_NUMBER = "숫자를 입력해주세요 : ";

    public void run() {
        GameController gameController = new GameController();
        while (true) {
            System.out.println(WORD_FIRST);

            // User에게 숫자를 입력 받는다.
            System.out.println(WORD_ENTER_NUMBER);
            gameController.callInputNumOfUser();

            // User의 숫자가 맞는지 확인
            if (gameController.isRightNumOfUser2Computer()) {
                System.out.println(gameController.getHintOfComputer());
            } else {
                System.out.println(gameController.getHintOfComputer());
            }

            // 게임이 계속되는지 확인
            if (gameController.isEndGame()) {
                break;
            }
        }
    }

}
