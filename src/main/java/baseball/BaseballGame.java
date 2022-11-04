package baseball;

import java.util.List;

public class BaseballGame {

    private static final String RESTART_GAME = "1";
    private static final String END_GAME = "2";
    private static final String ENDANSWER_ERR_MESSAGE = "1 혹은 2가 아닙니다.";

    Number number = new Number();
    GameResult gameResult = new GameResult();
    InputAndOutput inputAndOutput = new InputAndOutput();

    public void startGame() {
        InputAndOutput.printGameStartPhrase();
        List<Integer> computerNumbers = number.generateRandomNumber();
        String resultPhrase;

        do {
            resultPhrase = playGame(computerNumbers);
            gameResult.printGameResult(resultPhrase);
        } while (!gameResult.isUserWin(resultPhrase));
        String endAnswer = InputAndOutput.getRestartOrEnd();
        inputAndOutput.isValidEndAnswer(endAnswer);
        replayOrEndGame(endAnswer);
    }

    public String playGame(List<Integer> computerNumbers) {
        String answer = InputAndOutput.getUserAnswer();
        boolean availableAnswer = number.isValidAnswer(answer);
        List<Integer> userNumbers = null;

        if (availableAnswer) {
            userNumbers = number.convertStringtoIntegerList(answer);
        }

        return gameResult.getGameResult(computerNumbers, userNumbers);
    }

    public void replayOrEndGame(String endAnswer) {
        if (endAnswer.equals(RESTART_GAME)) {
            startGame();
            return;
        }

        if (endAnswer.equals(END_GAME)) {
            return;
        }

        throw new IllegalArgumentException(ENDANSWER_ERR_MESSAGE);
    }
}