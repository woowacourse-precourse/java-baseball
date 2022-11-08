package baseball.gameRule;

public interface GameRule {
    void playByGameRule(String answer);
    boolean isStopCondition(String answer, String player);
}
