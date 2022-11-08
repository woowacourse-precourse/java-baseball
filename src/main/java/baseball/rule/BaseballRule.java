package baseball.rule;


public interface BaseballRule {
    boolean check(int ball, int strike);

    void execute(int ball, int strike);
}
