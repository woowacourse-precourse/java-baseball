package baseball;

import baseball.domain.User;
import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGame {

    public static void run(){
        OutputView.initSystemMessage();
        while (true) {
            String restartCheckInput = startGame();
            if (restartCheckInput.equals("2")) {
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
            System.out.println(result);
            if (result.equals("3스트라이크")){
                break;
            }
        }
        OutputView.endGameMessage();
        String restartMessage = InputView.askRestartMessage();
        return restartMessage;
    }
}
