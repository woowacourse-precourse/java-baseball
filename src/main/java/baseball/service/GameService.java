package baseball.service;

import baseball.view.Controller;

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

}
