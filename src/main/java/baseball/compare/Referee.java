package baseball.compare;

public class Referee {
    public static ComparisonResultType judge(Integer a, Integer b) {
        if (a.equals(b)) {
            return ComparisonResultType.STRIKE;
        }
        return ComparisonResultType.BALL;
    }
}
