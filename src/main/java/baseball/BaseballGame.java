package baseball;

import abstracts.Game;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame extends Game {

    private List<Integer> answerNumbers;

    BaseballGame() {
        this.gameName = "Baseball";
        this.status = Status.PLAYING;
        this.initialize();
    }

    private List<Integer> getAnswerNumbers() {
        return this.answerNumbers;
    }

    private void setAnswerNumbers(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    @Override
    protected void initialize() {
    }


    @Override
    protected void terminate() {
    }
}
