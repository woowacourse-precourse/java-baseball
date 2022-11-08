package baseball;

import baseball.model.BaseballGame;
import baseball.model.GameBoard;
import baseball.view.View;

public class Application {

    public static void main(String[] args) {
        View view = new View();
        BaseballGame game = new BaseballGame();

        view.printStartMenu();
        while (game.isPlaying()) {
            view.printInputMenu();
            String selectedBallNumbers = view.getNumberString();
            GameBoard gameBoard = game.playGame(selectedBallNumbers);
            view.printGameResult(gameBoard.getResult());
            if (gameBoard.isThreeStrike()) {
                view.printEndMenu();
                String command = view.getNumberString();
                game.checkContinueCommand(command);
            }
        }
    }
}
