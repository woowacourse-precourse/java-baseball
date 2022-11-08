package baseball.gameRule;

public interface GameRule {
    void processComparing(String answer);
    boolean compareByRule(String answer, String player);
}
