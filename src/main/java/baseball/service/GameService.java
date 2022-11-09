package baseball.service;

import baseball.entity.Type;
import baseball.view.ViewController;

import java.util.Map;

public class GameService {

    private final String answer;
    private final Separator separator;
    private final RandomGenerator generator;
    private final ViewController viewController;

    public GameService(int answerLength) {
        this.generator = new RandomGenerator(answerLength);
        this.viewController = new ViewController();
        this.answer = generator.getAnswer();
        this.separator = new Separator(answer);
    }

    public void initGame() {
        viewController.printGameStartMessage();
        startGame();
    }

    public void startGame() {
        repeatRound();
    }

    private void repeatRound() {
        boolean flag = false;
        while (!flag) {
            String input = viewController.printAndInputNumber();
            Map<Type, Integer> resultMap = separator.separateInputResult(input);
            flag = viewController.printRoundResult(resultMap);
        }
    }

    public boolean askReGame() {
        return viewController.printReGameAndInput();
    }

    public void closeBuffer() {
        viewController.closeBufferedWriter();
    }

    public boolean forTest_askReGame() {
        boolean b = askReGame();
        return b;
    }

    public void forTest_repeatRound() {
        repeatRound();
    }
}
