package baseball.domain;

import baseball.utils.AnswerGenerator;
import baseball.utils.Constants;
import baseball.utils.InputValidator;
import baseball.utils.UserInputAdapter;
import baseball.view.GameView;
import java.util.List;

public class Game {
    private boolean running = false;
    private final Judge judge;

    public Game() {
        Answer answer = new Answer(AnswerGenerator.generateAnswer());
        this.judge = new Judge(answer);
    }

    public boolean isRunning() {
        return this.running;
    }

    public void startRound() {
        GameView.printStartMessage();
        this.running = true;
    }

    public List<Integer> getUserInput() {
        String userInputStr = GameView.askUserInput();
        List<Integer> userInput = UserInputAdapter.changeStrToIntegerArray(userInputStr);
        InputValidator.hasValidInput(userInput);
        return userInput;
    }

    public void judgeUserInput(List<Integer> userInput) {
        Score score = judge.getUserInputScore(userInput);
        GameView.printHint(score);
        if (score.isCorrect()) {
            GameView.printResult();
            this.running = false;
        }
    }

    public boolean decideRestart() {
        int restartSign = UserInputAdapter.changeStrToInt(GameView.askRestart());
        InputValidator.hasValidRestartSign(restartSign);
        return restartSign == Constants.AGREE_RESTART_SIGN;
    }
}
