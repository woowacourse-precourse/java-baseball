package baseball.domain;

import baseball.utils.AnswerGenerator;
import baseball.utils.Constants;
import baseball.utils.InputValidator;
import baseball.view.GameView;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private boolean status = false;
    private final Judge judge;

    public Game() {
        Answer answer = new Answer(AnswerGenerator.generateAnswer());
        this.judge = new Judge(answer);
    }

    public boolean isRunning() {
        return this.status;
    }

    public void startGame() {
        GameView.printStartMessage();
        this.status = true;
    }

    public List<Integer> getUserInput() {
        String userInputStr = GameView.askUserInput();
        List<Integer> userInput = changeUserInputToArray(userInputStr);
        InputValidator.hasValidInput(userInput);
        return userInput;
    }

    public List<Integer> changeUserInputToArray(String userInputStr) {
        InputValidator.hasValidType(userInputStr);
        List<Integer> userInput = new ArrayList<>();
        for (int i = 0; i < userInputStr.length(); i++) {
            userInput.add(userInputStr.charAt(i) - '0');
        }
        return userInput;
    }

    public void judgeUserInput(List<Integer> userInput) {
        int strikeCount = judge.getStrikeCount(userInput);
        int ballCount = judge.getBallCount(userInput);
        GameView.printHint(strikeCount, ballCount);
        if (strikeCount == Constants.CORRECT_STRIKE_COUNT) {
            GameView.printResult(judge.isCorrect(strikeCount));
            this.status = false;
        }
    }

    public boolean decideRestart() {
        int restartSign = Integer.parseInt(GameView.askRestart());
        InputValidator.hasValidRestartSign(restartSign);
        if (restartSign == Constants.AGREE_RESTART_SIGN) {
            return true;
        }
        if (restartSign == Constants.DISAGREE_RESTART_SIGN) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
