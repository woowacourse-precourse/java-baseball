package baseball.domain;

import baseball.domain.score.Score;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Referee {
    private final Map<BallStatus, Score> ballStatusScores;
    
    public Referee() {
        this(initBallStatusScores());
    }
    
    private Referee(Map<BallStatus, Score> ballStatusScores) {
        this.ballStatusScores = ballStatusScores;
    }
    
    private static Map<BallStatus, Score> initBallStatusScores() {
        return Arrays.stream(BallStatus.values())
                .filter(Predicate.not(BallStatus::isNothing))
                .collect(Collectors.toMap(
                        ballStatus -> ballStatus,
                        BallStatus::score,
                        (firstScore, secondScore) -> firstScore,
                        () -> new EnumMap<>(BallStatus.class)
                ));
    }
    
    public void decide(final List<BallStatus> ballStatuses) {
        ballStatuses.stream()
                .filter(Predicate.not(BallStatus::isNothing))
                .forEach(this::increaseScore);
    }
    
    private void increaseScore(final BallStatus ballStatus) {
        Score score = matchingBallScore(ballStatus);
        ballStatusScores.put(ballStatus, score.increase());
    }
    
    private Score matchingBallScore(final BallStatus ballStatus) {
        return ballStatusScores.get(ballStatus);
    }
    
    public boolean isBaseBallGameEnd() {
        Score score = matchingBallScore(BallStatus.STRIKE);
        return score.isGameEnd();
    }
    
    public List<Integer> scores() {
        return Arrays.stream(BallStatus.values())
                .filter(Predicate.not(BallStatus::isNothing))
                .map(ballStatusScores::get)
                .map(Score::score)
                .collect(Collectors.toList());
    }
    
    @Override
    public String toString() {
        return "Referee{" +
                "ballStatusScores=" + ballStatusScores +
                '}';
    }
}
