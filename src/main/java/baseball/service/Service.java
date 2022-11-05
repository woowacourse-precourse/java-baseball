package baseball.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import baseball.domain.Game;
import baseball.utils.Converter;
import baseball.utils.RandomNumber;
import baseball.utils.Validator;

public class Service {
    Game game;

    public void setGame() {
        List<Integer> randomNumberList = RandomNumber.generateUnduplicatedThreeNumbers();
        this.game = new Game(randomNumberList);
    }

    public String playGame(String userInput) {
        Validator.checkUserAnswerInput(userInput);
        List<Integer> userAnswer = Converter.toIntegerList(userInput);
        Map<String, Integer> result = game.getResult(userAnswer);
        return Converter.changeResultMapToString(result);
    }

    public boolean finishGame(String userInput) {
        Validator.checkUserFinishInput(userInput);

        return Objects.equals(userInput, "2");
    }
}
