package baseball;

import baseball.domain.User;
import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGame {

    public static void run() {
        OutputView.initGameMessage();
        while (true) {
            String restartInput = startGame();
            if (isRestartInputFalse(restartInput)) {
                throw new IllegalArgumentException();
            }
            if (restartInput.equals("2")) {
                OutputView.endSystemMessage();
                break;
            }
        }
    }

    public static String startGame() {
        List<Integer> computerNumber = Computer.createNumbers();
        while (true) {
            List<Integer> userNumber = User.getNumbers();
            String result = Referee.checkResult(computerNumber, userNumber);
            OutputView.printString(result);
            if (result.equals("3스트라이크")) {
                break;
            }
        }
        OutputView.endGameMessage();
        String restartMessage = InputView.askRestartMessage();
        return restartMessage;
    }

    public static boolean isRestartInputFalse(String input) {
        return !(input.equals("2") || input.equals("1"));
    }
}
