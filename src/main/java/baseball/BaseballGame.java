package baseball;

import java.util.List;

public class BaseballGame {

    Number number = new Number();
    GameResult gameResult = new GameResult();

    public String playGame(List<Integer> computerNumbers) {
        String answer = InputAndOutput.getUserAnswer();
        boolean availableAnswer = number.isValidAnswer(answer);
        List<Integer> userNumbers = null;

        if (availableAnswer) {
            userNumbers = number.convertStringtoIntegerList(answer);
        }

        return gameResult.getGameResult(computerNumbers, userNumbers);
    }
}