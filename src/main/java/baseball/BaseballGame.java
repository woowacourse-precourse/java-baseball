package baseball;

import abstracts.Game;
import java.util.List;

public class BaseballGame extends Game {

    private List[] answerNumbers;

    BaseballGame() {
        this.gameName = "Baseball";
        this.status = Status.PLAYING;
        this.initialize();
    }

    private List[] getAnswerNumbers() {
        return this.answerNumbers;
    }

    private void setAnswerNumbers(List[] answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void terminate() {
    }
}
