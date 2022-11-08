package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Balls {

    private List<Ball> balls;

    public Balls(List<Integer> ballNumbers) {
        validateSize(ballNumbers);
        validateUnique(ballNumbers);
        balls = ballNumbers.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    public Balls(String numbers) {
        this(Arrays.asList(numbers.split("")).stream()
                .map(s->Integer.parseInt(s))
                .collect(Collectors.toList()));
    }

    private void validateUnique(List<Integer> ballNumbers) {
        if (ballNumbers.size() != ballNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("서로 다른 값을 입력해주세요.");
        }
    }

    private void validateSize(List<Integer> ballNumbers) {
        if (ballNumbers.size() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }
    }

    public boolean hasSameValue(Ball ball) {
        if (balls.contains(ball)) {
            return true;
        }
        return false;
    }

    public boolean inSamePosition(int position, Ball otherBall) {
        return otherBall.equals(balls.get(position));
    }

    public Optional<Judgement> play(int position, Ball ball) {
        if (hasSameValue(ball)) {
            if (inSamePosition(position, ball)) {
                return Optional.of(Judgement.STRIKE);
            }
            return Optional.of(Judgement.BALL);
        }
        return Optional.empty();
    }

    public Result play(Balls playerBalls) {
        Result result = new Result();
        for (int i=0; i<3; i++) {
            result.report(play(i,playerBalls.ballOf(i)).orElse(Judgement.NOTHING));
        }
        return result;
    }

    private Ball ballOf(int i) {
        return balls.get(i);
    }
}
