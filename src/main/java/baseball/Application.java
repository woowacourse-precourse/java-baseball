package baseball;

import baseball.controller.GameController;

public class Application {
    private static final int PICK_NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        boolean isPlayAgain = true;
        GameController controller = new GameController();

        controller.showTutorial();

        while(isPlayAgain) {
            executeGame(controller);

            String response = controller.showSelectPlayGameAgain();
            isPlayAgain = controller.getPlayGameAgainResult(response);
        }
    }

    private static void executeGame(GameController controller) {
        boolean gameResult = false;

        while (!gameResult) {
            String gameNumber = controller.showPickThreeDigitNumbers();
            gameResult = controller.showSelectNumberResult(gameNumber);
        }
    }
}
