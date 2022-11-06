package baseball;

import static baseball.domain.Referee.validateUserInput;

import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public static List<Integer> getNumbers() {
        List<Integer> userNumbers = new ArrayList<>();
        InputView.askNumberMessage();
        String input = Console.readLine();

        if (validateUserInput(input, userNumbers)){
            for (char c: input.toCharArray()){
                userNumbers.add(Character.getNumericValue(c));
            }
        }

        return userNumbers;
    }

    public static void run(){
        OutputView.initSystemMessage();
        while (true) {
            startGame();
            String restartCheckInput = Console.readLine();
            if (restartCheckInput.equals("2")) {
                OutputView.endSystemMessage();
                break;
            }
        }
    }

    public static void startGame() {
        List<Integer> computerNumber = Computer.createNumbers();
        while (true) {
            List<Integer> userNumber = getNumbers();
            String result = Referee.checkResult(computerNumber, userNumber);
            System.out.println(result);
            if (result.equals("3스트라이크")){
                break;
            }
        }
        OutputView.endGameMessage();
        InputView.askRestartMessage();
    }
}
