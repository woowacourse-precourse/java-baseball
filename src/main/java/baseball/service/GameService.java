package baseball.service;

import baseball.view.Controller;

import java.util.Map;

public class GameService {

    private final String answer;
    private final Separation separation;
    private final RandomGenerator generator;
    private final Controller controller;

    public GameService() {
        this.generator = new RandomGenerator();
        this.controller = new Controller();
        this.answer = generator.generateRandomNumbers(); // TODO 랜덤 생성 -> gameservice에 할당?
        //this.answer = "123";            // 임시 정답
        this.separation = new Separation(answer);
    }

    public void initGame() {
        controller.printGameStartMessage();
    }

    private void repeatRound() {
        boolean flag = false;
        while(!flag) {
            String input = controller.printAndInputNumber();
            Map<String, Integer> resultMap = separation.separateInputResult(input);
            flag = controller.printRoundResult(resultMap);
        }
    }


}
