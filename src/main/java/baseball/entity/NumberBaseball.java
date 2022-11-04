package baseball.entity;

import baseball.service.RandomGenerator;

public class NumberBaseball implements Game{
    public static final int GAME_ANSWER_MAX_VALUE = 3;
    private RandomGenerator randomGenerator = new RandomGenerator();
    private State state;

    @Override
    public void start() {

    }

    @Override
    public void end() {

    }
}
