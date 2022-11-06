package baseball.Controller;

import baseball.Model.Player;
import baseball.Model.Number;
import baseball.View.OutputView;

public class Game {

    private OutputView outputView = new OutputView();
    private Number number = new Number();
    private Player player = new Player();
    private boolean startOrEnd = true;

    public void run() {
        outputView.startGameMessage();
        while (startOrEnd) {
            player.saveComputerNumber(number.createComputerNumber());

        }
    }


}
