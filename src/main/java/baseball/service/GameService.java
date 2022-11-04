package baseball.service;

import baseball.view.Controller;

import java.util.Map;

public class GameService {

    private final String answer;
    private final Separator separator;
    private final RandomGenerator generator;
    private final Controller controller;

    public GameService(int answerLength) {
        this.generator = new RandomGenerator();
        this.controller = new Controller();
        this.answer = generator.generateRandomNumbers(answerLength); // TODO 랜덤 생성 -> gameservice에 할당?
        //this.answer = "123";            // 임시 정답
        this.separator = new Separator(answer);
    }

    public void initGame() {
        controller.printGameStartMessage();
    }

    public boolean startGame() {
        repeatRound();
        return askReGame();
    }

    private void repeatRound() {
        boolean flag = false;
        while (!flag) {
            String input = controller.printAndInputNumber();
            Map<String, Integer> resultMap = separator.separateInputResult(input);
            flag = controller.printRoundResult(resultMap);
        }
    }

    private boolean askReGame() {
        return controller.printReGameAndInput();
    }

    public boolean forTest_askReGame() {
        boolean b = askReGame();
        return b;
    }

    public void forTest_repeatRound() {
        repeatRound();
    }
}
