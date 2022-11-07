package baseball.domain.ball.service;

import baseball.domain.ball.Balls;

import java.util.List;

public class BallServiceImpl implements BallService{

    private final BallFactory ballFactory;
    private final BallCreator ballCreator;

    public BallServiceImpl(BallFactory ballFactory, BallCreator ballCreator) {
        this.ballFactory = ballFactory;
        this.ballCreator = ballCreator;
    }

    @Override
    public Balls createAnswerBalls() {
        final List<Integer> answerList = ballFactory.getRandomNumbers();
        return ballCreator.createBalls(answerList);
    }

    @Override
    public Balls createPlayerBalls(String number) {
        final List<Integer> numberList = ballFactory.convertStringToIntegerList(number);
        return ballCreator.createBalls(numberList);
    }
}
