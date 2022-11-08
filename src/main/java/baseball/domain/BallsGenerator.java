package baseball.domain;

public interface BallsGenerator {

    public String generateBalls(final int startInclusive, final int endInclusive);

    public String getRandomNumbers(final int startInclusive, final int endInclusive);

    public String setRandomNumbers(final int startInclusive, final int endInclusive);

}
