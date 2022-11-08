package domain;

public interface BallsGenerator {

//    int maxLen = 3;

    public String generateBalls(final int startInclusive, final int endInclusive);

    public String getRandomNumbers(final int startInclusive, final int endInclusive);

    public String setRandomNumbers(final int startInclusive, final int endInclusive);

}
