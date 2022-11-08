package baseball;

import static baseball.constant.Finish.RESTART;
import static baseball.constant.Message.FINISH_GAME;
import static baseball.constant.Message.RESTART_GAME;
import static baseball.constant.Message.START_GAME;

import baseball.constant.Finish;
import java.util.List;

public class GameController {

    private final NumberGenerator numberGenerator;
    private final HintCalculator hintCalculator;
    private final View view;

    public GameController(NumberGenerator numberGenerator, HintCalculator hintCalculator,
            View view) {
        this.numberGenerator = numberGenerator;
        this.hintCalculator = hintCalculator;
        this.view = view;
    }

    public void process() {
        start();
        playGame();
    }

    private void start() {
        view.printMessage(START_GAME);
    }

    private void playGame() {
        List<Integer> computer = numberGenerator.generateComputerNumber();
        do {
            List<Integer> user = view.inputIntegerList();
            Hint hint = hintCalculator.getHint(computer, user);
            view.printHint(hint);
            if (isGameFinished(hint)) {
                break;
            }
        } while (true);
        view.printMessage(FINISH_GAME);
        restartGame();
    }

    private void restartGame() {
        view.printMessage(RESTART_GAME);
        Finish finish = view.inputFinishCode();
        if (finish.equals(RESTART)) {
            playGame();
        }
    }

    private boolean isGameFinished(Hint hint) {
        return hint.isThreeStrike();
    }
}
