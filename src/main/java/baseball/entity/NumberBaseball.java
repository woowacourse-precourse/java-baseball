package baseball.entity;

import baseball.service.RandomNumber;

public class NumberBaseball implements Game{
    public static final int GAME_ANSWER_MAX_VALUE = 3;
    private RandomNumber randomNumber = new RandomNumber();
    private State state;

    @Override
    public void start() {

    }

    @Override
    public void end() {

    }
}
