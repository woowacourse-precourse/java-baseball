package baseball.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import baseball.domain.Game;
import baseball.utils.Converter;
import baseball.utils.RandomNumber;
import baseball.utils.Validator;
import baseball.view.SystemMessage;

public class Service {
    Game game;

    public void setGame() {
        List<Integer> randomNumberList = RandomNumber.generateUnduplicatedThreeNumbers();
        this.game = new Game(randomNumberList);
    }

//    public void startGame() {
//        boolean correctAnswer = false;
//        while (!correctAnswer) {
//            correctAnswer = playGame();
//        }
//        SystemMessage.printCorrectAnswer();
//    }


    public boolean playGame(String userInput) {
        Validator.checkUserAnswerInput(userInput);
        game.initializeResultMap();
        List<Integer> userAnswer = Converter.toIntegerList(userInput);
        Map<String, Integer> result = game.getResult(userAnswer);
        String resultMessage = Converter.changeResultMapToString(result);
        SystemMessage.printGameResult(resultMessage);

        return result.get("strike") == 3;
    }

    public boolean finishGame(String userInput) {
        Validator.checkUserFinishInput(userInput);

        return Objects.equals(userInput, "2");
    }
}
