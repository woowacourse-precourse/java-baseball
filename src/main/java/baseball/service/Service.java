package baseball.service;

import java.util.List;
import java.util.Map;

import baseball.domain.Game;
import baseball.utils.RandomNumber;
import baseball.utils.Validator;
import baseball.view.RequestInput;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class Service {
    Game game;

    public void setGame() {
        List<Integer> randomNumberList = RandomNumber.generateUnduplicatedThreeNumbers();
        this.game = new Game(randomNumberList);
    }

    public void startGame() {
        boolean correctAnswer = false;
        while (!correctAnswer) {
            correctAnswer = playGame();
        }
        SystemMessage.printCorrectAnswer();
    }

    private boolean playGame() {
        RequestInput.requestAnswer();
        String userInput = Console.readLine();
        Validator.checkUserAnswerInput(userInput);
        Map<String, Integer> result = game.getResult(userInput);
        SystemMessage.printGameResult(result);

        return result.get("strike") == 3;
    }
}
