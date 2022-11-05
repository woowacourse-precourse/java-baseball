package baseball.domain;

import baseball.utils.AnswerGenerator;
import baseball.utils.Constants;
import baseball.utils.NumberValidator;
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
        NumberValidator.hasValidInput(userInput);
        return userInput;
    }

    public List<Integer> changeUserInputToArray(String userInputStr) {
        NumberValidator.hasValidType(userInputStr);
        List<Integer> userInput = new ArrayList<>();
        for (int i = 0; i < userInputStr.length(); i++) {
            userInput.add(userInputStr.charAt(i) - '0');
        }
        return userInput;
    }

    public void judgeUserInput(List<Integer> userInput) {
        int strikeCount = this.judge.getStrikeCount(userInput);
        int ballCount = this.judge.getBallCount(userInput);
        GameView.printHint(strikeCount, ballCount);
        if (strikeCount == Constants.CORRECT_STRIKE_COUNT) {
            GameView.printResult(this.judge.isCorrect(strikeCount));
            this.status = false;
        }
    }

    public boolean decideRestart() {
        int restartSign = Integer.parseInt(GameView.askRestart());
        NumberValidator.hasValidRestartSign(restartSign);
        if (restartSign == Constants.AGREE_RESTART_SIGN) {
            return true;
        }
        if (restartSign == Constants.DISAGREE_RESTART_SIGN){
            return false;
        }
        throw new IllegalArgumentException();
    }
}
