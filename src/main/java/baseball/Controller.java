package baseball;

import java.util.Objects;

import baseball.service.Service;
import baseball.view.RequestInput;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    Service service = new Service();

    public void run() {
        boolean gameEnd = false;
        SystemMessage.printGameStart();
        while (!gameEnd) {
            setGame();
            startGame();
            gameEnd = finishGame();
        }
    }

    private void setGame() {
        service.setGame();
    }

    private void startGame() {
        boolean correctAnswer = false;
        while (!correctAnswer) {
            correctAnswer = playGame();
        }
        SystemMessage.printCorrectAnswer();
    }

    private boolean playGame() {
        RequestInput.requestAnswer();
        String userInput = Console.readLine();
        String result = service.playGame(userInput);
        SystemMessage.printGameResult(result);

        return Objects.equals(result, "3스트라이크");
    }

    private boolean finishGame() {
        RequestInput.requestFinishGame();
        String userInput = Console.readLine();
        return service.finishGame(userInput);
    }
}
