package baseball.Controller;

import baseball.Model.Player;
import baseball.Model.Number;
import baseball.View.InputView;
import baseball.View.OutputView;

public class Game {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Number number = new Number();
    private Player player = new Player();
    private boolean startOrEnd = true;

    public void run() {
        outputView.startGameMessage();
        while (startOrEnd) {
            player.saveComputerNumber(number.createComputerNumber());
            oneGame();
        }
    }

    private void oneGame() {
        boolean pass = true;
        while (pass) {
            outputView.inputNumMessage();
            String input = inputView.inputUser();
        }
    }
}
