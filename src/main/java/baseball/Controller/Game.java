package baseball.Controller;

import baseball.Model.Player;
import baseball.Model.Number;
import baseball.Model.Referee;
import baseball.View.InputView;
import baseball.View.OutputView;

public class Game {

    private static final int THREESTRIKE = 3;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Number number = new Number();
    private Player player = new Player();
    private Referee referee = new Referee();
    private boolean startOrEnd = true;

    public void run() {
        outputView.startGameMessage();
        while (startOrEnd) {
            player.saveComputerNumber(number.createComputerNumber());
            playOneGame();
            outputView.printStartOrEnd();
            startOrEnd = referee.isStart(inputView.inputUser());
        }
    }

    private void playOneGame() {
        boolean pass = true;
        while (pass) {
            outputView.inputNumMessage();
            String input = inputView.inputUser();
            player.saveUserNumber(number.checkNumberAndSave(input));
            referee.isStrike(player.getUser(), player.getComputer());
            referee.isBall(player.getUser(), player.getComputer());
            outputView.printResultState(referee.getBall(), referee.getStrike());
            if (referee.getStrike() == THREESTRIKE) {
                pass = false;
            }
        }
    }
}
