package baseball;

import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        boolean isPlayAgain = true;
        GameController controller = new GameController();

        controller.showTutorial();
        controller.addComputerNumbersForTest();

        while(isPlayAgain) {
            executeGame(controller);

            String response = controller.showSelectPlayGameAgain();
            isPlayAgain = controller.getPlayGameAgainResult(response);
        }
    }

    private static void executeGame(GameController controller) {
        boolean gameResult = false;

        while (!gameResult) {
            controller.addComputerNumber();

            String gameNumber = controller.showPickThreeDigitNumber();
            gameResult = controller.showSelectNumberResult(gameNumber);
        }
    }
}
